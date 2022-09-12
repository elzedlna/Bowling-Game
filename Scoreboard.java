import java.util.List;

public class Scoreboard {
    // display scoreboard for every player
    public void printScore(List<Player> players) {
        System.out.println("\n>>>~~~~~ FINAL SCORES ~~~~~<<<\n");
        for(Player p: players) {
            System.out.println(p.getName() + ": " + p.checkScore());
            System.out.println("___________________________________________");
            System.out.print("|");

            for(int i=0;i<9;i++) {
                // strike
                if(p.checkFirstThrow(i) == 10) {
                    System.out.print("X|");
                } else {
                    System.out.print(p.checkFirstThrow(i) + "|");
                }

                if(p.checkSecondThrow(i) == 0) {
                    // System.out.print(p.checkSecondThrow(i) + "|");
                    System.out.print("-|");
                } else if((p.checkFirstThrow(i) + p.checkSecondThrow(i)) == 10 ) { // spare
                    System.out.print("/|");
                } else {
                    System.out.print(p.checkSecondThrow(i) + "|");
                }
            }

            if(p.checkFirstThrow(9) == 10) {
                System.out.print("X|");
            } else {
                System.out.print(p.checkFirstThrow(9) + "|");
            }

            if(p.checkSecondThrow(9) == 10) {
                System.out.print("X|");
            } else if((p.checkFirstThrow(9) + p.checkSecondThrow(9)) == 10) {
                System.out.print("/|");
            } else {
                System.out.print(p.checkSecondThrow(9) + "|");
            }

            // bonus if strike
            if((p.checkFirstThrow(9) == 10) || (p.checkFirstThrow(9) + p.checkSecondThrow(9) == 10)) {
                if(p.checkFirstThrow(9) == 10) {
                    System.out.println("X|");
                } else if((p.checkSecondThrow(9) + p.checkBonusThrow() == 10)) {
                    System.out.println("/|");
                } else {
                    System.out.println(p.checkBonusThrow() + "|");
                }
            } else {
                System.out.print(" |");
            }

            System.out.println("|___|___|___|___|___|___|___|___|___|_____|");
            System.out.println("\n");
        }
    }
}
