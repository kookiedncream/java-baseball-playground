package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Balls answerBalls = new Balls();

		while (true) {

			System.out.print("숫자를 입력해주세요: ");
			String word = scanner.nextLine();
			List<Integer> userList = new ArrayList<>();
			for (int i = 0; i < word.length(); i++) {
				userList.add(word.charAt(i) - '0');
			}

			Balls userBalls = new Balls(userList);

			Validation validator = new Validation();

			if (!validator.isRightRange(userBalls)) {
				throw new IllegalArgumentException("세 자리의 숫자로 입력해주세요");
			}


			if (validator.isSame(userBalls)) {
				throw new IllegalArgumentException("서로 다른 숫자로 입력해주세요");
			}


			Judge referee = new Judge(userBalls, answerBalls);

			System.out.println(referee.getResult());

			if (referee.isGameEnd()) {
				System.out.println("정답입니다.");
				System.out.println("다시시작하려면 1, 끝내려면 2를 입력해주세요");
				String gameMessage = scanner.nextLine();
				if (gameMessage == "2") {
					break;
				}

				answerBalls = new Balls();
			}
		}
	}
}
