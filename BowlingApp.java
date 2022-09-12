import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BowlingApp {
    public static void main(String[] args) throws IOException {
        final BowlingSystem bs = new BowlingSystem();
        List<Player> players = new ArrayList<Player>();

        String select = "";
        String name;
        System.out.println("Welcome to Java Bowling Game!");
        System.out.println("MENU:");

        // choose whether to add player or to start
        while(!select.equals("2")) {
            bs.mainMenu(select);
            select = new BufferedReader(new InputStreamReader(System.in)).readLine();
            switch(Integer.parseInt(select)) {
                case 1: // add player
                    System.out.print("\nEnter name: ");
                    name = new BufferedReader(new InputStreamReader(System.in)).readLine();
                    players.add(new Player(name));
                    System.out.print("Player: " + name);
                    break;
                case 2: // start bowling
                    bs.printPlayerInfo(players);
                    break;
                default: // error
                    System.out.println("Invalid option!");
                    System.out.println("");
            }
        }

        // frames 1-9
        for(int i=0;i<9;i++) {
            System.out.println("\n>>>~~~~~ FRAME " + (i+1) + " ~~~~~<<<");
            for(Player p:players) {
                bs.Frame(p, i);
            }
        }

        // final frame
        System.out.println("\n>>>~~~~~ FINAL FRAME ~~~~~<<<");
        for(Player p:players) {
            bs.LastFrame(p, 9);
        }

        // scoreboard
        final Scoreboard sb = new Scoreboard();
        sb.printScore(players);
    }
}
