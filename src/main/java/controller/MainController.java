package controller;

import service.Computer;
import view.Baseball;

public class MainController {
	public static void main(String[] args) {
		Baseball baseball = new Baseball();
		Computer computer;
		InputController input;

		boolean isNotEnd = true;

		while(isNotEnd) {

			computer = new Computer();
			input = gameStart(baseball, computer);

			baseball.restart();
			isNotEnd = input.restart();
		}
	}

	private static InputController gameStart(Baseball baseball, Computer computer) {
		InputController input;
		do {
			baseball.inputMessage();
			input = new InputController();
			int[] ballAndStrike = computer.checkNumber(computer.getAnswer(), input.getNumber());

			System.out.println(computer.printResult(ballAndStrike[0], ballAndStrike[1]));

		} while (computer.checkNumber(computer.getAnswer(), input.getNumber())[1] != 3);
		return input;
	}
}
