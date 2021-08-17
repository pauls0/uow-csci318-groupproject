# csci318 Project

Online Ordering Application using a microservices architecture in Java Spring Boot.

<img src="https://img.shields.io/badge/Java-Language-blue?logo=java" alt="Java logo" height="25" /> &nbsp;
<img src="https://img.shields.io/badge/Apache Maven-Dependancy Management-blue?logo=apachemaven" alt="Apache Maven logo" height="25" />&nbsp;
<img src="https://img.shields.io/badge/Spring Boot-Framework-blue?logo=springboot" alt="Spring Boot logo" height="25" />&nbsp;
<img src="https://img.shields.io/badge/Prettier-Linter-blue?logo=prettier" alt="Prettier logo" height="25" />&nbsp;
<img src="https://img.shields.io/badge/Checkstyle-Static Analysis-blue?logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH3wYNFQA6jneRDgAAAHJJREFUOMtj/P//PwMKuHoDIXDnHgMG8PdiROYyMVAIKDaAEcMLJAIWDJHXjAgTH2HRYfx/kIXBqAFYDPjLfhTBVj3K8FcVlU9UQvr76RjW1MXMZ8VIlBewKcQmhj8pMzKiSvz/z0haICJrwKGZgYGBAQB3gCgnMKfrxgAAAABJRU5ErkJggg==" alt="Checkstyle logo" height="25" />&nbsp;
<img src="https://img.shields.io/badge/Git-Version Control-blue?logo=git" alt="Git logo" height="25" />&nbsp;
<img src="https://img.shields.io/badge/Mermaid-Documentation-blue?logo=data:image/png;base64,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" alt="Mermaid logo" height="25" />&nbsp;

---
### Demonstration

#### Return all customers
```bash
curl -X GET http://localhost:8080/customers
```
```JSON
[
  {
    "id": 1,
    "companyName": "Apple",
    "address": "1 Apple Park Way, Cupertino, CA 95014",
    "country": "USA",
    "contact": {
      "id": 2,
      "name": "Tim Apple",
      "phone": "123456",
      "email": "tim@apple.com",
      "position": "CEO"
    }
  },
  {
    "id": 3,
    "companyName": "SpaceX",
    "address": "42 Galactic Drive, San Francisco, CA 97468",
    "country": "USA",
    "contact": {
      "id": 4,
      "name": "Elon Musk",
      "phone": "69420",
      "email": "elon@spacex.com",
      "position": "CEO"
    }
  }
]
```


#### Return a specific customer
```bash
curl -X GET http://localhost:8080/customers/1
```
```JSON
{
  "id": 1,
  "companyName": "Apple",
  "address": "1 Apple Park Way, Cupertino, CA 95014",
  "country": "USA",
  "contact": {
    "id": 2,
    "name": "Tim Apple",
    "phone": "123456",
    "email": "tim@apple.com",
    "position": "CEO"
  }
}
```


#### Create a new customer
```bash
curl -X POST -H "Content-Type:application/json" -d '{"companyName":"Google","address":"1600 Amphitheatre Parkway, Mountain View, California","country":"USA","contact":{"name": "Test Testerson","phone": "0400000000", "email": "mail@example.com","position": "CEO"}}' http://localhost:8080/customers
```
```bash
curl -X GET http://localhost:8080/customers
```
```JSON
[
  {
    "id": 1,
    "companyName": "Apple",
    "address": "1 Apple Park Way, Cupertino, CA 95014",
    "country": "USA",
    "contact": {
      "id": 2,
      "name": "Tim Apple",
      "phone": "123456",
      "email": "tim@apple.com",
      "position": "CEO"
    }
  },
  {
    "id": 3,
    "companyName": "SpaceX",
    "address": "42 Galactic Drive, San Francisco, CA 97468",
    "country": "USA",
    "contact": {
      "id": 4,
      "name": "Elon Musk",
      "phone": "69420",
      "email": "elon@spacex.com",
      "position": "CEO"
    }
  },
  {
    "id": 5,
    "companyName": "Google",
    "address": "1600 Amphitheatre Parkway, Mountain View, California",
    "country": "USA",
    "contact": {
      "id": 6,
      "name": "Test Testerson",
      "phone": "0400000000",
      "email": "mail@example.com",
      "position": "CEO"
    }
  }
]
```


#### Update exisiting customer/contact
```bash
curl -X GET http://localhost:8080/customers/1
```
```JSON
{
  "id": 1,
  "companyName": "Apple",
  "address": "1 Apple Park Way, Cupertino, CA 95014",
  "country": "USA",
  "contact": {
    "id": 2,
    "name": "Tim Apple",
    "phone": "123456",
    "email": "tim@apple.com",
    "position": "CEO"
  }
}
```
```bash
curl -X PUT -H "Content-Type:application/json" -d '{"companyName": "Apple","address": "1 Apple Park Way, Cupertino, CA 95014","country": "USA","contact": {"id": 2,"name": "Tim Cook","phone": "123456","email": "tim@apple.com","position": "CEO}}' http://localhost:8080/customers/1
```
```bash
curl -X GET http://localhost:8080/customers/1
```
```JSON
{
  "id": 1,
  "companyName": "Apple",
  "address": "1 Apple Park Way, Cupertino, CA 95014",
  "country": "USA",
  "contact": {
    "id": 2,
    "name": "Tim Cook",
    "phone": "123456",
    "email": "tim@apple.com",
    "position": "CEO"
  }
}
```

---

### Architecture

- REST
- microservices

| Java Dependancies                                                                              |                               |
| ---------------------------------------------------------------------------------------------- | ----------------------------- |
| [Spring Web](https://mvnrepository.com/artifact/org.springframework/spring-web)                | RESTful web apps              |
| [Spring Data JPA](https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa) | allows persistant data as SQL |
| [H2 Database](https://mvnrepository.com/artifact/com.h2database/h2)                            | SQL database stored in-memory |

Classes:

<!-- generated by mermaid compile action - START -->

![~mermaid diagram 1~](/.resources/README-md-1.svg)

<details>
  <summary>Mermaid markup</summary>

```mermaid
classDiagram
    class Customer{
        +String companyName
        +String address
        +String country
        +someMethod()
    }
    class Contact{
        +String name
        +String phone
        +String email
        +String position
        -someMethod()
    }
    Customer --> "1..*" Contact : has contact
```

</details>
<!-- generated by mermaid compile action - END -->

---

### Screenshots

Demo Site: [demo.example.com](demo.example.com)

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)
![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)
