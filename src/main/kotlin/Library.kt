package doaa.mosallam.book

import doaa.mosallam.book.LibraryCSVReader.printBooks

class Library {
    private val books = mutableListOf<Books>()

    init {
        // Assuming Credential.FilePath is defined elsewhere
        books.addAll(LibraryCSVReader.readLibraryBooks(Credential.FilePath))
    }

    fun Library() {
//        val booksCVS = LibraryCSVReader.readLibraryBooks(Credential.FilePath)
//        printBooks(booksCVS)

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

            when (readlnOrNull()) {
                "1" ->{
                    println("Enter book ID or author ID:")
                    val id = readLine()
                    if (id != null) {
                        val booksById = findInfoBookByID(books, id)
                        if (booksById.isEmpty()) {
                            println("No books found for ID: $id")
                        } else {
                            printBooks(booksById)
                        }
                    }
                }
                "2" -> {
                    println("Enter author name:")
                    val authorName = readLine()
                    if (authorName != null) {
                        val booksByAuthor = findBooksByAuthorName(books, authorName)
                        if (booksByAuthor.isEmpty()) {
                            println("No books found for author: $authorName")
                        } else {
                            printBooks(booksByAuthor)
                        }
                    }
                }

                "3" -> {
                    println("Enter book name:")
                    val bookName = readLine()
                    if (bookName != null) {
                        val booksByBookName = findBooksByBookName(books, bookName)
                        if (booksByBookName.isEmpty()) {
                            println("No books found with the name: $bookName")
                        } else {
                            printBooks(booksByBookName)
                        }
                    }
                }

                "4" -> {
                    println("Enter data publisher:")
                    val dataPublisher = readLine()
                    if (dataPublisher != null) {
                        val booksByDataPublisher = findBooksByDataPublisher(books, dataPublisher)
                        if (booksByDataPublisher.isEmpty()) {
                            println("No books found for data publisher: $dataPublisher")
                        } else {
                            printBooks(booksByDataPublisher)
                        }
                    }
                }

                "5" -> {
                    println("Enter Home publisher:")
                    val homePublisher = readLine()
                    if (homePublisher != null) {
                        val booksByDataPublisher = findBooksByHomePublisher(books, homePublisher)
                        if (booksByDataPublisher.isEmpty()) {
                            println("No books found for data publisher: $homePublisher")
                        } else {
                            printBooks(booksByDataPublisher)
                        }
                    }
                }
                "6" -> {
                    println("Would you like more orders? (yes/no)")
                    val response = readLine()
                    if (response.equals("yes", ignoreCase = true)) {
                        val request = RequestBooks()
                        println(request.requestBooks())
                    }
                    println("Exiting...")
                    return
                }

                else -> println("Invalid option.")

            }
        }
    }
//    private fun findInfoBookByID(books: List<Books>, id:String): String {
//        return (books.find { it.book == id }.toString())
//
//    }
    private fun findInfoBookByID(books: List<Books>, id:String):List<Books>{
        return books.filter { it.id.toString().contains(id,ignoreCase = true) || it.author.idAuthor.toString().contains(id,ignoreCase = true) }

    }
    private fun findBooksByAuthorName(books: List<Books>, authorName: String): List<Books> {
        return books.filter { it.author.nameAuthor.lowercase().contains(authorName, ignoreCase = true) }
    }

    private fun findBooksByBookName(books: List<Books>, bookName: String): List<Books> {
        return books.filter { it.book.lowercase().contains(bookName, ignoreCase = true) }
    }

    private fun findBooksByDataPublisher(books: List<Books>, dataPublisher: String): List<Books> {
        return books.filter { it.dataPublisher.equals(dataPublisher, ignoreCase = true) }
    }

    private fun findBooksByHomePublisher(books: List<Books>, homePublisher: String): List<Books> {
        return books.filter { it.homePublish.equals(homePublisher, ignoreCase = true) }
    }
}