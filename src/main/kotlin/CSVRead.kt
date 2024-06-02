package doaa.mosallam.book

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException


object LibraryCSVReader {

     fun printBooks(list: List<Books>): List<Books> {
        for (i in list.indices) {
            println("$i : ${list[i]}")
        }
        return list
    }

    fun readLibraryBooks(filePath: String): List<Books> {
        val list = mutableListOf<Books>()
        var line: String?

        try {
            BufferedReader(FileReader(filePath)).use { reader ->
                // Skip the header line
                reader.readLine()

                while (reader.readLine().also { line = it } != null) {
                    val tokens = line!!.split(",")
                    if (tokens.size >= 8) {
                        val book = Books(
                            id = tokens[0].toLong(),
                            book = tokens[1],
                            homePublish = tokens[2],
                            dataPublisher = tokens[3],
                            numVersion = tokens[4].toInt(),
                            author = Author(
                                idAuthor = tokens[5].toLong(),
                                nameAuthor = tokens[6],
                                emailAuthor = tokens[7]
                            )
                        )
                        list.add(book)
                    } else {
                        println("ElShrouk Books : $line")
                    }
                }
            }
        } catch (e: IOException) {
            println("Error in csv file!!!")
            e.printStackTrace()
        }

        return printBooks(list)
    }


}





