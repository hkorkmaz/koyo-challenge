package com.chess.pieces

import com.chess.Board
import com.chess.Color
import com.chess.Square
import com.chess.piece.Pawn
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PawnTest {
    private val board = Board()

    @Test
    fun `return moves`() {

        val pawn = Pawn(Square("D4"), Color.WHITE)

        val expected = listOf(Square("D5"), Square("D6"))
        assertEquals(expected, pawn.possibleMoves(board))
    }

    @Test
    fun `return moves after moving`() {

        val pawn = Pawn(Square("D3"), Color.WHITE)
        pawn.moveTo(Square("D4"))

        val expected = listOf(Square("D5"))
        assertEquals(expected, pawn.possibleMoves(board))
    }

    @Test
    fun `return diagonal enemy squares`() {
        val pawn = Pawn(Square("D6"), Color.WHITE)

        val expected = listOf(Square("C7"), Square("E7"))
        assertEquals(expected, pawn.possibleMoves(board))
    }

}