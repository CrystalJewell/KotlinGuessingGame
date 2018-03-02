import kotlin.math.roundToInt

fun main(args: Array<String>) {

    //Creates random number from 1 to 100.  Math.random gives double which means rounding is needed thus roundToInt()
    val generatedNumber = (Math.random() * 100 + 1).roundToInt()

    //This prints out the random number.  Used to see how Math.random works in Kotlin vs Java
    println(generatedNumber)

}
