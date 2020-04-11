## Introduction to GraphQL
GraphQL is an exciting new query language that's transforming the way we think about APIs. Used in production by 
Facebook, GitHub, and Shopify, it challenges RESTful API design by empowering consumers to query for exactly the 
information they need. In this talk, I will give an introduction to the query language, 
how GitHub uses it internally with Ruby and Rails, and the lessons they learned launching their GraphQL API externally.

The GraphQL specification: https://graphql.github.io/graphql-spec/

## Quick Setup
```shell script
git clone https://github.com/amarflybot/GraphQlTalk.git
cd GraphQlTalk
./mvnw clean install
./mvnw spring-boot:run
```
This shall start the server at 9111 port.

## Endpoints of Interest
Spring data JPA entities list: http://localhost:9111/graphqltalk

Graphql Playground: http://localhost:9111/graphqltalk/playground

Graphql Voyager: http://localhost:9111/graphqltalk/voyager

### Schema produced from this endpoint
<details><summary>CLICK ME</summary>
<p>

```graphql
directive @defer on FIELD
type Address {
  city: String
  country: String
  id: Long
  streetAddress: String
  streetAddressNumber: String
  streetName: String
  users: [User]
  zipCode: String
}

type Artist {
  awardWon: String
  contents: [Content]
  dateOfBirth: Date
  gender: String
  id: Long
  name: String
}

type Content {
  artists: [Artist]
  description: String
  genre: String
  id: Long
  thumbnail: String
  title: String
  users: [User]
}

scalar Date

scalar Long

type Plan {
  id: Long
  name: String
  planPrice: Float
  subscription: Subscription
  type: String
}

type Query {
  findAddressById(id: Long): Address
  findAllSubscriptionById(id: Long): Subscription
  findAllPlans: [Plan]
  findAllSubscription: [Subscription]
  findPlanById(id: Long): Plan
  findAllAddresses: [Address]
  findContentById(id: Long): Content
  findUserById(id: Long): User
  findAllContents: [Content]
  findAllUsers: [User]
  findArtistById(id: Long): Artist
  findAllArtists: [Artist]
}

type Subscription {
  endDate: Date
  id: Long!
  plan: Plan
  startDate: Date
  users: [User]
}

scalar UNREPRESENTABLE

type User {
  addresses: [Address]
  dateOfBirth: Date
  gender: String
  id: Long
  name: String
  placeOfBirth: String
  recentlyWatched: [Content]
  subscription: [Subscription]
}

```

</p>
</details>

#### Sample Query for Playground
```graphql
{
  findUserById(id: 68) {
    name
    gender
    dateOfBirth
    addresses {
      streetName
      city
      country
    }
    subscription {
      startDate
      endDate
      plan {
        name
        planPrice
      }
    }
    recentlyWatched {
      title
      genre
      artists {
        name
        awardWon
      }
    }
  }
}
```

## Tech Stack Used
```$xslt
spring-boot-starter-web
spring-boot-starter-data-jpa
spring-boot-starter-data-rest
graphql-spqr-spring-boot-starter
graphql-spring-boot-starter
playground-spring-boot-starter
h2
```
