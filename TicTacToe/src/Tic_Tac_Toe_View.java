import java.util.Random;
import java.util.Scanner;

public class Tic_Tac_Toe_View {
    private final Tic_Tac_Toe_Logic logic;

    private Player x;
    private Player o;


    public Tic_Tac_Toe_View(Tic_Tac_Toe_Logic logic, Player x, Player o) {
        this.logic = logic;
        this.x = x;
        this.o = o;
    }

    public void printBoard() {
        System.out.println("   |   |");
        System.out.println(" " + logic.get(6) + " | " + logic.get(7) + " | " + logic.get(8));
        System.out.println("   |   |");
        System.out.println("-----------");
        System.out.println("   |   |");
        System.out.println(" " + logic.get(3) + " | " + logic.get(4) + " | " + logic.get(5));
        System.out.println("   |   |");
        System.out.println("-----------");
        System.out.println("   |   |");
        System.out.println(" " + logic.get(0) + " | " + logic.get(1) + " | " + logic.get(2));
        System.out.println("   |   |\n");
    }


    public static Spieler whoIsFirst() {
        Random rn = new Random();
        int randomNumber = rn.nextInt(2);
        if (randomNumber == 1) {
            return Spieler.O;
        } else {
            return Spieler.X;
        }
    }

    public void gameLoop() {

        while (logic.getWinner() == null) {
            int move;
            if (logic.getSpielerAmZug() == Spieler.X) {
                move = x.getMove();
            } else {
                move = o.getMove();
            }
            logic.set(move);
            printBoard();

            if (logic.getWinner() == null && spielFeldIstVoll() == true) {
                System.out.println("Unentschieden");
                break;
            }
        }
        System.out.println(logic.getWinner() != null ? logic.getWinner() + " hat gewonnen " : "Niemand hat gewonnen\n");
    }

    public boolean spielFeldIstVoll() {
        int i = 0;

        while (i < 9) {
            if (logic.get(i) == Spieler.leer) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static boolean[] getPlayers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1: Spieler gegen Spieler \t 2: Spieler gegen Computer \t 3: Computer gegen Computer");
        int n = scanner.nextInt();

        if (n == 1) {
            return new boolean[]{false, false};
        } else if (n == 2) {

            System.out.println("X oder O ?");
            String player = scanner.next().toUpperCase();

            if (player.equals("X")) {

                return new boolean[]{false, true};

            } else if (player.equals("O")) {

                return new boolean[]{true, false};

            } else {
                System.out.println("\nWrong letter, select X or O :)");
            }

        } else if(n < 3){
            System.out.println("Ungültige Nummer");
        }
        return new boolean[]{true, true};
    }

    public static void main(String[] args) {

        boolean[] players = getPlayers();
        Spieler startSpieler = whoIsFirst();
        Tic_Tac_Toe_Logic logic = new Tic_Tac_Toe_Logic(startSpieler);

        Player player_x;
        Player player_o;

        if(players[0] == true){
            player_x = new StupidComputer(logic);

        }else{
            player_x = new Human(logic);

        }
        if(players[1] == true){
            player_o = new StupidComputer(logic);

        }else{
            player_o = new Human(logic);
        }

        Tic_Tac_Toe_View view = new Tic_Tac_Toe_View(logic, player_x, player_o);

        System.out.println(startSpieler + " fängt an");
        view.printBoard();

        view.gameLoop();

    }
}
