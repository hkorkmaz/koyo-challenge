package com.chess.pieces

import com.chess.Board
import com.chess.Color
import com.chess.Square
import com.chess.piece.Knight
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class KnightTest {
    private val board = Board()

    @Test
    @DisplayName("should return moves")
    fun knightTest() {

        val knight = Knight(Square("D5"), Color.WHITE, board)

        val expected = listOf(
            Square("C3"), Square("C7"), Square("E3"), Square("E7"),
            Square("B4"), Square("B6"), Square("F4"), Square("F6")
        )

        assertEquals(expected, knight.possibleMoves())
    }

    @Test
    @DisplayName("should return moves without jumping over ally pieces")
    fun knightTest2() {

        val knight = Knight(Square("D3"), Color.WHITE, board)

        val expected = listOf(
            Square("B4"), Square("C5"), Square("E5"), Square("F4")
        )

        println(knight.possibleMoves())
        assertEquals(expected, knight.possibleMoves())
    }

}