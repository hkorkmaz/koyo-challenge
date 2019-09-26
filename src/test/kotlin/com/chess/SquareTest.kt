package com.chess

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class SquareTest {

    @Test
    fun `moves with step=1`() {
        val d5 = Square("D5")

        assertEquals(Square("C5"), d5.left())
        assertEquals(Square("E5"), d5.right())
        assertEquals(Square("D6"), d5.up())
        assertEquals(Square("D4"), d5.down())
    }

    @Test
    fun `moves with step=2`() {
        val d5 = Square("D5")

        assertEquals(Square("B5"), d5.left(2))
        assertEquals(Square("F5"), d5.right(2))
        assertEquals(Square("D7"), d5.up(2))
        assertEquals(Square("D3"), d5.down(2))
    }

    @Test
    fun `test symmetricity`() {
        val a1 = Square("A1")

        assertEquals(Square("A8"), a1.symmetricX())
        assertEquals(Square("H1"), a1.symmetricY())
    }
}