
public enum Spieler {
	X, O;
	
	public String toString() {
		if (this == X) {
			return "X";
		} else {
			return "O";
		}
	}
}
