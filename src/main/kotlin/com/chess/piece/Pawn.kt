package com.chess.piece

import com.chess.Board
import com.chess.Color
import com.chess.Square
import com.chess.SquareStatus


class Pawn(override var position: Square, override val color: Color) : Piece {

    private var hasMoved = false

    override fun possibleMoves(board: Board): List<Square> {
        val step = if (color == Color.BLACK) -1 else 1
        return straightMoves(board, step) + diagonalMoves(board, step)
    }

    override fun moveTo(position: Square) {
        super.moveTo(position)
        this.hasMoved = true
    }

    private fun straightMoves(board: Board, step: Int): List<Square> {
        val possibilities = if (!hasMoved) {
            listOf(position.up(step), position.up(step).up(step))
        } else {
            listOf(position.up(step))
        }

        return possibilities.filter {
            val status = board.squareStatus(it, color)
            status == SquareStatus.EMPTY && board.isSquareValid(it)
        }
    }

    private fun diagonalMoves(board: Board, step: Int): List<Square> {
        val possibilities = listOf(position.up(step).left(1), position.up(step).right(1))
        return possibilities.filter {
            val status = board.squareStatus(it, color)
            status == SquareStatus.ENEMY && board.isSquareValid(it)
        }
    }

    override fun toString(): String {
        return "Pawn(${color.name[0]})".padEnd(10, ' ')
    }
}