package com.chess.piece

import com.chess.*
import com.chess.Directions

class Rook(override var position: Square, override val color: Color) : Piece {

    private val directions = listOf(Directions.up, Directions.down, Directions.left, Directions.right)

    override fun possibleMoves(board: Board): List<Square> {
        return MoveHelper(board, position, color)
            .setDirections(directions)
            .moves()
    }

    override fun toString(): String {
        return "Rook(${color.name[0]})".padEnd(10, ' ')
    }
}