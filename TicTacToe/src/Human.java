import java.util.Scanner;

public class Human extends Player {
    private final Tic_Tac_Toe_Logic logic;
    private Scanner scanner = new Scanner(System.in);

    public Human(Tic_Tac_Toe_Logic logic) {
        this.logic = logic;
    }

    public int getMove() {
        int playerMove;
        do {
            System.out.print("set your Move: ");
            playerMove = scanner.nextInt();
        } while (logic.get(playerMove) != Spieler.leer);
        return playerMove;
    }
}
