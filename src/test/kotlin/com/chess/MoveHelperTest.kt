package com.chess

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MoveHelperTest {
    private val board = Board()

    @Test
    @DisplayName("should return moves")
    fun moveHelperTest1() {

        val directions = listOf(Directions.up, Directions.left)

        val moves = MoveHelper(board, Square("D5"), Color.WHITE)
            .setDirections(directions)
            .setStepCount(2)
            .moves()

        val expected = listOf(Square("D6"), Square("D7"), Square("C5"), Square("B5"))

        assertEquals(expected, moves)
    }

    @Test
    @DisplayName("shouldn't return blocked squares")
    fun moveHelperTest2() {

        val directions = listOf(Directions.up, Directions.down)

        val moves = MoveHelper(board, Square("D5"), Color.WHITE)
            .setDirections(directions)
            .setStepCount(8)
            .moves()

        val expected = listOf(Square("D6"), Square("D7"), Square("D4"), Square("D3"))

        assertEquals(expected, moves)
    }

    @Test
    @DisplayName("shouldn't return squares out of board")
    fun moveHelperTest3() {

        val directions = listOf(Directions.left)

        val moves = MoveHelper(board, Square("D5"), Color.WHITE)
            .setDirections(directions)
            .setStepCount(8)
            .moves()

        val expected = listOf(Square("C5"), Square("B5"), Square("A5"))

        assertEquals(expected, moves)
    }

    @Test
    @DisplayName("shouldn't return anything if piece is blocked")
    fun moveHelperTest4() {

        val directions = listOf(Directions.up)

        val moves = MoveHelper(board, Square("D6"), Color.BLACK)
            .setDirections(directions)
            .setStepCount(8)
            .moves()

        assertEquals(listOf(), moves)
    }
}