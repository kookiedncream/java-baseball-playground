package service;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Computer {

	private static final int SIZE = 3;
	private static final int MAX_VALUE = 9;
	private static final int MIN_VALUE = 1;

	private Set<Integer> answer;

	public Computer() {
		this.answer = generateNumber();
	}

	private Set<Integer> generateNumber() {
		Set<Integer> numbers = new LinkedHashSet<>();

		while (numbers.size() < SIZE) {
			numbers.add((int) (Math.random() * MAX_VALUE) + MIN_VALUE);
		}

		return numbers;
	}

	public int getNumberSize() {
		return answer.size();
	}

	public Set<Integer> getAnswer() {
		return this.answer;
	}
	public int[] checkNumber(Set<Integer> answer, Set<Integer> input) {
		int[] state = new int[2];

		int ball = 0;
		int strike = 0;

		Integer[] answerArray = getIntegerArray(answer);

		Integer[] inputArray = getIntegerArray(input);


		strike = getStrike(strike, answerArray, inputArray);
		ball = getBall(answer, ball, inputArray);

		state[0] = ball;
		state[1] = strike;

		return state;
	}

	private Integer[] getIntegerArray(Set<Integer> answer) {
		Integer[] answerArray = new Integer[3];
		Iterator<Integer> iterator = answer.iterator();
		for (int i = 0; i < 3; i++) {
			answerArray[i] = (iterator.next());
		}
		return answerArray;
	}

	private int getBall(Set<Integer> answer, int ball, Integer[] inputArray) {
		for (int i = 0; i < SIZE; i++) {

			ball += getBall(answer, inputArray, i);
			continue;
		}
		return ball;
	}

	private int getBall(Set<Integer> answer, Integer[] inputArray, int i) {
		Integer[] answerArray = getIntegerArray(answer);

		if (answerArray[i] == inputArray[i]) {
			return 0;
		}

		if (answer.contains(inputArray[i])) {
			return 1;
		}
		return 0;
	}

	private int getStrike(int strike, Integer[] answerArray, Integer[] inputArray) {
		for (int i = 0; i < SIZE; i++) {
			strike += getStrike(answerArray, inputArray, i);
			continue;
		}
		return strike;
	}

	private int getStrike(Integer[] answerArray, Integer[] inputArray, int i) {
		if (answerArray[i] == inputArray[i]) {
			return 1;
		}
		return 0;
	}

	public String printResult(int ball, int strike) {
		if (strike == 3) {
			return "3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
		}

		if (ball == 0 && strike == 0) {
			return "낫싱\n";
		}

		if (ball == 0) {
			return strike + "스트라이크\n";
		}

		if (strike == 0) {
			return ball + "볼\n";
		}

		return ball + "볼" + " " + strike + "스트라이크\n";
	}
}


