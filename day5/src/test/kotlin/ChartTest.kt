import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ChartTest {

    @Test
    fun addPath() {
        val chart = Chart(10, 10)
        chart.addPath(Path(1, 1, 1, 9))
        chart.addPath(Path(3, 2, 1, 2))
        println(chart)
        println("count: ${chart.countOccurrences { it >= 2 }}")
    }

    @Test
    fun pathToPoint() {
        val path = Path(852, 131, 25, 958)
        path.toPositions()
            .forEach{
                println("x: ${it.x}, y: ${it.y}")
            }
    }
}

/**
 *  0  1  2  3  4  5  6  7  8  9
 * 10 11 12 13 14 15 16 17 18 19
 */