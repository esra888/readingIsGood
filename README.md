## Reading Is Good Rest API 📙 📚

This API mainly created for manage online book shopping services and transactions.

### Requiremets 🔧

- Java version 11 or higher,
- Maven,
- H2 Database, 
- JPA,
- (Please take a look at pom.xml file for other dependencies.)

## Installation 🔌

1. Press the Fork button (top right the page) to save copy of this project on your account.
2. Download the repository files (project) from the download section or clone this project by typing in the bash the following command:

```
git clone https://github.com/esra888/readingIsGood.git
```

1. Import it in Intellij IDEA or any other Java IDE.
2. Run the application 🤞

### Available Services

| HTTP METHOD | PATH                               | USAGE                                                        |
| ----------- | ---------------------------------- | ------------------------------------------------------------ |
| GET         | /customers        | get all customers       |
| GET         | /customers/{customerId}/orders        | get all oders of the customer       |
| POST        | /customers/createCustomer | if customer's mail address not existed or customer's number of orders greater than zero then creates new customer |
|          |        |      |
| GET         | /books        | get all books       |
| POST         | /books/createBook        | creates new book      |
|          |        |      |
| GET         | /orders        | get all orders       |
| GET         | /orders/{id}        | get oders by id       |
| POST        | /orders/{bookId}/orders | create orders and update books entity |
| GET        | /orders/{startDate}/{endDate}/betweenDates | list orders by date interval(startDate - endDate) |
|          |        |      |
| POST         | /statistics/customers/{customerId}/statistics       | create statistic       |


### Http Status

- 200 OK: The request has succeeded
- 403 Forbidden : The server understood the request, but is refusing to authorize it. 
- 400 Bad Request: The request could not be understood by the server
- 404 Not Found: The requested resource cannot be found
- 500 Internal Server Error: The server encountered an unexpected condition.

