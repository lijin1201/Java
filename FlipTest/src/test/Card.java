package test;

public class Card {
	public String front; // 앞면
	public String back; // back side
	public boolean discover;

	Card() {
		front = "AA";
		back = "**";
		discover = false;
	}

	Card(String f, String b, boolean d) {
		front = f;
		back = b;
		discover = d;
	}

	@Override
	public String toString() {
		if (!discover) {
			return front;
		} else {
			return new String("  ");
		}
	}
	
	public String getBack() {
		return discover?"  ":back; 
	}

}
