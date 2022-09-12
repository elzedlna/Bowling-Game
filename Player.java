import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Player {
    //attributes
    private String name;
    private List<Integer> first_throw = new ArrayList<Integer>();
    private List<Integer> second_throw = new ArrayList<Integer>();
    private int bonus_throw;
    private int score;
    private int bonus_counter;

    // sets the player's name
    public Player(String name) {
        this.name = name;
    }

    // get player's name
    public String getName() { return this.name; }
    
    // set first throw
    public void setFirstThrow(int frame,int score) throws IOException { this.first_throw.add(score); }
    
    // get first throw
    public int checkFirstThrow(int frame) { return this.first_throw.get(frame); }
    
    // set second throw
    public void setSecondThrow(int frame,int score) throws IOException { this.second_throw.add(score); }
    
    // get second throw
    public int checkSecondThrow(int frame) { return this.second_throw.get(frame); }

    // set bonus ball for last frame
    public void setBonusThrow(int score) { this.bonus_throw = score; }

    // get bonus ball 
    public int checkBonusThrow() { return this.bonus_throw; }

    // update total score
    public void setScore(int score) { this.score += score; }

    // get total score
    public int checkScore() { return this.score; }

    // set bonus counter
    public void setBonusCounter(int bonus) { this.bonus_counter = bonus; }

    // get bonus counter
    public int checkBonusCounter() { return this.bonus_counter; }
}