package com.chess

enum class SquareStatus {
    EMPTY,
    ALLY,
    ENEMY,
    INVALID
}

data class Square(val str: String) {

    private constructor(x: Int, y: Int) : this("${x.toChar()}${y.toChar()}")

    private val x = str[0].toInt()
    private val y = str[1].toInt()

    fun down(step: Int = 1): Square {
        return Square(x, y - step)
    }

    fun up(step: Int = 1): Square {
        return Square(x, y + step)
    }

    fun left(step: Int = 1): Square {
        return Square(x - step, y)
    }

    fun right(step: Int = 1): Square {
        return Square(x + step, y)
    }

    fun symmetricX(): Square {
        return Square(x, 105 - y)
    }

    fun symmetricY(): Square {
        return Square(137 - x, y)
    }

    override fun toString(): String {
        return str
    }
}

