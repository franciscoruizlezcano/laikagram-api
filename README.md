### Features 🤯

- Support SpringBoot
- Support Hibernate ORM Core 5
- Criteria API for Hibernate
- Repository InMemory
- Application layer decoupling from the SpringBoot & Hibernate frameworks
- Swagger documentation
- Upload media with Firebase 

# Monolith Clean Architecture 

![](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fcdn-images-1.medium.com%2Fmax%2F1200%2F1*B7LkQDyDqLN3rRSrNYkETA.jpeg&f=1&nofb=1)



#Purpose of this Repository 🤟
- Showing how you can implement a monolith application in a modular way
- Showing the application of best practices and object-oriented programming principles
- SOLID Principles
- Presentation of the use of design patterns. When, how and why they can be used
- Application decoupling from the frameworks


##Project structure tree

```
└── main
    ├── java
    │   └── com
    │       └── laika
    │           └── application
    │               ├── shared
    │               │   ├── application
    │               │   │   └── media
    │               │   │       └── UploadMedia.java
    │               │   ├── domain
    │               │   │   ├── Command.java
    │               │   │   ├── criteria
    │               │   │   │   ├── Criteria.java
    │               │   │   │   ├── FilterField.java
    │               │   │   │   ├── Filter.java
    │               │   │   │   ├── FilterOperator.java
    │               │   │   │   ├── Filters.java
    │               │   │   │   ├── FilterValue.java
    │               │   │   │   ├── OrderBy.java
    │               │   │   │   ├── Order.java
    │               │   │   │   └── OrderType.java
    │               │   │   ├── DomainError.java
    │               │   │   ├── Identifier.java
    │               │   │   ├── IntValueObject.java
    │               │   │   ├── media
    │               │   │   │   ├── FailedUploadException.java
    │               │   │   │   └── MediaService.java
    │               │   │   ├── StringValueObject.java
    │               │   │   ├── util
    │               │   │   │   ├── DateUtil.java
    │               │   │   │   ├── JsonUtil.java
    │               │   │   │   ├── PackageUtil.java
    │               │   │   │   ├── ReadPropertiesFileUtil.java
    │               │   │   │   └── StringUtil.java
    │               │   │   └── UuidGenerator.java
    │               │   └── infrastructure
    │               │       ├── JavaUuidGenerator.java
    │               │       ├── media
    │               │       │   └── firebase
    │               │       │       ├── FirebaseStorageMediaService.java
    │               │       │       └── ParamEnum.java
    │               │       ├── persistence
    │               │       │   ├── hibernate
    │               │       │   │   ├── HibernateConfigurationFactory.java
    │               │       │   │   ├── HibernateCriteriaConverter.java
    │               │       │   │   └── HibernateRepository.java
    │               │       │   └── memory
    │               │       │       └── InMemoryRepository.java
    │               │       └── web
    │               │           └── spring
    │               │               ├── docs
    │               │               │   └── SwaggerConfig.java
    │               │               └── IndexController.java
    │               ├── Starter.java
    │               └── user
    │                   ├── application
    │                   │   ├── CreateUser.java
    │                   │   ├── creator
    │                   │   │   └── UserCreator.java
    │                   │   ├── searcher
    │                   │   │   ├── AllUsersSearcher.java
    │                   │   │   ├── ByIdUserSearcher.java
    │                   │   │   ├── ByUsernameUserSearcher.java
    │                   │   │   └── LastUsersSearcher.java
    │                   │   ├── updater
    │                   │   │   └── UserUpdater.java
    │                   │   ├── UserRequest.java
    │                   │   ├── UserResponse.java
    │                   │   └── UsersResponse.java
    │                   ├── domain
    │                   │   ├── UserId.java
    │                   │   ├── User.java
    │                   │   ├── UserNotExist.java
    │                   │   ├── UserRepository.java
    │                   │   └── UserUsername.java
    │                   └── infrastructure
    │                       ├── persistence
    │                       │   ├── hibernate
    │                       │   │   └── User.hbm.xml
    │                       │   ├── HibernateUserRepository.java
    │                       │   └── InMemoryUserRepository.java
    │                       └── web
    │                           ├── GetAllUsersController.java
    │                           ├── GetByIdUserController.java
    │                           ├── GetByUsernameUserController.java
    │                           ├── GetLastUsersController.java
    │                           ├── PostUserController.java
    │                           └── PutUserController.java
    └── resources
        ├── app.properties
        └── log4j2.xml

```

