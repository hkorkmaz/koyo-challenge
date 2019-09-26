package com.chess

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MoveHelperTest {
    private val board = Board()

    @Test
    fun `return moves`() {
        val directions = listOf(Directions.up, Directions.left)

        val moves = MoveHelper(board, Square("D5"), Color.WHITE)
            .setDirections(directions)
            .setStepCount(2)
            .moves()

        val expected = listOf(Square("D6"), Square("D7"), Square("C5"), Square("B5"))

        assertEquals(expected, moves)
    }

    @Test
    fun `not return blocked squares`() {
        val directions = listOf(Directions.up, Directions.down)

        val moves = MoveHelper(board, Square("D5"), Color.WHITE)
            .setDirections(directions)
            .setStepCount(8)
            .moves()

        val expected = listOf(Square("D6"), Square("D7"), Square("D4"), Square("D3"))

        assertEquals(expected, moves)
    }

    @Test
    fun `not return squares out of board`() {
        val directions = listOf(Directions.left)

        val moves = MoveHelper(board, Square("D5"), Color.WHITE)
            .setDirections(directions)
            .setStepCount(8)
            .moves()

        val expected = listOf(Square("C5"), Square("B5"), Square("A5"))

        assertEquals(expected, moves)
    }

    @Test
    fun `not return anything if piece is blocked`() {
        val directions = listOf(Directions.up)

        val moves = MoveHelper(board, Square("D6"), Color.BLACK)
            .setDirections(directions)
            .setStepCount(8)
            .moves()

        assertEquals(listOf(), moves)
    }
}