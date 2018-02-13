public class Tic_Tac_Toe_Logic {

    private Spieler[] ttt = new Spieler[9];
    private Spieler spielerAmZug;

    public Tic_Tac_Toe_Logic(Spieler startSpieler) {
        this.spielerAmZug = startSpieler;

        for (int a = 0; a < ttt.length; a++) {
            ttt[a] = Spieler.leer;
        }
    }

    public Spieler get(int position) {
        return ttt[position];
    }

    public Spieler getSpielerAmZug(){
        return spielerAmZug;
    }

    public boolean set(int move) {
        if (move > 8 || move < 0) {
            return false;
        }

        if (ttt[move] == Spieler.X || ttt[move] == Spieler.O) {
            System.out.println("wrong place");
            return false;
        }

        if (this.spielerAmZug == Spieler.X) {
            ttt[move] = Spieler.X;
            this.spielerAmZug = Spieler.O;
        } else if (spielerAmZug == Spieler.O) {
            ttt[move] = Spieler.O;
            this.spielerAmZug = Spieler.X;
        }

        return true;
    }

    public boolean hasWon(Spieler spieler) {
        boolean hasWon = this.ttt[0] == spieler && this.ttt[1] == spieler && this.ttt[2] == spieler ||
                this.ttt[3] == spieler && this.ttt[4] == spieler && this.ttt[5] == spieler ||
                this.ttt[6] == spieler && this.ttt[7] == spieler && this.ttt[8] == spieler ||
                this.ttt[0] == spieler && this.ttt[3] == spieler && this.ttt[6] == spieler ||
                this.ttt[1] == spieler && this.ttt[4] == spieler && this.ttt[7] == spieler ||
                this.ttt[2] == spieler && this.ttt[5] == spieler && this.ttt[8] == spieler ||
                this.ttt[0] == spieler && this.ttt[4] == spieler && this.ttt[8] == spieler ||
                this.ttt[2] == spieler && this.ttt[4] == spieler && this.ttt[6] == spieler;

        return hasWon;
    }

    public Spieler getWinner() {
        if (hasWon(Spieler.X)) {
            return Spieler.X;
        } else if (hasWon(Spieler.O)) {
            return Spieler.O;
        } else {

            return null;
        }
    }


}
