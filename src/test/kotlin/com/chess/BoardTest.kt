package com.chess

import com.chess.exceptions.InvalidMoveException
import com.chess.exceptions.InvalidPlayerException
import com.chess.exceptions.PieceNotFoundException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class BoardTest {

    @Test
    fun `move piece if everything is ok`() {
        val board = Board()
        val player = Player("player", Color.WHITE)

        val source = Square("A2")
        val target = Square("A3")
        board.move(player, source, target)

        assertEquals(SquareStatus.ALLY, board.squareStatus(target, Color.WHITE))
        assertEquals(SquareStatus.EMPTY, board.squareStatus(source, Color.WHITE))
    }

    @Test
    fun `throw exception for invalid player move`() {
        val board = Board()
        val player = Player("player", Color.BLACK)

        assertThrows<InvalidPlayerException> {
            board.move(player, Square("A2"), Square("A3"))
        }
    }

    @Test
    fun `throw exception for piece is not found`() {
        val board = Board()
        val player = Player("player", Color.BLACK)

        assertThrows<PieceNotFoundException> {
            board.move(player, Square("D5"), Square("D6"))
        }
    }

    @Test
    fun `throw exception for invalid move`() {
        val board = Board()
        val player = Player("player", Color.WHITE)

        assertThrows<InvalidMoveException> {
            board.move(player, Square("B2"), Square("B5"))
        }
    }


    @Test
    fun `return square status`() {
        val board = Board()

        val status1 = board.squareStatus(Square("A1"), Color.WHITE)
        val status2 = board.squareStatus(Square("A8"), Color.WHITE)
        val status3 = board.squareStatus(Square("D5"), Color.WHITE)

        assertEquals(SquareStatus.ALLY, status1)
        assertEquals(SquareStatus.ENEMY, status2)
        assertEquals(SquareStatus.EMPTY, status3)
    }

    @Test
    fun `return validity of a square`() {
        val board = Board()

        val result1 = board.isSquareValid(Square("A1"))
        val result2 = board.isSquareValid(Square("A9"))

        assertEquals(true, result1)
        assertEquals(false, result2)
    }
}