package doaa.mosallam.book

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

    private fun login() {
        print("Enter your name: ")
        val username = readlnOrNull() ?: ""
        print("Enter your password: ")
        val password = readlnOrNull() ?: ""

        if (username.isEmpty() || password.isEmpty()) {
            println("Username and password are required.")
        } else {
            val user = users.find { it.username == username && it.password == password }
            if (user != null) {
                println("Welcome $username, you logged in successfully.")
                // Optionally, you can call library functions or perform other actions here.
                library.Library()
            } else {
                println("Username or password is incorrect.")
            }
        }
    }

    private fun register() {
        println("Enter your name: ")
        val name = readlnOrNull() ?: ""
        println("Enter your phone number: ")
        val phone = readlnOrNull() ?: ""
        println("Enter your address: ")
        val address = readlnOrNull() ?: ""
        println("Enter your password: ")
        val password = readlnOrNull() ?: ""

        if (name.isEmpty() || phone.isEmpty() || address.isEmpty() || password.isEmpty()) {
            println("All fields are required.")
        } else {
            val newUser = User(
                id = (users.size + 1).toLong(),
                username = name,
                address = address,
                phone = phone,
                password = password
            )
            users.add(newUser)
            println("Welcome $name, you registered successfully.\n")

            // After successful registration, prompt for login to verify the registration.
            println("Please log in to verify your registration.")
            login()
        }
    }
}