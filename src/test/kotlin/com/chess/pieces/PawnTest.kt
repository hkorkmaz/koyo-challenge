package com.chess.pieces

import com.chess.Board
import com.chess.Color
import com.chess.Square
import com.chess.piece.Pawn
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PawnTest {
    private val board = Board()

    @Test
    @DisplayName("should return moves")
    fun pawnTest1() {

        val pawn = Pawn(Square("D4"), Color.WHITE, board)

        val expected = listOf(Square("D5"), Square("D6"))
        assertEquals(expected, pawn.possibleMoves())
    }

    @Test
    @DisplayName("should return moves after moving")
    fun pawnTest2() {

        val pawn = Pawn(Square("D3"), Color.WHITE, board)
        pawn.moveTo(Square("D4"))

        val expected = listOf(Square("D5"))
        assertEquals(expected, pawn.possibleMoves())
    }

    @Test
    @DisplayName("should return diagonal enemy squares")
    fun pawnTest3() {
        val pawn = Pawn(Square("D6"), Color.WHITE, board)

        val expected = listOf(Square("C7"), Square("E7"))
        assertEquals(expected, pawn.possibleMoves())
    }

}