package com.laika.application.shared.infrastructure.persistence.hibernate;

import com.laika.application.shared.domain.Identifier;
import com.laika.application.shared.domain.criteria.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaQuery;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class HibernateRepository<T> {
    protected final SessionFactory                sessionFactory;
    protected final Class<T>                      aggregateClass;
    protected final HibernateCriteriaConverter<T> criteriaConverter;
    private         Session                       session;

    public HibernateRepository(SessionFactory sessionFactory, Class<T> aggregateClass) {
        this.sessionFactory    = sessionFactory;
        this.aggregateClass    = aggregateClass;
        this.criteriaConverter = new HibernateCriteriaConverter<>(sessionFactory.getCriteriaBuilder());
    }

    protected Session getSession() {
        return session;
    }

    protected void openSession() {
        this.session = sessionFactory.openSession();
        this.session.beginTransaction();
    }

    protected void closeSession() {
        this.session.close();
    }

    protected void persist(T entity) {
        this.openSession();
        this.getSession().saveOrUpdate(entity);
        this.getSession().flush();
        this.getSession().clear();
        this.closeSession();
    }

    protected Optional<T> byId(Identifier id) {
        try {
            this.openSession();
            return Optional.ofNullable(this.getSession().byId(aggregateClass).load(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeSession();
        }

        return Optional.empty();
    }

    protected List<T> byCriteria(Criteria criteria) {
        try {
            this.openSession();

            CriteriaQuery<T> hibernateCriteria = criteriaConverter.convert(criteria, aggregateClass);

            return this.getSession().createQuery(hibernateCriteria).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeSession();
        }

        return Collections.emptyList();
    }

    protected List<T> all() {
        try {
            this.openSession();

            CriteriaQuery<T> criteria = this.getSession().getCriteriaBuilder().createQuery(this.aggregateClass);

            criteria.from(this.aggregateClass);

            return this.getSession().createQuery(criteria).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeSession();
        }

        return Collections.emptyList();
    }
}
