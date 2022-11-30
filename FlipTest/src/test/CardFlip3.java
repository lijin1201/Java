package test;

import java.util.Scanner;

public class CardFlip3 {
//	public static String[][] board = new String[4][4];
	public static Card[][] cards = new Card[4][4];
	public static Scanner scanner = new Scanner(System.in);
	
	public CardFlip3() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				cards[i][j] = new Card();
			}
		}
	}

	public static void printBoard() {
		for (int i = 0; i < 4; i++) {
			System.out.print("|");
			for (int j = 0; j < 4; j++) {
				System.out.print(cards[i][j].getBack());
				System.out.print("|");

			}
			System.out.println();
		}
	}

	public static void printFront() {
		for (int i = 0; i < 4; i++) {
			System.out.print("|");
			for (int j = 0; j < 4; j++) {
				System.out.print(cards[i][j]);
				System.out.print("|");

			}
			System.out.println();
		}
	}

}
