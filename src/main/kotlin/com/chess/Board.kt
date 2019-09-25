package com.chess

import com.chess.piece.*
import com.chess.exceptions.InvalidMoveException
import com.chess.exceptions.InvalidPlayerException
import com.chess.exceptions.PieceNotFoundException

const val BOARD_SIZE = 8
const val BOARD_START_X = 'A'
const val BOARD_END_X = 'H'
const val BOARD_START_Y = '1'
const val BOARD_END_Y = '8'

class Board {
    private val pieces = mutableMapOf<Square, Piece>()

    init {
        putPieces()
    }

    fun move(player: Player, sourceSquare: Square, targetSquare: Square) {
        val piece = pieces[sourceSquare] ?: throw PieceNotFoundException(sourceSquare)

        if (piece.color != player.color)
            throw InvalidPlayerException(piece)

        if (targetSquare !in piece.possibleMoves())
            throw InvalidMoveException(piece, targetSquare)

        pieces.remove(sourceSquare)
        piece.moveTo(targetSquare)
        pieces[targetSquare] = piece
    }

    fun isSquareValid(square: Square): Boolean {
        return square.str[0] in BOARD_START_X..BOARD_END_X && square.str[1] in BOARD_START_Y..BOARD_END_Y
    }

    fun squareStatus(square: Square, color: Color): SquareStatus {
        return if (!isSquareValid(square))
            SquareStatus.INVALID
        else if (hasAlly(square, color))
            SquareStatus.ALLY
        else if (hasEnemy(square, color))
            SquareStatus.ENEMY
        else
            SquareStatus.EMPTY
    }

    override fun toString(): String {
        val pipe = "|"
        val dash = "-"
        val space = " "
        val s = StringBuilder()

        s.append(dash.repeat(90)).appendln()

        for (y in BOARD_END_Y downTo BOARD_START_Y) {
            s.append(y).append(space)

            for (x in BOARD_START_X..BOARD_END_X) {
                val piece = pieces[Square("$x$y")]
                if(piece == null)
                    s.append(pipe).append(dash.padEnd(10, ' '))
                else
                    s.append(pipe).append(piece)
            }
            s.append(pipe).appendln()
        }
        s.append(dash.repeat(90)).appendln().append(space.repeat(2)).append(pipe)

        for (x in BOARD_START_X..BOARD_END_X) {
            s.append("$x".padEnd(10, ' ')).append(pipe)
        }

        return s.appendln().toString()
    }

    private fun hasEnemy(position: Square, color: Color): Boolean {
        if (isEmpty(position)) {
            return false
        }
        return pieces[position]!!.color != color
    }

    private fun hasAlly(position: Square, color: Color): Boolean {
        if (isEmpty(position)) {
            return false
        }
        return pieces[position]!!.color == color
    }

    private fun isEmpty(position: Square): Boolean {
        return pieces[position] == null
    }

    private fun putPieces() {
        // Pawns
        val a2 = Square("A2")
        for (i in 0 until BOARD_SIZE) {
            val pawnWhite = Pawn(a2.right(i), Color.WHITE, this)
            val pawnBlack = Pawn(a2.right(i).symmetricX(), Color.BLACK, this)
            pieces[a2.right(i)] = pawnWhite
            pieces[a2.right(i).symmetricX()] = pawnBlack
        }

        // Bishops
        val c1 = Square("C1")
        val f1 = Square("F1")
        pieces[c1] = Bishop(c1, Color.WHITE, this)
        pieces[f1] = Bishop(f1, Color.WHITE, this)
        pieces[c1.symmetricX()] = Bishop(c1.symmetricX(), Color.BLACK, this)
        pieces[f1.symmetricX()] = Bishop(f1.symmetricX(), Color.BLACK, this)

        // Knights
        val b1 = Square("B1")
        val g1 = Square("G1")
        pieces[b1] = Knight(b1, Color.WHITE, this)
        pieces[g1] = Knight(g1, Color.WHITE, this)
        pieces[b1.symmetricX()] = Knight(b1.symmetricX(), Color.BLACK, this)
        pieces[g1.symmetricX()] = Knight(g1.symmetricX(), Color.BLACK, this)

        // Rooks
        val a1 = Square("A1")
        val h1 = Square("H1")
        pieces[a1] = Rook(a1, Color.WHITE, this)
        pieces[h1] = Rook(h1, Color.WHITE, this)
        pieces[a1.symmetricX()] = Rook(a1.symmetricX(), Color.BLACK, this)
        pieces[h1.symmetricX()] = Rook(h1.symmetricX(), Color.BLACK, this)

        // Kings
        val e1 = Square("E1")
        pieces[e1] = King(e1, Color.WHITE, this)
        pieces[e1.symmetricX()] = King(e1.symmetricX(), Color.BLACK, this)

        // Queens
        val d1 = Square("D1")
        pieces[d1] = Queen(d1, Color.WHITE, this)
        pieces[d1.symmetricX()] = Queen(d1.symmetricX(), Color.BLACK, this)
    }
}
