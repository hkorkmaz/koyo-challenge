package com.chess


fun main() {
    val board = Board()
    val player1 = Player("player1", Color.WHITE)
    val player2 = Player("player2", Color.BLACK)

    println(board)

    board.move(player1, Square("B2"), Square("B4"))
    println(board)

    board.move(player2, Square("G7"), Square("G6"))
    println(board)

    board.move(player2, Square("G6"), Square("G5"))
    println(board)

    board.move(player2, Square("G5"), Square("G4"))
    println(board)

    board.move(player2, Square("C7"), Square("C5"))
    println(board)

    board.move(player2, Square("B7"), Square("B5"))
    println(board)

    board.move(player1, Square("C1"), Square("B7"))
    println(board)

}
