package test;

public class CardFlip2Test {

	public static void main(String[] args) {
		CardFlip2 c2 = new CardFlip2();

		while (true) {
			System.out.println("게임을 시작하려면 n, 끝내려면 q");
			String nq = c2.scanner.nextLine();

			if (nq.equals("q")) {
				System.out.println("끝");
				break;
			} else if (nq.equals("n")) {
				c2.shuffleCards();
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						c2.board[i][j] = " _ ";
					}
				}

				c2.printBoard();
				c2.checkInput(c2.cards);
				break;
			} else {
				System.out.println("다시 입력하세요");
				continue;
			}
		}
	}

}
