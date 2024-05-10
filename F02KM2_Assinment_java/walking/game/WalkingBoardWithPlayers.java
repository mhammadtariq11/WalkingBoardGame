package walking.game;

import walking.game.player.MadlyRotatingBuccaneer;
import walking.game.player.Player;
import walking.game.util.Direction;

public class WalkingBoardWithPlayers extends WalkingBoard {
    private Player[] players;
    private int round;
    public static final int SCORE_EACH_STEP = 13;

    public WalkingBoardWithPlayers(int size, int playerCount) {
        super(size);
        initPlayers(playerCount);
    }

    public WalkingBoardWithPlayers(int[][] board, int playerCount) {
        super(board); 
        initPlayers(playerCount);
        
    }

    private void initPlayers(int playerCount) {
        if (playerCount < 2) {
            throw new IllegalArgumentException("playerCount must be less than or equal to 2");
        }
        players = new Player[playerCount];
        players = new Player[playerCount];
        players[0] = new MadlyRotatingBuccaneer();
        for (int i = 1; i < playerCount; i++) {
            players[i] = new Player();
        }

    }

    public int[] walk(int... stepCounts) {
        int[] scores = new int[players.length]; 
        for (int steps : stepCounts) { 
            Player currentPlayer = players[round % players.length];
            Direction currentDirection = currentPlayer.getDirection(); 
            steps = Math.min(steps, SCORE_EACH_STEP); 
            int tileValue = moveAndSet(currentDirection, steps); 
            currentPlayer.addToScore(tileValue); 
            scores[round % players.length] += tileValue; 
            round++; 
        }
        return scores; 
    }
    
}