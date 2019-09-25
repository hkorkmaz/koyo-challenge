package com.chess

typealias Direction = (Square, Int) -> Square

object Directions {
    val up: Direction = { p, step -> p.up(step) }
    val down: Direction = { p, step -> p.down(step) }
    val left: Direction = { p, step -> p.left(step) }
    val right: Direction = { p, step -> p.right(step) }

    val downLeft: Direction = { p, step -> p.down(step).left(step) }
    val upLeft: Direction = { p, step -> p.up(step).left(step) }
    val downRight: Direction = { p, step -> p.down(step).right(step) }
    val upRight: Direction = { p, step -> p.up(step).right(step) }
}