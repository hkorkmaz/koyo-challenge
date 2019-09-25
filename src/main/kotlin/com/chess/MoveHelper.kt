package com.chess


class MoveHelper(val board: Board, val position: Square, val color: Color){

    private var directions: List<Direction> = listOf()
    private var stepCount: Int = BOARD_SIZE

    fun setDirections(directions: List<Direction>): MoveHelper{
        this.directions = directions
        return this
    }

    fun setStepCount(steps: Int): MoveHelper{
        this.stepCount = steps
        return this
    }

    fun moves(): List<Square> {
        val result = mutableListOf<Square>()

        for(direction in directions){
            var blockedPath = false
            for (step in 1..stepCount) {
                val nextSquare = direction(position, step)
                val nextSquareStatus = board.squareStatus(nextSquare, color)

                if (!blockedPath) {
                    when (nextSquareStatus) {
                        SquareStatus.EMPTY -> result.add(nextSquare)
                        SquareStatus.ALLY, SquareStatus.INVALID -> blockedPath = true
                        SquareStatus.ENEMY -> {
                            result.add(nextSquare)
                            blockedPath = true
                        }
                    }
                }
            }
        }

        return result
    }
}