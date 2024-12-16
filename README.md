# Spring Boot & GraphQL Starter Project

This project is a **starter template** for building a GraphQL API using Spring Boot. It provides a lightweight, efficient, and flexible way to create APIs for modern applications.

## Features
- **Spring Boot** for rapid development
- **GraphQL Java Tools** for schema and query handling
- **Postman Integration** for API testing
- Custom Exception Handling for improved error responses
- Lightweight setup with Java Records for models

---

## Prerequisites

### Tools Needed:
- **Java 17** or higher
- **Maven**
- **Postman** for testing (optional, but recommended)
- **An IDE** (IntelliJ, Eclipse, VSCode, etc.)

### Dependencies:
Make sure to include the following dependencies in your `pom.xml`:
```xml
<dependencies>
    <!-- Spring Boot Starter for GraphQL -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-graphql</artifactId>
    </dependency>
    
    <!-- Spring Boot Starter for Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Starter Test -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

## How to Run

### Clone the Repository:
```bash
git clone <repository-url>
cd <project-directory>
```

### Build the Project:
```bash
mvn clean install
```

### Run the Application:
```bash
mvn spring-boot:run
```

### Access GraphQL Playground:
By default, the GraphQL Playground will be available at:  
`http://localhost:8080/graphiql`

---

## Sample GraphQL Schema and Queries

### Schema Example:
```graphql
type Query {
    getAllPlayers: [Player]
    getPlayerById(id: ID!): Player
}

type Mutation {
    addPlayer(name: String!, team: Team!): Player
    deletePlayer(id: ID!): Boolean
}

type Player {
    id: ID!
    name: String
    team: Team
}

enum Team {
    MI
    CSK
    RCB
    DC
    PBKS
    RR
    SRH
    GT
    KKR
}
```

### Query Example:
```graphql
query {
  getPlayerById(id: 1) {
    id
    name
    team
  }
}
```

### Mutation Example:
```graphql
mutation {
  addPlayer(name: "John Doe", team: MI) {
    id
    name
    team
  }
}
```

---

## Project Structure

```
├── src/main/java/com/example/graphql
│   ├── controller
│   │   └── PlayerController.java       # Handles GraphQL queries and mutations
│   ├── service
│   │   └── PlayerService.java          # Business logic for players
│   ├── model
│   │   └── Player.java                 # Player model using Java Records
│   ├── exception
│       └── PlayerNotFoundException.java # Custom exceptions for better error handling
├── src/main/resources
│   └── graphql
│       └── schema.graphqls             # The GraphQL schema definition
├── pom.xml                             # Maven dependencies
```

---

## Postman Collection for Testing

Use Postman to test the API. Here’s how:
1. Open Postman.
2. Create a new POST request to: `http://localhost:8080/graphql`
3. Add a JSON body with your query. Example:
   ```json
   {
     "query": "query { getPlayerById(id: 1) { id name team } }"
   }
   ```

---

## Learn More
- Official Spring Boot Documentation: [Spring Boot](https://spring.io/projects/spring-boot)
- Official GraphQL Documentation: [GraphQL](https://graphql.org)
- Spring for GraphQL Docs: [Spring GraphQL](https://spring.io/projects/spring-graphql)

---

## License
This project is licensed under the MIT License. Feel free to use it as a starter for your GraphQL adventures!
