package com.acnsiq.games.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static com.acnsiq.games.tictactoe.TicTacToe.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class TicTacToeTest {

    private static final int[] NO_WINNER = {0, 1, 2, 4, 7, 5, 3, 6, 8};

    private static final int[] X_WINS_ROW_1 = {0, 3, 1, 4, 2};
    private static final int[] INVALID_MOVES_AFTER_X_WINS_ROW_1 = {5, 6, 7, 8};

    private static final int[] X_WINS_ROW_2 = {3, 0, 4, 1, 5};

    private static final int[] X_WINS_COL_1 = {0, 1, 3, 2, 6};
    private static final int[] X_WINS_COL_2 = {1, 0, 4, 3, 7};

    private static final int[] O_WINS_ROW_1 = {5, 0, 3, 1, 8, 2};
    private static final int[] O_WINS_ROW_2 = {0, 3, 8, 4, 1, 5};

    private static final int[] X_WINS_LEFT_DIAGONAL = {0, 1, 4, 2, 8};
    private static final int[] X_WINS_RIGHT_DIAGONAL = {6, 1, 4, 0, 2};

    private TicTacToe game;

    @Before
    public void beforeEach() {
        game = new TicTacToe();
    }

    @Test
    public void it_starts_with_no_spaces_marked() throws Exception {
        IntStream.range(0, 9).forEach(
            position -> assertThat(game.getMarkAt(position), is(NONE))
        );
    }

    @Test
    public void it_wont_allow_any_move_when_game_is_over() {
        game.play(X_WINS_ROW_1);

        for (int position : INVALID_MOVES_AFTER_X_WINS_ROW_1) {
            assertThat(game.canMark(position), is(false));
        }
    }

    @Test
    public void move_succeeds_when_space_hasnt_been_marked() {
        assertThat(game.getMarkAt(0), is(NONE));

        game.move(0);

        assertThat(game.getMarkAt(0), is(not(NONE)));
    }

    @Test
    public void it_only_switches_turns_when_a_valid_move_is_made() throws Exception {
        game.move(0); // X
        assertThat(game.getMarkAt(0), is(X));

        game.move(0); // O tries same spot
        assertThat(game.getMarkAt(0), is(X));

        game.move(1); // Still O's turn
        assertThat(game.getMarkAt(1), is(O));
    }

    @Test
    public void players_take_turns_moving() {
        game.move(0);
        game.move(1);
        game.move(2);
        game.move(3);

        assertThat(game.getMarkAt(0), is(X));
        assertThat(game.getMarkAt(1), is(O));
        assertThat(game.getMarkAt(2), is(X));
        assertThat(game.getMarkAt(3), is(O));
    }

    @Test
    public void it_is_over_when_X_wins_in_first_row() {
        game.play(X_WINS_ROW_1);

        assertThat(game.winner(), is(X));
        assertThat(game.isOver(), is(true));
    }

    @Test
    public void it_is_over_when_X_wins_in_second_row() {
        game.play(X_WINS_ROW_2);

        assertThat(game.winner(), is(X));
        assertThat(game.isOver(), is(true));
    }

    @Test
    public void it_is_over_when_O_wins_in_first_row() {
        game.play(O_WINS_ROW_1);

        assertThat(game.winner(), is(O));
        assertThat(game.isOver(), is(true));
    }

    @Test
    public void it_is_over_when_O_wins_in_second_row() {
        game.play(O_WINS_ROW_2);

        assertThat(game.winner(), is(O));
        assertThat(game.isOver(), is(true));
    }

    @Test
    public void it_is_over_when_X_wins_in_first_column() {
        game.play(X_WINS_COL_1);

        assertThat(game.winner(), is(X));
        assertThat(game.isOver(), is(true));
    }

    @Test
    public void it_is_over_when_X_wins_in_second_column() {
        game.play(X_WINS_COL_2);

        assertThat(game.winner(), is(X));
        assertThat(game.isOver(), is(true));
    }

    @Test
    public void it_is_over_when_X_wins_on_left_diagonal() {
        game.play(X_WINS_LEFT_DIAGONAL);

        assertThat(game.winner(), is(X));
        assertThat(game.isOver(), is(true));
    }

    @Test
    public void it_is_over_when_X_wins_on_right_diagonal() {
        game.play(X_WINS_RIGHT_DIAGONAL);

        assertThat(game.winner(), is(X));
        assertThat(game.isOver(), is(true));
    }

    @Test
    public void it_is_a_draw_when_all_spaces_marked_and_no_winner() {
        game.play(NO_WINNER);

        assertThat(game.isDraw(), is(true));
    }

    @Test
    public void it_isnt_a_draw_when_no_winner_and_has_unmarked_spaces() throws Exception {
        game.play(new int[]{0, 1, 2, 3});

        assertThat(game.getMarkAt(4), is(NONE));
        assertThat(game.isDraw(), is(false));
    }

    @Test
    public void it_is_over_when_all_spaces_marked_and_no_winner() {
        game.play(NO_WINNER);

        assertThat(game.isOver(), is(true));
    }

    @Test
    public void it_isnt_over_when_no_winner_and_has_unmarked_spaces() {
        game.play(new int[]{0, 1, 2, 3});

        assertThat(game.getMarkAt(4), is(NONE));
        assertThat(game.isOver(), is(false));
    }

    @Test
    public void it_can_be_instantiated_such_that_O_moves_first() {
        game = new TicTacToe(O);

        game.move(0);

        assertThat(game.getMarkAt(0), is(O));
    }

    @Test
    public void it_can_be_instantiated_such_that_X_moves_first() {
        game = new TicTacToe(X);

        game.move(0);

        assertThat(game.getMarkAt(0), is(X));
    }

    @Test
    public void it_has_X_move_first_by_default() {
        game.move(0);

        assertThat(game.getMarkAt(0), is(X));
    }

    @Test
    public void it_will_throw_IllegalArgumentException_when_instantiated_with_invalid_player() {
        char[] invalidPlayers = {NONE, '*', '.', '1', 'A', '$'};

        for (char player : invalidPlayers) {
            try {
                game = new TicTacToe(player);
                fail(String.format("Expected IllegalArgumentException with new TicTacToe('%s')", player));
            } catch (IllegalArgumentException expected) {
            }
        }
    }
}