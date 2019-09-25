package com.chess.exceptions

import com.chess.Square
import com.chess.piece.Piece
import java.lang.RuntimeException

class InvalidPlayerException(piece: Piece) : RuntimeException("Player can not move $piece at ${piece.position}")

class PieceNotFoundException(square: Square?) : RuntimeException("Piece not found in $square")

class InvalidMoveException(piece: Piece, square: Square) : RuntimeException("$piece at ${piece.position} can't move to $square")