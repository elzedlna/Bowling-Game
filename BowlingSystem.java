import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BowlingSystem {
    
    // main menu
    public void mainMenu(String select) {
        System.out.println("\n[1] Add player\n[2] Start bowling");
        System.out.print("\nOption: ");
    }

    // display player details
    public void printPlayerInfo(List<Player> players) {
        System.out.println("\nNumber of player(s): " + players.size());
        System.out.print("Players: ");
        for(Player p: players) {
            System.out.print(p.getName() + (","));
        }
    }

    // frames 1 - 9
    public void Frame(Player p,int frame) throws IOException {
        int total = 0;
        // bonus scores are calculated through bonus points
        // Strikes increment by 2, Spares increment by 1
        // later decrement by 1 for each bonus score added
        int bonus = p.checkBonusCounter();
        System.out.println("\n" + p.getName() + "'s turn.\n");
        System.out.print("First throw: ");
        int score = getScore(total);
        total += score;
        p.setFirstThrow(frame, score);

        // updates the score
        if(bonus == 1 || bonus == 2) {
            p.setScore(score + score);
            bonus -= 1;
        } else if(bonus == 3) {
            p.setScore(score + score + score);
            bonus -= 2;
        } else {
            p.setScore(score);
        }

        // if strike
        if(total == 10) {
            p.setSecondThrow(frame, 0);
            System.out.println("\n~~~~~ ||| STRIKE ||| ~~~~~");
        } else {
            // second throw if not strike
            System.out.print("Second throw: ");
            score = getScore(total);
            p.setSecondThrow(frame, score);
            if(bonus == 1) {
                p.setScore(score + score);
                bonus -= 1;
            } else {
                p.setScore(score);
            }

            total += score;
            if(total == 10) { // spare
                System.out.println("\n~~~~~ ||| SPARE  ||| ~~~~~");
            }
        }

        // update bonus counter if strike/spare
        if((p.checkFirstThrow(frame)) == 10) {
            bonus += 2;
        } else if (total == 10) {
            bonus += 1;
        }

        p.setBonusCounter(bonus);
        // System.out.println("\n" + p.getName() + ": " + p.checkScore());
    }

    public void LastFrame(Player p,int frame) throws IOException {
        int total = 0;
        int bonus = p.checkBonusCounter();
        System.out.println("\n" + p.getName() + "'s turn.\n");

        // first throw
        System.out.print("First throw: ");
        int score = getScore(total);
        total += score;
        p.setFirstThrow(frame, score);

        // update score
        if(bonus == 1 || bonus == 2) {
            p.setScore(score + score);
            bonus -= 1;
        } else if(bonus == 3) {
            p.setScore(score + score + score);
        } else {
            p.setScore(score);
        }

        // second throw if first throw strike
        if(total == 10) {
            System.out.println("\n~~~~~ ||| STRIKE ||| ~~~~~");
            bonus += 2;
            System.out.print("Second throw: ");
            score = getScore(total);
            p.setSecondThrow(frame, score);

            if(bonus == 1 || bonus == 2) {
                p.setScore(score);
                bonus -= 1;
            } else if(bonus == 3) {
                p.setScore(score + score);
                bonus -= 2;
            }
        } else {
            // second throw if first throw not strike
            System.out.print("Second throw: ");
            score = getScore();
            p.setSecondThrow(frame, score);
            total += score;

            if(bonus == 1 || bonus == 2) {
                p.setScore(score + score);
                bonus -= 1;
            } else {
                p.setScore(score);
            }
        }

        // bonus throw if strike/spare in the last frame
        if(p.checkFirstThrow(frame) == 10 || (p.checkFirstThrow(frame)+p.checkSecondThrow(frame)) == 10) {
            
            if(p.checkFirstThrow(frame) == 10) {
                System.out.println("\n~~~~~ ||| STRIKE ||| ~~~~~");
            } else if(p.checkFirstThrow(frame)+p.checkSecondThrow(frame) == 10){
                System.out.println("\n~~~~~ ||| SPARE  ||| ~~~~~");
            }

            System.out.print("Third throw: ");
            score = getScore();
            p.setBonusThrow(score);

            if(score == 10) {
                System.out.println("\n~~~~~ ||| STRIKE ||| ~~~~~");
            }
            p.setScore(score);
        }
        // System.out.println("\n" + p.getName() + ": " + p.checkScore());
    }

    public int getScore(int total) throws IOException {
        boolean valid = false;
        int temp = 0;
        while(valid == false) {
            String t = new BufferedReader(new InputStreamReader(System.in)).readLine();
            while(t.equals("")) {
                System.out.print("\nEnter a number: ");
                t = new BufferedReader(new InputStreamReader(System.in)).readLine();
            }

            temp = Integer.parseInt(t);
            if((temp < 0) || (temp + total > 10)) {
                System.out.println("Invalid number!");
            } else {
                valid = true;
            }
        }
        return temp;
    }

    // get score for bonus frame
    public int getScore() throws IOException {
        boolean valid = false;
        int temp = 0;
        String t = new BufferedReader(new InputStreamReader(System.in)).readLine();
        while(valid == false) {
            while(t.equals("")) {
                System.out.print("\nEnter a number: ");
                t = new BufferedReader(new InputStreamReader(System.in)).readLine();
            }
            temp = Integer.parseInt(t);
            if((temp < 0) || (temp > 10)) {
                System.out.println("Invalid number!");
            } else {
                valid = true;
            }
        }
        return temp;
    }
}
