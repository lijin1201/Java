package test4;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Game newGame = new Game();
		newGame.loadingScreen("LOADING");
		newGame.showRules();
		do {
			newGame.showMenu();
			if (newGame.getChoice() == 4) {
				System.out.println("****게임을 종료합니다****");
				newGame.loadingScreen("EXITING");
			} else if (newGame.getChoice() == 1) {
				newGame.choiceFirst();
			} else if (newGame.getChoice() == 2) {
				newGame.choiceSecond();
			} else if (newGame.getChoice() == 3) {
				newGame.choiceThird();
			}
		} while (newGame.getChoice() != 4);

	}

}
