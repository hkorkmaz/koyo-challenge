package com.chess.piece

import com.chess.*
import com.chess.Directions

class King(override var position: Square, override val color: Color, override val board: Board) : Piece {
    private val directions =
        listOf(
            Directions.up,
            Directions.down,
            Directions.left,
            Directions.right,
            Directions.downLeft,
            Directions.downRight,
            Directions.upLeft,
            Directions.upRight
        )

    override fun possibleMoves(): List<Square> {
        return MoveHelper(board, position, color)
            .setStepCount(1)
            .setDirections(directions)
            .moves()
    }

    override fun toString(): String {
        return "King(${color.name[0]})".padEnd(10, ' ')
    }
}