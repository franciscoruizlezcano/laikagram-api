### Features 🤯

- Support SpringBoot
- Support Hibernate ORM Core 5
- Criteria API for Hibernate
- Repository InMemory
- Application layer decoupling from the SpringBoot & Hibernate frameworks
- Swagger documentation
- Upload media with Firebase 

# Laikagram API 
Instagram clone open source

##Deploy
https://laikagram-api.herokuapp.com/

##D.E.R
![](/docs/der.png)
##Project base 
[monolith-clean-architecture](https://github.com/franciscoruizlezcano/monolith-clean-architecture "monolith-clean-architecture")

##HTTP Objects Request and Responses
###User

####PUT
``` 
/users/{id}
```

##### REQUEST BODY
```
{
    "username" : "",
    "password" : "",
    "url_photo" : ""
}
```

####GET BY ID
``` 
/users/{id}
```

##### REQUEST BODY
```
{
    "id" : ""
    "username" : "",
    "url_photo" : ""
}
```
####GET BY CRITERIA
``` 
/users
```
##### REQUEST BODY
```
{
    "filters":[
        {
            "field" : ""
            "operator" : ""
            "value" : ""
        },
    ],
    "limit" : 1,
    "order_by" : "",
    "order" : "",
    "offset" : ""   
}
```
##### RESPONSE BODY

```
[
    {
        "id" : "",
        "username" : "",
        "url_photo" : ""
    },
]
```
####Post

####PUT
``` 
/posts/{id}
```
##### REQUEST BODY
```
{
    "url_media" : "",
    "caption" : "",
    "user_id : "
}                        
```
####GET BY ID
``` 
/posts/{id}
```
##### RESPONSE BODY

```
{
    "url_media" : "",
    "caption" : "",
    "user" : {
                "id" : "",
                "username" : "",
                "url_photo" : ""
            }
}
``` 

#### GET BY CRITERIA

``` 
/posts
```
##### REQUEST BODY
```
{
    "filters":[
        {
            "field" : ""
            "operator" : ""
            "value" : ""
        },
    ],
    "limit" : 1,
    "order_by" : "",
    "order" : "",
    "offset" : ""
}
```
##### RESPONSE BODY

```
[
    {
        "url_media" : "",            
        "caption" : "",
        "user" : {
                    "id" : "",
                    "username" : "",
                    "url_photo" : ""
                }
    }
]
```


####Follow

####PUT
```
/follows/{id}
```

##### REQUEST BODY
```
{
    "followed_id" : "",
    "follower_id" : ""
}
```
####GET BY ID

```
/follows/{id}
```
##### RESPONSE BODY

```
{
    "id" : ""
    "followed" : {
                    "id" : "",
                    "username" : "",
                    "url_photo" : ""
                 },
    "follower" : {
                    "id" : "",
                    "username" : "",
                    "url_photo" : ""
                }
}
```
####GET BY CRITERIA
```
/follows
```
##### REQUEST BODY
```
{
    "filters":[
        {
            "field" : ""
            "operator" : ""
            "value" : ""
        },
    ],
    "limit" : 1,
    "order_by" : "",
    "order" : "",
    "offset" : ""   
}
```
##### RESPONSE BODY
```
[
    {
        "id" : ""
        "followed" : {
                        "id" : "",
                        "username" : "",
                        "url_photo" : ""
                     },
        "follower" : {
                        "id" : "",
                        "username" : "",
                        "url_photo" : ""
                    }
    }
]
```

###Project structure tree

```
main
    ├── java
    │   └── com
    │       └── laika
    │           └── laikagram
    │               ├── follow
    │               │   ├── application
    │               │   │   ├── counter
    │               │   │   │   └── FollowCounter.java
    │               │   │   ├── CreateFollow.java
    │               │   │   ├── creator
    │               │   │   │   └── FollowCreator.java
    │               │   │   ├── deletor
    │               │   │   │   └── FollowDeletor.java
    │               │   │   ├── FollowResponse.java
    │               │   │   ├── FollowsResponse.java
    │               │   │   ├── search_all
    │               │   │   │   └── FollowsSearcher.java
    │               │   │   └── search_by_criteria
    │               │   │       ├── FollowByQuerySearcher.java
    │               │   │       └── FollowsByCriteriaSearcher.java
    │               │   ├── domain
    │               │   │   ├── FollowId.java
    │               │   │   ├── Follow.java
    │               │   │   ├── FollowNotExist.java
    │               │   │   └── FollowRepository.java
    │               │   └── infrastructure
    │               │       ├── persistence
    │               │       │   ├── hibernate
    │               │       │   │   └── Follow.hbm.xml
    │               │       │   ├── HibernateFollowRepository.java
    │               │       │   └── InMemoryFollowRepository.java
    │               │       └── web
    │               │           ├── FollowGetController.java
    │               │           ├── FollowPutController.java
    │               │           └── FollowsGetController.java
    │               ├── post
    │               │   ├── application
    │               │   │   ├── CreatePost.java
    │               │   │   ├── creator
    │               │   │   │   └── PostCreator.java
    │               │   │   ├── PostResponse.java
    │               │   │   ├── PostsResponse.java
    │               │   │   ├── search_all
    │               │   │   │   └── PostsSearcher.java
    │               │   │   └── search_by_criteria
    │               │   │       ├── PostByQuerySearcher.java
    │               │   │       └── PostsByCriteriaSearcher.java
    │               │   ├── domain
    │               │   │   ├── PostId.java
    │               │   │   ├── Post.java
    │               │   │   ├── PostNotExist.java
    │               │   │   └── PostRepository.java
    │               │   └── infrastructure
    │               │       ├── persistence
    │               │       │   ├── hibernate
    │               │       │   │   └── Post.hbm.xml
    │               │       │   ├── HibernatePostRepository.java
    │               │       │   └── InMemoryPostRepository.java
    │               │       └── web
    │               │           ├── PostGetController.java
    │               │           ├── PostPutController.java
    │               │           └── PostsGetController.java
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
    │               │   │   │   ├── OrderType.java
    │               │   │   │   └── ParseFiltersUtil.java
    │               │   │   ├── DomainError.java
    │               │   │   ├── Identifier.java
    │               │   │   ├── IntValueObject.java
    │               │   │   ├── media
    │               │   │   │   ├── FailedUploadException.java
    │               │   │   │   └── MediaService.java
    │               │   │   ├── repository
    │               │   │   │   ├── MatchingRepository.java
    │               │   │   │   ├── Repository.java
    │               │   │   │   ├── SaveRepository.java
    │               │   │   │   └── SearchRepository.java
    │               │   │   ├── StringValueObject.java
    │               │   │   ├── util
    │               │   │   │   ├── DateUtil.java
    │               │   │   │   ├── JsonUtil.java
    │               │   │   │   ├── ReadPropertiesFileUtil.java
    │               │   │   │   └── StringUtil.java
    │               │   │   └── UuidGenerator.java
    │               │   └── infrastructure
    │               │       ├── JavaUuidGenerator.java
    │               │       ├── media
    │               │       │   └── firebase
    │               │       │       ├── FirebaseHttpParam.java
    │               │       │       └── FirebaseStorageMediaService.java
    │               │       ├── persistence
    │               │       │   ├── hibernate
    │               │       │   │   ├── HibernateConfigurationFactory.java
    │               │       │   │   ├── HibernateCriteriaConverter.java
    │               │       │   │   └── HibernateRepository.java
    │               │       │   └── memory
    │               │       │       └── InMemoryRepository.java
    │               │       └── web
    │               │           └── spring
    │               │               ├── config
    │               │               │   ├── ExceptionsHandler.java
    │               │               │   └── SwaggerConfig.java
    │               │               ├── ErrorMessage.java
    │               │               ├── IndexController.java
    │               │               └── MediaController.java
    │               ├── Starter.java
    │               └── user
    │                   ├── application
    │                   │   ├── CreateUser.java
    │                   │   ├── creator
    │                   │   │   └── UserCreator.java
    │                   │   ├── search_all
    │                   │   │   └── UsersSearcher.java
    │                   │   ├── search_by_criteria
    │                   │   │   ├── UserByQuerySearcher.java
    │                   │   │   └── UsersByCriteriaSearcher.java
    │                   │   ├── UserResponse.java
    │                   │   └── UsersResponse.java
    │                   ├── domain
    │                   │   ├── UserId.java
    │                   │   ├── User.java
    │                   │   ├── UserNotExist.java
    │                   │   └── UserRepository.java
    │                   └── infrastructure
    │                       ├── persistence
    │                       │   ├── hibernate
    │                       │   │   └── User.hbm.xml
    │                       │   ├── HibernateUserRepository.java
    │                       │   └── InMemoryUserRepository.java
    │                       └── web
    │                           ├── UserGetController.java
    │                           ├── UserPutController.java
    │                           └── UsersGetController.java
    └── resources
        └── log4j2.xml

```
