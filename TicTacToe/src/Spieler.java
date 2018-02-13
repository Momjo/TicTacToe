
public enum Spieler {
	X, O, leer;
	
	public String toString() {
		if (this == X) {
			return "X";
		} else if (this == O) {
			return "O";
		}else {
			return " ";
		}
	}
}
