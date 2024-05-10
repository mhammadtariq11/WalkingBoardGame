package walking.game;
import org.junit.jupiter.api.Test;
import walking.game.WalkingBoardWithPlayers;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalkingBoardWithPlayersTest {
    @Test
    void walk1() {
        int[][] board1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int playerCount1 = 3;
        WalkingBoardWithPlayers walkingBoard1 = new WalkingBoardWithPlayers(board1, playerCount1);

        int[] steps1 = {1, 2, 3};

        int[] expectedScores1 = {15, 11, 0};
        int[][] expectedBoard1 = {
                {1, 4, 3},
                {2, 3, 3},
                {3, 3, 3}
        };
    }

    @Test
    void walk2() {
        int size2 = 4;
        int playerCount2 = 5;
        WalkingBoardWithPlayers walkingBoard2 = new WalkingBoardWithPlayers(size2, playerCount2);

        int[] steps2 = {1, 2, 3};

        int[] expectedScores2 = {18, 14, 12, 12, 8};
        int[][] expectedBoard2 = {
                {1, 4, 3, 4},
                {2, 3, 3, 4},
                {3, 3, 3, 4},
                {3, 3, 3, 4}
        };
    }

    private void assertBoardEquals(int[][] expected, int[][] actual) {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], actual[i][j]);
            }
        }
    }
}