## Layers🕵
The application is structured in a "who are you" way, that is, it will have as many packages in the main root as there are use cases

Each use case package is divided by domain, application, and infrastructure.

### Domain
Here will go all the domains of our application such as:
- Entities and object mappers of domain
- Exceptions of domain
- Entitie Repository interface

In this layer you can only access the application layer

*Example: * User module

```
user.
├─ domain
   ├── UserId.java
   ├── User.java
   ├── UserNotExist.java
   ├── UserRepository.java
   └── UserUsername.java

```

### Application
Here will go all:
- Bussiness logic
- Injection dependecies
- Access to domain layer
- DTOs for clients 

In this layer you can only access the infrastructure layer

`
```
├── application
   ├── CreateUser.java
   ├── creator
   │   └── UserCreator.java
   ├── searcher
   │   ├── AllUsersSearcher.java
   │   ├── ByIdUserSearcher.java
   │   ├── ByUsernameUserSearcher.java
   │   └── LastUsersSearcher.java
   ├── updater
   │   └── UserUpdater.java
   ├── UserRequest.java
   ├── UserResponse.java
   └── UsersResponse.java

```

### Infrastructure
Here will go all:
- XML Mapping entities of Hibernate
- Spring REST Controller
- Hibernate configuration
- InMemory Configuration

This layer will only have contact with the outside world and the events of the application

```
└── infrastructure
    ├── persistence
    │   ├── hibernate
    │   │   └── User.hbm.xml
    │   ├── HibernateUserRepository.java
    │   └── InMemoryUserRepository.java
    └── web
        ├── GetAllUsersController.java
        ├── GetByIdUserController.java
        ├── GetByUsernameUserController.java
        ├── GetLastUsersController.java
        ├── PostUserController.java
        └── PutUserController.java

```

## Shared module
```
.
├── application
│   └── media
│       └── UploadMedia.java
├── domain
│   ├── Command.java
│   ├── criteria
│   │   ├── Criteria.java
│   │   ├── FilterField.java
│   │   ├── Filter.java
│   │   ├── FilterOperator.java
│   │   ├── Filters.java
│   │   ├── FilterValue.java
│   │   ├── OrderBy.java
│   │   ├── Order.java
│   │   └── OrderType.java
│   ├── DomainError.java
│   ├── Identifier.java
│   ├── IntValueObject.java
│   ├── media
│   │   ├── FailedUploadException.java
│   │   └── MediaService.java
│   ├── StringValueObject.java
│   ├── util
│   │   ├── DateUtil.java
│   │   ├── JsonUtil.java
│   │   ├── PackageUtil.java
│   │   ├── ReadPropertiesFileUtil.java
│   │   └── StringUtil.java
│   └── UuidGenerator.java
└── infrastructure
    ├── JavaUuidGenerator.java
    ├── media
    │   └── firebase
    │       ├── FirebaseStorageMediaService.java
    │       └── ParamEnum.java
    ├── persistence
    │   ├── hibernate
    │   │   ├── HibernateConfigurationFactory.java
    │   │   ├── HibernateCriteriaConverter.java
    │   │   └── HibernateRepository.java
    │   └── memory
    │       └── InMemoryRepository.java
    └── web
        └── spring
            ├── docs
            │   └── SwaggerConfig.java
            └── IndexController.java


```
