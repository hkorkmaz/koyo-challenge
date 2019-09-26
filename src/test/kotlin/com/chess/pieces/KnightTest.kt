package com.chess.pieces

import com.chess.Board
import com.chess.Color
import com.chess.Square
import com.chess.piece.Knight
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class KnightTest {
    private val board = Board()

    @Test
    fun `return moves`() {

        val knight = Knight(Square("D5"), Color.WHITE)

        val expected = listOf(
            Square("C3"), Square("C7"), Square("E3"), Square("E7"),
            Square("B4"), Square("B6"), Square("F4"), Square("F6")
        )

        assertEquals(expected, knight.possibleMoves(board))
    }

    @Test
    fun `return moves with jumping over ally pieces`() {

        val knight = Knight(Square("D3"), Color.WHITE)

        val expected = listOf(
            Square("B4"), Square("C5"), Square("E5"), Square("F4")
        )

        assertEquals(expected, knight.possibleMoves(board))
    }
}