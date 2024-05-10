package walking.game;

import walking.game.util.Direction;

public class WalkingBoard {
    public static final int BASE_TILE_SCORE = 3;
    private int[][] tiles;
    private int x;
    private int y;

    public WalkingBoard(int size) {
        this.tiles = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.tiles[i][j] = BASE_TILE_SCORE;
            }
        }
    }
    public WalkingBoard(int[][] tiles) {
        int numRows = tiles.length;
        int numCols = tiles[0].length; 
        this.tiles = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (tiles[i][j] < BASE_TILE_SCORE) {
                    this.tiles[i][j] = BASE_TILE_SCORE;
                } else {
                    this.tiles[i][j] = tiles[i][j];
                }
            }
        }
        
    }
    public int[] getPosition() {
        return new int[]{this.x,this.y};
    }

    public  int getTile(int x, int y) {
        if (!isValidPosition(x, y)) {
            throw new IllegalArgumentException("Wrong position: (" + x + ", " + y + ")");
        }
        return tiles[x][y];
    }

    public int[][] getTiles() {
        int numRows = tiles.length;
        int numCols = tiles[0].length;
        int[][] copy = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                copy[i][j] = tiles[i][j];
            }
        }
        return copy;
    }

    public int moveAndSet(Direction direction, int value) {
        int newX = x + getXStep(direction);
        int newY = y + getYStep(direction);
        if (!isValidPosition(newX, newY)) {
            return 0; 
        }
        int oldValue = tiles[newX][newY];
        tiles[newX][newY] = value;
        x = newX;
        y = newY;
        return oldValue;
    }
    public static int getXStep(Direction direction) {
        if (direction == Direction.LEFT) {
            return -1;
        } else if (direction == Direction.RIGHT) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public static int getYStep(Direction direction) {
        if (direction == Direction.UP) {
            return -1;
        } else if (direction == Direction.DOWN) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < tiles.length && y >= 0 && y < tiles[x].length;
    }
    public void printBoard() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                System.out.print(tiles[i][j] + " ");
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }
    public static void main(String[] args) {
        WalkingBoard board = new WalkingBoard(3);
        board.printBoard();
    }
    
}

