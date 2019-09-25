package com.chess.pieces

import com.chess.Board
import com.chess.Color
import com.chess.Square
import com.chess.piece.Queen
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class QueenTest {
    private val board = Board()

    @Test
    @DisplayName("should return moves")
    fun queenTest() {

        val queen = Queen(Square("D5"), Color.WHITE, board)

        val expected = listOf(
            Square("D6"), Square("D7"), Square("D4"), Square("D3"),
            Square("C5"), Square("B5"), Square("A5"), Square("E5"), Square("F5"),
            Square("G5"), Square("H5"), Square("C4"), Square("B3"), Square("E4"),
            Square("F3"), Square("C6"), Square("B7"), Square("E6"), Square("F7")
        )

        assertEquals(expected, queen.possibleMoves())
    }

}