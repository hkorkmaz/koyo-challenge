package com.chess.pieces

import com.chess.Board
import com.chess.Color
import com.chess.Square
import com.chess.piece.Rook
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RookTest {
    private val board = Board()

    @Test
    fun `return moves`() {
        val rook = Rook(Square("D5"), Color.WHITE)

        val expected = listOf(
            Square("D6"), Square("D7"), Square("D4"), Square("D3"),
            Square("C5"), Square("B5"), Square("A5"), Square("E5"),
            Square("F5"), Square("G5"), Square("H5")
        )

        assertEquals(expected, rook.possibleMoves(board))
    }
}