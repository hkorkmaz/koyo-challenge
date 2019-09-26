package com.chess.piece

import com.chess.*
import com.chess.Directions


class Bishop(override var position: Square, override val color: Color) : Piece {
    private val directions = listOf(Directions.downLeft, Directions.upLeft, Directions.downRight, Directions.upRight)

    override fun possibleMoves(board: Board): List<Square> {
        return MoveHelper(board, position, color)
            .setDirections(directions)
            .moves()
    }

    override fun toString(): String {
        return "Bishop(${color.name[0]})".padEnd(10, ' ')
    }
}