import java.io.File

fun main(args: Array<String>) {
    val chart = Chart(1000, 1000)
    read("input.txt")
        .map { Path.of(it) }
        .forEach { chart.addPath(it) }

    println("number of 2 or above: ${chart.countOccurrences { it >= 2 }}")


}

fun read(fileName: String): List<String> =
    File(ClassLoader.getSystemResource(fileName).toURI()).readLines()