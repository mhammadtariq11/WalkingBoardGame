package walking.game;
import walking.game.util.Direction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.provider.*;
import static check.CheckThat.*;
import static check.CheckThat.Condition.*;

import walking.game.util.Direction;
import walking.game.WalkingBoard;

import org.junit.jupiter.params.ParameterizedTest;

public class WalkingBoardTest {
    @Test
    public void testSimpleInit(){
        WalkingBoard board=new WalkingBoard(3);

        assertEquals(3, board.getTile(0, 0));
        assertEquals(3, board.getTile(2, 2));

    }
    @ParameterizedTest
    @CsvSource({"0,0, 3", "2,2, 9","0,1, 3","0,2, 3","1,0, 4","1,1, 5"})
    public void testCustomInit(int x,int y, int value){
        int[][] tiles = {{1,2,3},{4,5,6},{7,8,9}};
        WalkingBoard board = new WalkingBoard(tiles);
        assertEquals(value, board.getTile(x,y));

    }
    @Test
    public void testMoves() {
        WalkingBoard board = new WalkingBoard(3);
        board.moveAndSet(Direction.RIGHT, 60);
        assertEquals(60, board.getTile(1, 0));
        board.moveAndSet(Direction.DOWN, 50);
        assertEquals(50, board.getTile(1, 1));
        board.moveAndSet(Direction.RIGHT, 40);
        assertEquals(40, board.getTile(2, 1));
        board.moveAndSet(Direction.RIGHT, 60);
        assertEquals(40, board.getTile(2, 1));
        

    }

}