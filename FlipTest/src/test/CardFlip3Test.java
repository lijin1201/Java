package test;

public class CardFlip3Test {

	public static void main(String[] args) {
		CardFlip3 c3 = new CardFlip3();
		c3.printFront();

		c3.printBoard();
		
		c3.cards[1][1].discover = true;
		
		c3.printFront();
		c3.printBoard();

	
	}
}
