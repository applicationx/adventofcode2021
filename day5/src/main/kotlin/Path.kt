import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

data class Path(val x1: Int, val y1: Int, val x2: Int, val y2: Int) {

    enum class Direction {
        X, Y, BOTH, NONE, DIAGONAL, REVERSE_DIAGONAL
    }

    fun getMovementDirection(): Direction =
        if (x1 - x2 == y1 - y2)
            Direction.DIAGONAL
        else if (abs(x1 - x2) == abs(y1 - y2))
            Direction.REVERSE_DIAGONAL
        else if (x1 != x2)
            if (y1 != y2)
                Direction.BOTH
            else
                Direction.X
        else if (y1 != y2)
            if (x1 == x2)
                Direction.Y
            else
                Direction.BOTH
        else
            Direction.NONE

    fun toPositions(): Collection<Point> {
        return when (getMovementDirection()) {
            Direction.X -> (min(x1, x2)..max(x1, x2)).map { Point(it, y1) }
            Direction.Y -> (min(y1, y2)..max(y1, y2)).map { Point(x1, it) }
            Direction.DIAGONAL -> (0..(abs(deltaX))).map { Point(min(x1, x2) + it, min(y1, y2) + it) }
            Direction.REVERSE_DIAGONAL -> (0..(abs(deltaX))).map { Point(min(x1, x2) + it, max(y1, y2) - it) }
            else -> emptyList()
        }
    }

    val deltaX = x2 - x1

    data class Point(val x: Int, val y: Int)

    companion object {
        fun of(line: String): Path {
            val parts = line.split(" -> ")
            val from = parts[0].split(",").map { it.toInt() }
            val to = parts[1].split(",").map { it.toInt() }
            return Path(from[0], from[1], to[0], to[1])
        }
    }
}