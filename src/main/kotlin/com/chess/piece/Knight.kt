package com.chess.piece

import com.chess.Board
import com.chess.Color
import com.chess.Square
import com.chess.SquareStatus

class Knight(override var position: Square, override val color: Color, override val board: Board) : Piece {

    override fun possibleMoves(): List<Square> {
        val t1 = position.left().down(2)
        val t2 = position.left().up(2)
        val t3 = position.right().down(2)
        val t4 = position.right().up(2)

        val t5 = position.left(2).down()
        val t6 = position.left(2).up()
        val t7 = position.right(2).down()
        val t8 = position.right(2).up()

        return listOf(t1, t2, t3, t4, t5, t6, t7, t8).filter {
            val ts = board.squareStatus(it, color)
            ts == SquareStatus.EMPTY || ts == SquareStatus.ENEMY
        }
    }

    override fun toString(): String {
        return "Knight(${color.name[0]})".padEnd(10, ' ')
    }
}