package com.chess.piece

import com.chess.*
import com.chess.Directions

class Queen(override var position: Square, override val color: Color) : Piece {
    private val directions = listOf(
        Directions.up,
        Directions.down,
        Directions.left,
        Directions.right,
        Directions.downLeft,
        Directions.downRight,
        Directions.upLeft,
        Directions.upRight
    )

    override fun possibleMoves(board: Board): List<Square> {
        return MoveHelper(board, position, color)
            .setDirections(directions)
            .moves()
    }

    override fun toString(): String {
        return "Queen(${color.name[0]})".padEnd(10, ' ')
    }
}