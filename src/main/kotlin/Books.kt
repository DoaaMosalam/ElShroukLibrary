package doaa.mosallam.book

data class Books(
    val id: Long,
    var book: String,
    var homePublish: String,
    var dataPublisher: String,
    var numVersion: Int,
    var author: Author
)
