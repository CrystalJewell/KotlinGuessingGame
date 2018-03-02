import java.util.*
import kotlin.math.roundToInt
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    //Created instance of GuessingGame class
    val game = GuessingGame()

    //Used instance of GuessingGame class to call inner function to start the game
    game.playGame()
}

//Created class to hold all code relevant to the guessing game
class GuessingGame {

    //Created function to hold what is needed to play the game
    internal fun playGame() {

        //Creates random number from 1 to 100.  Math.random gives double which means rounding is needed thus roundToInt()
        val generatedNumber = (Math.random() * 100 + 1).roundToInt()
        //Holds number to check number of guesses against
        val maxGuesses = 4
        //Holds users current amount of guesses
        var userGuesses = 0
        //Have to create a reader from Java Scanner to take Int as readLine input.
        val reader = Scanner(System.`in`)

        //This prints out the random number.  Used to see how Math.random works in Kotlin vs Java
//    println(generatedNumber)

        //Prints the welcome statement and game rules to the user
        println("""
         |Welcome to the guessing game!
         |You have 5 chances to guess what random number has generated
    """.trimMargin())

        while (userGuesses <= maxGuesses) {

            try {
                println("Choose a number from 1 to 100: ")

                //Holds user guess
                val userInput: Int = reader.nextInt()

                //Checks if user has chose the correct number
                if (userInput == generatedNumber) {
                    println("You have guessed correctly!")
                    playAgain()
                }
                //Checks to see if user has not chose the correct number AND is out of guesses
                else if (userInput != generatedNumber && userGuesses == maxGuesses) {
                    println("""
             |Sorry you have ran out of guesses
             |The correct number was $generatedNumber
             |
        """.trimMargin())
                    playAgain()
                }
                //Checks to see if the users input is higher than the generated number
                else if (userInput > generatedNumber) {
                    println("You number is too high")
                    //.inc increments the number for us instead of using ++
                    userGuesses++
                }
                //Checks to see if the users input is lower than generated number
                else if (userInput < generatedNumber) {
                    println("Your number is too low")
                    userGuesses++
                }
            } catch (ime: InputMismatchException) {
                println("Please enter a number between 1 and 100")
                reader.nextLine()
            }

        }
    }

    //Function to handle prompting the user if they would like to play again and handing the response
    private fun playAgain() {

        //Prints out instructions to user
        println("""
        |Would you like to play again?
        |Y or N
    """.trimMargin())

        //Takes user input !! declares this MUST never be null, take user input and makes uppercase handles answer
        when (readLine()!!.toUpperCase()) {
            "Y" -> playGame()
            "N" -> exitGame()

            else -> {
                println("Please enter a Y or N")
                playAgain()
            }
        }
    }

    //Handles exiting the game
    private fun exitGame() {

        println("Thanks for playing!")
        exitProcess(0)
    }
}