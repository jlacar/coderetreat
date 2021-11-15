package gol

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class GameOfLifeTest : StringSpec({

    "what test do I start with?" {
        val board = GameOfLife()

        board.toString() shouldBe ""
    }

    // check if there's a seed
    "be able to see the initial configuration" {
        val board = GameOfLife()
        board.seed("*")

        board.toString() shouldBe "*"
    }

    "empty cells are represented by dots" {
        val board = GameOfLife()

        board.seed("......")

        board.toString() shouldBe "......"
    }

    "board isEvolving when there's at least one live cell in it" {
        val board = GameOfLife()

        board.seed("....*....")

        board.isEvolving() shouldBe true
    }

})

/*

"New Game is Empty" {
            val world = GameOfLife()

            world.isEmpty() shouldBe true
        }

        "A game can be seeded with an initial population" {
            val world = GameOfLife("*")

            world.isEmpty() shouldBe false
        }

        "A cell with no neighbours dies" {
            val world = GameOfLife("*")

            world.nextTurn().isEmpty() shouldBe true
        }

        "A cell with one neighbor dies" {
            val world = GameOfLife("**")

            world.nextTurn().isEmpty() shouldBe true
        }

        "A world with a single dead cell will stay empty" {
            val world = GameOfLife(".")

            world.nextTurn() shouldBe GameOfLife(".")
        }

        "Canary test".config(enabled = false) {
            gol.answer() shouldBe 42
        }

    }
}

fun singleDeadCell() = "."

fun singleDeadCellNext() = "."

fun seed1() = """4 8
........
....*...
...**...
.....*.."""

fun seed1Next() = """4 8
........
....*...
...**...
.....*.."""

 */