package com.chess.pieces

import com.chess.Board
import com.chess.Color
import com.chess.Square
import com.chess.piece.Bishop
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BishopTest {
    private val board = Board()

    @Test
    @DisplayName("should return moves")
    fun bishopTest() {

        val bishop = Bishop(Square("D5"), Color.WHITE, board)

        val expected = listOf(
            Square("C4"), Square("B3"), Square("C6"), Square("B7"),
            Square("E4"), Square("F3"), Square("E6"), Square("F7")
        )

        assertEquals(expected, bishop.possibleMoves())
    }

}