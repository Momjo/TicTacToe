
public class TicTacToe {

	// 1 -> X ist dran
	// 2 -> O ist dran
	
	public Spieler[] ttt = new Spieler[9];
	public Spieler spielerAmZug;
	

	
	TicTacToe() {
		for(int feldIndex = 0; feldIndex < this.ttt.length; feldIndex++) {
			this.ttt[feldIndex] = null;
		}
		//wert X started
		this.spielerAmZug = Spieler.X;
	}

	public void set(int feldIndex) {
		
		if(this.ttt[feldIndex] == null) {
			
			if(this.spielerAmZug == Spieler.X) {
				this.ttt[feldIndex] = Spieler.X;
				this.spielerAmZug = Spieler.O;
			
			}else if(this.spielerAmZug == Spieler.O){
				this.ttt[feldIndex] = Spieler.O;
				this.spielerAmZug = Spieler.X;
			}
		} else {
			throw new RuntimeException("Bumm!");
		}
	}
	
	public boolean isSpielfeldVoll() {
		for(int p = 0; p<this.ttt.length; p++) {
			
			if (this.ttt[p] == null) {
				
				return false;
				
			} 
		}
		return true;
	}
	
	public boolean isDraw() {
		if (this.isSpielfeldVoll() && getWinner() == null) {
			return true;
		} else {
			return false;
		}
		
		
	}
	
	public boolean hasWon(Spieler spieler) {
		boolean hasWon = this.ttt[0]== spieler &&this.ttt[1]== spieler &&this.ttt[2]== spieler ||
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
		} else if(hasWon(Spieler.O))	{
			return Spieler.O;
		} else {
			return null;
		}
	}
	
	
	public void print() {
		
		for(int leerzeichen = 0; leerzeichen < this.ttt.length; leerzeichen++) {
			Spieler spieler = this.ttt[leerzeichen];
			
			if (spieler == null) {
				System.out.print(" _ ");
			} else {
				System.out.print("  " + spieler);
			}
			
			if(leerzeichen % 3 == 2 ) {
				System.out.println();
			}
		}
	}
	
	
	public static void main(String[] args) {
		TicTacToe T = new TicTacToe();
		T.set(0);
		T.set(1);
		T.set(4);
		T.set(2);
		T.set(5);
		T.set(3);
		
		
		T.print();
		System.out.println(T.getWinner() + " hat gewonnen");
		System.out.println(T.isDraw());
}

}
