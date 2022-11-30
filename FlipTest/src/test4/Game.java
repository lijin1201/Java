package test4;

import java.util.Scanner;

public class Game {
	private int choice = 0;
	public static Scanner scan = new Scanner(System.in);

	public Game() {
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public static Scanner getScan() {
		return scan;
	}

	public static void setScan(Scanner scan) {
		Game.scan = scan;
	}

	public void loadingScreen(String loadText) throws InterruptedException {

		ConsoleLoad consoleHelper = new ConsoleLoad();
		for (int i = 0; i < 20; i++) {
			consoleHelper.animate(i + "", loadText);

			Thread.sleep(150);
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	public void showRules() {
		System.out.println("\n\n\n**카드 메모리 게임입니다**");
		System.out.println("- 게임방법:\n\t> 같은 알파벳의 카드 한 짝씩 맞추는 게임입니다");
		System.out.println("\t> 같은 카드라면 알파벳이 드러나게 됩니다");
		System.out.println("\t> 짝이 맞지않으면 다시 뒤집히게 됩니다");
	}

	public void showMenu() {

		System.out.println("=======게임을 시작하겠습니다========");
		System.out.println("- 메뉴:");
		System.out.println("\t> || 1 || 초급 (4x4)");
		System.out.println("\t> || 2 || 중급 (6x6) ");
		System.out.println("\t> || 3 || 고급 (8x8)");
		System.out.println("\t> || 4 || 나가기");
		System.out.print("\t> 선택하세요: ");
		int inputChoice = checkInput(1, 4);
		System.out.println(inputChoice + "을 선택하셨습니다");
	}

	public int checkInput(int min, int max) {
		int input;
		do {
//          
			while (!scan.hasNextInt()) {
				System.out.print("**숫자를 입력해주세요 ");
				scan.next();
			}

			input = scan.nextInt();
			if (input < min || input > max) {
				System.out.print("\t>>" + min + "에서 " + max + "사이의 숫자를 입력해주세요 ");
			}
		} while (input < min || input > max);
		this.choice = input;
		return input;
	}

	public void choiceFirst() throws InterruptedException {
//      
		CustomGame newDefault = new CustomGame(4, 4);
		newDefault.start();
		Thread.sleep(5000);
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	public void choiceSecond() throws InterruptedException {
//     
		CustomGame newDefault = new CustomGame(6, 6);
		newDefault.start();
		Thread.sleep(5000);
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	public void choiceThird() throws InterruptedException {
//     
		CustomGame newDefault = new CustomGame(8, 8);
		newDefault.start();
		Thread.sleep(5000);
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

}
