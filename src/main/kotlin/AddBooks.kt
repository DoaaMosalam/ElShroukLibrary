package doaa.mosallam.book

import doaa.mosallam.book.LibraryCSVReader.printBooks

class RequestBooks {

    fun requestBooks() {
//        val books = LibraryCSVReader.readLibraryBooks(Credential.FilePath)
//        LibraryCSVReader.printBooks(books)
        BooksStore.booksStore()
        val books = BooksStore.books
        printBooks(books)
        while (true) {
            println("\nChoose an option:")
            println("1.Add author book.");
            println("2.Add name book.");
            println("3.Add Home of publich: ");
            println("4.Add Data of publich: ");
            println("5.Add Id book");
            println("6.Add Number of Version Book: ");
            println("7. Delete author by id: ");
            println("8.Exit:\n");

            println("Choice [1:8]>>")
            when (readLine()) {
                "1" -> addAuthor(books)
                "2" -> addBookName(books)
                "3" -> addHomePublish(books)
                "4" -> addDataPublish(books)
                "5" -> addBookId(books.toMutableList())
                "6" -> addNumVersion(books.toMutableList())
                "7" -> deleteAuthorById(books.toMutableList())
                "8" -> {
                    println("Exiting...")
                    return
                }

                else -> println("Invalid option.")

            }
        }
    }


    private fun addAuthor(books: MutableList<Books>) {
        println("Enter author ID:")
        val id = readLine()?.toLongOrNull()
        println("Enter author name:")
        val name = readLine()
        println("Enter author email:")
        val email = readLine()

        if (id != null && name != null && email != null) {
            val newAuthor = Author(id, name, email)
            println("Enter book ID to associate with this author:")
            val bookId = readLine()?.toLongOrNull()
            val book = books.find { it.id == bookId }
            if (book != null) {
                book.author = newAuthor
                println("Author added to the existing book successfully!")
            } else if (bookId != null) {
                println("No book found with ID: $bookId. Do you want to create a new book with this ID? (yes/no)")
                val response = readLine()
                if (response.equals("yes", ignoreCase = true)) {
                    println("Enter book name:")
                    val bookName = readLine() ?: ""
                    println("Enter home of publish:")
                    val homePublish = readLine() ?: ""
                    println("Enter date of publish:")
                    val dataPublish = readLine() ?: ""
                    println("Enter number of versions:")
                    val numVersion = readLine()?.toIntOrNull() ?: 1

                    val newBook = Books(bookId, bookName, homePublish, dataPublish, numVersion, newAuthor)
                    books.add(newBook)
                    println("New book with author created successfully!")
                } else {
                    println("Author not added.")
                }
            } else {
                println("Invalid book ID.")
            }
        } else {
            println("Invalid input. Author not added.")
        }
        printBooks(books)
    }

    private fun addBookName(books: MutableList<Books>) {
        println("Enter book name:")
        val name = readLine()
        println("Enter book ID to associate with this name:")
        val bookId = readLine()?.toLongOrNull()
        val book = books.find { it.id == bookId }
        if (name != null && bookId != null && book != null) {
            book.book = name
            println("Book name added successfully!")
        } else {
            println("Invalid input. Book name not added.")
        }
    }

    private fun addHomePublish(books: MutableList<Books>) {
        println("Enter home of publish:")
        val homePublish = readLine()
        println("Enter book ID to associate with this publisher:")
        val bookId = readLine()?.toLongOrNull()
        val book = books.find { it.id == bookId }
        if (homePublish != null && bookId != null && book != null) {
            book.homePublish = homePublish
            println("Home of publish added successfully!")
        } else {
            println("Invalid input. Home of publish not added.")
        }
        printBooks(books)
    }

    private fun addDataPublish(books: MutableList<Books>) {
        println("Enter date of publish:")
        val dataPublish = readLine()
        println("Enter book ID to associate with this date:")
        val bookId = readLine()?.toLongOrNull()
        val book = books.find { it.id == bookId }
        if (dataPublish != null && bookId != null && book != null) {
            book.dataPublisher = dataPublish
            println("Date of publish added successfully!")
        } else {
            println("Invalid input. Date of publish not added.")
        }
        printBooks(books)
    }

    private fun addBookId(books: MutableList<Books>) {
        println("Enter new book ID:")
        val newBookId = readLine()?.toLongOrNull()
        if (newBookId != null) {
            println("Enter book name:")
            val bookName = readLine()
            println("Enter home of publish:")
            val homePublish = readLine()
            println("Enter date of publish:")
            val dataPublish = readLine()
            println("Enter number of version:")
            val numVersion = readLine()?.toIntOrNull()
            println("Enter author ID:")
            val authorId = readLine()?.toLongOrNull()
            println("Enter author name:")
            val authorName = readLine()
            println("Enter author email:")
            val authorEmail = readLine()

            if (bookName != null && homePublish != null && dataPublish != null && numVersion != null && authorId != null && authorName != null && authorEmail != null) {
                val newBook = Books(
                    newBookId, bookName, homePublish, dataPublish, numVersion,
                    Author(authorId, authorName, authorEmail)
                )
                books.add(newBook)
                println("Book added successfully!")
            } else {
                println("Invalid input. Book not added.")
            }
        } else {
            println("Invalid book ID.")
        }
        printBooks(books)
    }

    private fun addNumVersion(books: MutableList<Books>) {
        println("Enter number of versions:")
        val numVersion = readLine()?.toIntOrNull()
        println("Enter book ID to associate with this number of versions:")
        val bookId = readLine()?.toLongOrNull()
        val book = books.find { it.id == bookId }
        if (numVersion != null && bookId != null && book != null) {
            book.numVersion = numVersion
            println("Number of versions added successfully!")
        } else {
            println("Invalid input. Number of versions not added.")
        }
        printBooks(books)
    }

    private fun deleteAuthorById(books: MutableList<Books>) {
        println("Enter author ID to delete:")
        val authorId = readLine()?.toLongOrNull()
        if (authorId != null) {
            val booksWithAuthor = books.filter { it.author.idAuthor == authorId }
            books.removeAll(booksWithAuthor)
            println("Author and associated books deleted successfully!")
        } else {
            println("Invalid author ID.")
        }
        printBooks(books)
    }
}