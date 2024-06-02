package doaa.mosallam.book

class Client {
    val users = mutableListOf<User>()
    private val library = Library()
    fun client(){
        println("Welcome to ElShrouk AddBooks")

        println("Choose your Login Or Register:  ")
         println("1. Login")
        println("2.Register")
        println("Can You Choose 1.Login Or 2.Register: ")

        val choice = readlnOrNull()
        when(choice){
            "1" -> Login()
            "2"-> Register()
            "3" -> println("InCorrect Selection!!")
        }
    }

     private fun Login(){
        print("Enter Your name: ")
        val username = readlnOrNull() ?:""
        print("Enter Your Password: ")
        val password = readlnOrNull() ?:""

        if (username.isEmpty() || password.isEmpty()){
            println("User name and password is require.")
        }else{
            if (username.isNotEmpty() && password.isNotEmpty()){

                println("Welcome ${username}, you login in successfully.")
               library.Library()
            }else{
                println("Your Name and Your Password incorrect!")
            }
        }

    }

    private fun Register() {
        println("Enter Your Name: ")
        val name = readlnOrNull() ?:""
        println("Enter Your Phone Number: ")
        val phone = readlnOrNull() ?:""
        println("Enter Your Address: ")
        val address = readlnOrNull() ?:""
        println("Enter Your Password: ")
        val password = readlnOrNull() ?:""

        if (name.isEmpty() || phone.isEmpty() || address.isEmpty() || password.isEmpty()) {
            println("All failed is require.")
        } else {
            val newUser = User(

                id = (users.size + 1).toLong(),
                username = name,
                address = address,
                phone = phone,
                password = password
            )
            users.add(newUser)
            println("Welcome  $name, you Register in successfully.\n")

            library.Library()
        }
    }
}