package com.chess.piece

import com.chess.Board
import com.chess.Color
import com.chess.Square

interface Piece {
    var position: Square
    val color: Color

    fun possibleMoves(board: Board): List<Square>

    fun moveTo(position: Square) {
        this.position = position
    }
}