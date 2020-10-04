package com.laika.laikagram.post.domain;

import com.laika.laikagram.user.domain.User;

import java.util.Objects;

public final class Post {
    private final PostId id;
    private final String urlMedia;
    private final String caption;
    private final User   user;

    public Post(PostId id, String urlMedia, String caption, User user) {
        this.id       = id;
        this.urlMedia = urlMedia;
        this.caption  = caption;
        this.user     = user;
    }

    public Post() {
        this.id       = null;
        this.urlMedia = null;
        this.caption  = null;
        this.user     = null;
    }

    public PostId id() {
        return id;
    }

    public String urlMedia() {
        return urlMedia;
    }

    public String caption() {
        return caption;
    }

    public User user() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(urlMedia, post.urlMedia) &&
                Objects.equals(caption, post.caption) &&
                Objects.equals(user, post.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, urlMedia, caption, user);
    }
}
