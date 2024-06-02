package doaa.mosallam.book

object BooksStore {
    val books = mutableListOf<Books>()

    fun booksStore() {
        books.add(
            Books(
                123456, "Sehra Eldonia", "Elshrouk", "2019", 2,
                Author(123, "Mostafa", "MostafHosney@gmail.com\n")
            )
        )
        books.add(
            Books(
                789101, "Ahlam", "Alif", "2020", 3,
                Author(456, "Ahlam", "Ahlam@gmail.com\n")
            )
        )
        books.add(
            Books(
                111213, "fan Elah mouballah", "kyan", "2021", 4,
                Author(789, "GroupsOfPeople", "Groups of people@gmail.com\n")
            )
        )
        books.add(
            Books(
                141516, "Afrah Elmakbara", "kyan", "2017", 1,
                Author(101, "Ahmed Khaled", "AhmedKhaled@gmail.com\n")
            )
        )
        books.add(
            Books(
                171819, "zat", "Elshrouk", "2018", 5,
                Author(112, "Ebrahim", "Ebrahim@gmail.com\n")
            )
        )
        books.add(
            Books(
                10111213, "ard Zykola", "ElShrouk", "2016", 1,
                Author(1011, "Amr Abdel Majeed", "Amr@gmail.com\n")
            )
        )
        books.add(
            Books(
                10111213, "ard Zykola(Amarita)", "ElShrouk", "2018", 1,
                Author(101234, "Amr Abdel Majeed", "Amr@gmail.com\n")
            )
        )
    }

//    fun printBooks(list: List<Books>): List<Books> {
//        for (i in list.indices) {
//            println("$i : ${list[i]}")
//        }
//        return list
//    }
}