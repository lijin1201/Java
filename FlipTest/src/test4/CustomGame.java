package test4;

import java.util.ArrayList;
import java.util.Random;

public class CustomGame extends Game {
	private int row;
	private int col;
	private String[][] board = new String[10][10];
	private String[][] boardValue = new String[10][10];

	public CustomGame(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void start() throws InterruptedException {

		drawBoard();
		drawValue();

		startGame();
		endGame();
	}

	public void drawBoard() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] = "#";
			}
		}
	}

	public void drawValue() {
		Random random = new Random();
		ArrayList<String> character = new ArrayList<>();

		for (int i = 0; i < 2; i++) {
			char c = 'A';
			for (int j = 0; j < (row * col) / 2; j++) {
				character.add(String.valueOf(c));
				c++;
			}
			// 2번 반복 페어 생성
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int randomNum = random.nextInt(character.size());
				boardValue[i][j] = character.get(randomNum);
				character.remove(randomNum);
			}
		}
	}

	public void startGame() throws InterruptedException {
		int correctGuess = 0;
		int guess = (row * col) / 2 - 1;
		int min = 1;
		int inputRow1 = 0, inputCol1 = 0;
		int inputRow2 = 0, inputCol2 = 0;

		while (correctGuess < guess) {
//	          Printing normal table with '#' or when the table is Updated
			do {
				printBoard();

				System.out.println("1번째 카드 선택:");
				do {
					System.out.print("\t> 행을 선택하세요 (" + min + "-" + row + "): ");
					inputRow1 = checkInput(min, row);

					System.out.print("\t> 열을 선택하세요 (" + min + "-" + col + "): ");
					inputCol1 = checkInput(min, col);
					if (!board[inputRow1 - 1][inputCol1 - 1].equals("#")) {
						System.out.println("-------------------------------------------------------");
						System.out.println("**같은 자리를 선택하셨습니다. 다시 선택해주세요");
						System.out.println("-------------------------------------------------------");
					}
				} while (!board[inputRow1 - 1][inputCol1 - 1].equals("#"));

				System.out.println("\t>>" + boardValue[inputRow1 - 1][inputCol1 - 1] + "을 선택하셨습니다");

				printBoardWithInput(inputRow1, inputCol1);

				System.out.println("2번째 카드 선택:");
				do {
					System.out.print("\t> 행을 선택하세요 (" + min + "-" + row + "): ");
					inputRow2 = checkInput(min, row);
					System.out.print("\t> 열을 선택하세요 (" + min + "-" + col + "): ");
					inputCol2 = checkInput(min, col);
					if (!board[inputRow2 - 1][inputCol2 - 1].equals("#")) {
						System.out.println("-------------------------------------------------------");
						System.out.println("**이미 매칭된 카드를 선택하셨습니다. 다시 선택하세요");
						System.out.println("-------------------------------------------------------");
					}
				} while (!board[inputRow2 - 1][inputCol2 - 1].equals("#"));

				System.out.println("\t>>" + boardValue[inputRow2 - 1][inputCol2 - 1] + "을 선택하셨습니다");

				if (inputRow1 == inputRow2 && inputCol1 == inputCol2) {
					System.out.println("-------------------------------------------------------");
					System.out.println("**두 카드가 달라야 합니다. 다시 선택하세요");
					System.out.println("-------------------------------------------------------");
				}
			} while (inputRow1 == inputRow2 && inputCol1 == inputCol2);

			printBoardWithInputSecond(inputRow1, inputCol1, inputRow2, inputCol2);
			correctGuess = checkIsMatching(inputRow1, inputCol1, inputRow2, inputCol2, correctGuess);
			System.out.println();
			Thread.sleep(2000);
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
	}

	public void printBoard() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void printBoardWithInput(int row, int col) {
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getCol(); j++) {
				if (i == row - 1 && j == col - 1) {
					System.out.print(boardValue[i][j] + " ");
				} else {
					System.out.print(board[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public void printBoardWithInputSecond(int row1, int col1, int row2, int col2) {
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getCol(); j++) {
				if (i == row1 - 1 && j == col1 - 1 || i == row2 - 1 && j == col2 - 1) {
					System.out.print(boardValue[i][j] + "  ");
				} else {
					System.out.print(board[i][j] + "  ");
				}
			}
			System.out.println();
		}
	}

	public int checkIsMatching(int row1, int col1, int row2, int col2, int count) {
		if (boardValue[row1 - 1][col1 - 1].equals(boardValue[row2 - 1][col2 - 1])) {
			board[row1 - 1][col1 - 1] = boardValue[row1 - 1][col1 - 1];
			board[row2 - 1][col2 - 1] = boardValue[row1 - 1][col1 - 1];
			System.out.println("카드가 일치하였습니다!");
			count++;
		} else {
			System.out.println("카드가 일치하지 않습니다. 다시 시도해보세요");
		}
		System.out.println("-------------------------------------------------------");
		return count;
	}

	public void endGame() {
		System.out.println("******** 게임이 끝났습니다 ********");
		System.out.println("원래 배치된 카드: ");
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getCol(); j++) {
				System.out.print(boardValue[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("- 메뉴로 돌아갑니다");
	}

}
