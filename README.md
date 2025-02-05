# CRUDIFY-SPRINGBOOT
A Spring Boot application that provides CRUD operations for managing books, using an H2 in-memory database. Users can add, update, delete, and retrieve books by ID and author.


## 🛠️ Features
✅ Create new books 📖  
✅ Read book details 🔍  
✅ Update existing book records ✏️  
✅ Delete books from the database by ID/author ❌  
✅ H2 Database for lightweight, in-memory storage 💾  

## ⚙️ Tech Stack
- Spring Boot (REST API)
- Spring Data JPA (Database operations)
- H2 Database (In-memory storage)
- Postman (For API testing)

## 📦 Installation & Setup
### 1️⃣ Clone the Repository

```
git clone https://github.com/your-username/crudify-springboot.git
cd crudify-springboot
```
## 2️⃣ Run the Application
```
mvn spring-boot:run
```
OR
```
cd target
java -jar <your-jar-file>.jar
```
The application will start on `http://localhost:9090`.  

## 🛠️ API Endpoints

| Method     | Endpoint                      | Description           | **Request Body** (Example) |
|------------|-------------------------------|-----------------------|----------------------------|
| **POST**   | `/addBook`                    | Add a new book        |`{ "title": "Book1", "author": "Shranjay" }`|
| **GET**    | `/books`                      | Get all books         |_No Body Required_ |
| **GET**    | `/getBookById/{id}`           | Get book by ID        |_No Body Required_ | 
| **PUT**    | `/updateBookById/{id}`        | Update book details   |`{ "title": "Book2", "author": "G. Bale" }`|
| **DELETE** | `/deleteBookById/{id}`        | Delete book by ID     |_No Body Required_|
| **DELETE** | `/deleteBookByAuthor/{author}`| Delete book by Author |_No Body Required_|

