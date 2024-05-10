package walking.game.player;

public class MadlyRotatingBuccaneer extends Player {
    private int turnCount;

    public MadlyRotatingBuccaneer() {
        super();
        this.turnCount = 0;
    }

    @Override
    public void turn() {
        if (turnCount % 2 == 0) {
            this.direction = this.direction.next(); 
        } else {
            this.direction = this.direction.opposite(); 
        }
        turnCount++;
    }
}