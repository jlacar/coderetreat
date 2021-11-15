import gol.GameOfLife

fun main(args: Array<String>) {
    val board = GameOfLife("""
        .......
        ...*...
        .......""".trimIndent()
    )

    // while (board.isEvolving()) {
        println(board)
    //    board.nextGeneration()
    // }
}

