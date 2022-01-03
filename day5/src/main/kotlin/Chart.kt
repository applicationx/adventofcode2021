import java.lang.Integer.max
import java.lang.Integer.min

class Chart {

    val xSize: Int
    val ySize: Int
    val chart: MutableList<Int>

    constructor(xSize: Int, ySize: Int) {
        this.xSize = xSize
        this.ySize = ySize
        chart = MutableList(xSize * ySize) { 0 }
    }

    fun addPath(path: Path) {
        path.toPositions()
            .forEach{
                chart[it.x + (it.y * xSize)] = chart[it.x + (it.y * xSize)] + 1
            }
    }


    fun countOccurrences(pred: (Int) -> Boolean): Int =
        chart.count(pred)

    override fun toString(): String {
        return """Chart:
            |size: ${chart.size}
            |content:  
            |${
            chart.windowed(size = xSize, step = xSize, partialWindows = true)
                .map { it.toString() }
                .map { it + "\n" }
        }"""
            .trimMargin()
    }


}