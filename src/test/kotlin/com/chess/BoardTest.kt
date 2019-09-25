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
    @DisplayName("should move piece if everything is ok")
    fun boardTest1() {
        val board = Board()
        val player = Player("player", Color.WHITE)

        val source = Square("A2")
        val target = Square("A3")
        board.move(player, source, target)

        assertEquals(SquareStatus.ALLY, board.squareStatus(target, Color.WHITE))
        assertEquals(SquareStatus.EMPTY, board.squareStatus(source, Color.WHITE))
    }

    @Test
    @DisplayName("should throw exception for invalid player move")
    fun boardTest2() {
        val board = Board()
        val player = Player("player", Color.BLACK)

        assertThrows<InvalidPlayerException> {
            board.move(player, Square("A2"), Square("A3"))
        }
    }

    @Test
    @DisplayName("should throw exception for piece is not found")
    fun boardTest3() {
        val board = Board()
        val player = Player("player", Color.BLACK)

        assertThrows<PieceNotFoundException> {
            board.move(player, Square("D5"), Square("D6"))
        }
    }

    @Test
    @DisplayName("should throw exception for invalid move")
    fun boardTest4() {
        val board = Board()
        val player = Player("player", Color.WHITE)

        assertThrows<InvalidMoveException> {
            board.move(player, Square("B2"), Square("B5"))
        }
    }


    @Test
    @DisplayName("should return square status")
    fun boardTest5() {
        val board = Board()

        val status1 = board.squareStatus(Square("A1"), Color.WHITE)
        val status2 = board.squareStatus(Square("A8"), Color.WHITE)
        val status3 = board.squareStatus(Square("D5"), Color.WHITE)

        assertEquals(SquareStatus.ALLY, status1)
        assertEquals(SquareStatus.ENEMY, status2)
        assertEquals(SquareStatus.EMPTY, status3)
    }

    @Test
    @DisplayName("should return validity of a square")
    fun boardTest6() {
        val board = Board()

        val result1 = board.isSquareValid(Square("A1"))
        val result2 = board.isSquareValid(Square("A9"))

        assertEquals(true, result1)
        assertEquals(false, result2)
    }
}