<h1 align="center">
Elshoruk Library
</h1>
  <p align="center">
<img src="https://thehope-tech.com/images/posts/middle/2022/12/638da4aa65923.png" alt="AndroidLibray"/>
</p>
<p>
  In this project, the user creates an account or logs in, then a group of books suggested by the user is displayed by selecting a book through (the name of the book, the ID number of the book, the publishing house, 
  the edition number or through the author’s name), then the user can add the book and delete the book from the library.
</p>

## Preview
<div align="center">
<br/>
<img src="https://github.com/DoaaMosalam/ElShroukLibrary/assets/40686512/df69f70f-71fc-41a4-b7f1-342be63ddbdf"/>
 <P>Client.kts</P>
  
  ```groovy
class Client {
    private val users = mutableListOf<User>()
    private val library = Library()

    fun client() {
        println("Welcome to ElShrouk AddBooks")

        while (true) {
            println("Choose your Login Or Register:  ")
            println("1. Login")
            println("2. Register")
            println("3. Exit")
            print("Can you choose 1. Login, 2. Register, or 3. Exit: ")

            when (readlnOrNull()) {
                "1" -> login()
                "2" -> register()
                "3" -> {
                    println("Exiting the system.")
                    return
                }
                else -> println("Incorrect selection! Please try again.")
            }
        }
    }
```
<p>Library.kts</p>

```groovy


class Library {

    fun Library() {
        BooksStore.booksStore()
        val books = BooksStore.books
        printBooks(books)

        while (true) {
            println("\n Choose an option: ")
            println("1.findBookByIDAuthor And IDBook")
            println("2.findBooksByAuthorName: ");
            println("3.findBooksByBookNam: ");
            println("4.findBooksByDataPublisher: ");
            println("5.findBooksByHomePublisher: ");
            println("6.More/Exit:\n");

            println("Choice [1:5]>>")
      }
}
```
</div>
