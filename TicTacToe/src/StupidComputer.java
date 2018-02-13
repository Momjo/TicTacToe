import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StupidComputer extends Player {
    private final Tic_Tac_Toe_Logic logic;

    public StupidComputer(Tic_Tac_Toe_Logic logic) {
        this.logic = logic;
    }

    private boolean check(int feld1, int feld2 , int leerfeld ) {

        if (logic.get(feld1) == Spieler.X && logic.get(feld2) == Spieler.X || logic.get(feld1) == Spieler.O && logic.get(feld2) == Spieler.O) {
            if (logic.get(leerfeld) == Spieler.leer) {
                return true;
            }
        }
        return false;
    }

    public int getMove() {
        int[][] fields = {
            {1, 2, 3},
            {0, 2, 1},
            {1, 2, 0},
            {0, 2, 1},
            {0, 1, 2},
            {4, 5, 3},
            {3, 5, 4},
            {3, 4, 5},
            {7, 8, 6},
            {6, 8, 7},
            {6, 7, 8},
            {6, 3, 0},
            {3, 0, 6},
            {6, 0, 3},
            {7, 4, 1},
            {7, 1, 4},
            {4, 1, 7},
            {8, 5, 2},
            {2, 5, 8},
            {2, 8, 5},
            {6, 4, 2},
            {2, 4, 6},
            {2, 6, 4},
            {0, 4, 8},
            {8, 4, 0},
            {8, 0, 4}
        };
        
        for (int i = 0; i < fields.length; i++) {
            int field_1 = fields[i][0];
            int field_2 = fields[i][1];
            int field_3 = fields[i][2];

            if (check(field_1, field_2, field_3)) {
                return field_3;
            }
        }

        Random rn = new Random();
        int computerRandomMove;

        do {
            computerRandomMove = rn.nextInt(9);
        } while (logic.get(computerRandomMove) != Spieler.leer);

        return computerRandomMove;



        //check die horizontale Felder

       /* if (logic.get(0) == Spieler.X && logic.get(1) == Spieler.X || logic.get(0) == Spieler.O && logic.get(1) == Spieler.O) {
            if (logic.get(2) == Spieler.leer) {
                computerRandomMove = 2;
                return computerRandomMove;
            }
        }
        if (logic.get(0) == Spieler.X && logic.get(2) == Spieler.X || logic.get(0) == Spieler.O && logic.get(2) == Spieler.O) {
            if (logic.get(1) == Spieler.leer) {
                computerRandomMove = 1;
                return computerRandomMove;
            }
        }
        if (logic.get(1) == Spieler.X && logic.get(2) == Spieler.X || logic.get(1) == Spieler.O && logic.get(2) == Spieler.O) {
            if (logic.get(0) == Spieler.leer) {
                computerRandomMove = 0;
                return computerRandomMove;
            }
        }
        if (logic.get(3) == Spieler.X && logic.get(4) == Spieler.X || logic.get(3) == Spieler.O && logic.get(4) == Spieler.O) {
            if (logic.get(5) == Spieler.leer) {
                computerRandomMove = 5;
                return computerRandomMove;
            }
        }
        if (logic.get(3) == Spieler.X && logic.get(5) == Spieler.X || logic.get(3) == Spieler.O && logic.get(5) == Spieler.O) {
            if (logic.get(4) == Spieler.leer) {
                computerRandomMove = 4;
                return computerRandomMove;
            }
        }
        if (logic.get(4) == Spieler.X && logic.get(5) == Spieler.X || logic.get(4) == Spieler.O && logic.get(5) == Spieler.O) {
            if (logic.get(3) == Spieler.leer) {
                computerRandomMove = 3;
                return computerRandomMove;
            }
        }
        if (logic.get(6) == Spieler.X && logic.get(7) == Spieler.X || logic.get(6) == Spieler.O && logic.get(7) == Spieler.O) {
            if (logic.get(8) == Spieler.leer) {
                computerRandomMove = 8;
                return computerRandomMove;
            }
        }
        if (logic.get(6) == Spieler.X && logic.get(8) == Spieler.X || logic.get(6) == Spieler.O && logic.get(8) == Spieler.O) {
            if (logic.get(7) == Spieler.leer) {
                computerRandomMove = 7;
                return computerRandomMove;
            }
        }
        if (logic.get(7) == Spieler.X && logic.get(8) == Spieler.X || logic.get(7) == Spieler.O && logic.get(8) == Spieler.O) {
            if (logic.get(6) == Spieler.leer) {
                computerRandomMove = 6;
                return computerRandomMove;
            }
        }
        //check die vertikale Felder
        if (logic.get(6) == Spieler.X && logic.get(3) == Spieler.X || logic.get(6) == Spieler.O && logic.get(3) == Spieler.O) {
            if (logic.get(0) == Spieler.leer) {
                computerRandomMove = 0;
                return computerRandomMove;
            }
        }
        if (logic.get(6) == Spieler.X && logic.get(0) == Spieler.X || logic.get(6) == Spieler.O && logic.get(0) == Spieler.O) {
            if (logic.get(3) == Spieler.leer) {
                computerRandomMove = 3;
                return computerRandomMove;
            }
        }
        if (logic.get(3) == Spieler.X && logic.get(0) == Spieler.X || logic.get(3) == Spieler.O && logic.get(0) == Spieler.O) {
            if (logic.get(6) == Spieler.leer) {
                computerRandomMove = 6;
                return computerRandomMove;
            }
        }
        if (logic.get(7) == Spieler.X && logic.get(4) == Spieler.X || logic.get(7) == Spieler.O && logic.get(4) == Spieler.O) {
            if (logic.get(1) == Spieler.leer) {
                computerRandomMove = 1;
                return computerRandomMove;
            }
        }
        if (logic.get(7) == Spieler.X && logic.get(1) == Spieler.X || logic.get(7) == Spieler.O && logic.get(1) == Spieler.O) {
            if (logic.get(4) == Spieler.leer) {
                computerRandomMove = 4;
                return computerRandomMove;
            }
        }
        if (logic.get(4) == Spieler.X && logic.get(1) == Spieler.X || logic.get(4) == Spieler.O && logic.get(1) == Spieler.O) {
            if (logic.get(7) == Spieler.leer) {
                computerRandomMove = 7;
                return computerRandomMove;
            }
        }
        if (logic.get(8) == Spieler.X && logic.get(5) == Spieler.X || logic.get(8) == Spieler.O && logic.get(5) == Spieler.O) {
            if (logic.get(2) == Spieler.leer) {
                computerRandomMove = 2;
                return computerRandomMove;
            }
        }
        if (logic.get(8) == Spieler.X && logic.get(2) == Spieler.X || logic.get(8) == Spieler.O && logic.get(2) == Spieler.O) {
            if (logic.get(5) == Spieler.leer) {
                computerRandomMove = 5;
                return computerRandomMove;
            }
        }
        if (logic.get(5) == Spieler.X && logic.get(2) == Spieler.X || logic.get(5) == Spieler.O && logic.get(2) == Spieler.O) {
            if (logic.get(8) == Spieler.leer) {
                computerRandomMove = 8;
                return computerRandomMove;
            }
        }

        //check die diagonale Felder

        if (logic.get(8) == Spieler.X && logic.get(4) == Spieler.X || logic.get(8) == Spieler.O && logic.get(4) == Spieler.O) {
            if (logic.get(0) == Spieler.leer) {
                computerRandomMove = 0;
                return computerRandomMove;
            }
        }
        if (logic.get(8) == Spieler.X && logic.get(0) == Spieler.X || logic.get(8) == Spieler.O && logic.get(0) == Spieler.O) {
            if (logic.get(4) == Spieler.leer) {
                computerRandomMove = 4;
                return computerRandomMove;
            }
        }
        if (logic.get(4) == Spieler.X && logic.get(0) == Spieler.X || logic.get(4) == Spieler.O && logic.get(0) == Spieler.O) {
            if (logic.get(8) == Spieler.leer) {
                computerRandomMove = 8;
                return computerRandomMove;
            }
        }
        if (logic.get(6) == Spieler.X && logic.get(4) == Spieler.X || logic.get(6) == Spieler.O && logic.get(4) == Spieler.O) {
            if (logic.get(2) == Spieler.leer) {
                computerRandomMove = 2;
                return computerRandomMove;
            }
        }
        if (logic.get(6) == Spieler.X && logic.get(2) == Spieler.X || logic.get(6) == Spieler.O && logic.get(2) == Spieler.O) {
            if (logic.get(4) == Spieler.leer) {
                computerRandomMove = 4;
                return computerRandomMove;
            }
        }
        if (logic.get(4) == Spieler.X && logic.get(2) == Spieler.X || logic.get(4) == Spieler.O && logic.get(2) == Spieler.O) {
            if (logic.get(6) == Spieler.leer) {
                computerRandomMove = 6;
                return computerRandomMove;
            }
        }*/


    }
}
