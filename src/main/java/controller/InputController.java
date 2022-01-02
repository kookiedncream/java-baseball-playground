package controller;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class InputController {

	private static Scanner scanner = new Scanner(System.in);
	private static Set<Integer> number;

	//입력기능
	public InputController() {
		this.number = input();
	}

	private Set<Integer> input() {
		int value = scanner.nextInt();

		validateNumber(value);

		return intToSet(value);
	}

	public Set<Integer> getNumber() {
		return this.number;
	}

	private Set<Integer> intToSet(int value) {
		Set<Integer> set = new LinkedHashSet<>();

		set.add(value / 100);
		value -= (value / 100) * 100;

		set.add(value / 10);
		value -= (value / 10) * 10;

		set.add(value);

		return set;
	}

	private void validateNumber(int value) {

		isThreeDigitNumber(value);
		haveNotZero(value);
		notSameNumber(value);
	}

	private void notSameNumber(int value) {
		String word = String.valueOf(value);
		char firstWord = word.charAt(0);
		char secondWord = word.charAt(1);
		char thirdWord = word.charAt(2);

		if ((firstWord == secondWord) ||
				(firstWord == thirdWord) ||
				(secondWord == thirdWord)) {
			throw new IllegalStateException("서로 다른 숫자를 입력해 주세요");
		}
	}

	private void haveNotZero(int value) {
		String word = String.valueOf(value);

		for (int i = 0; i < 3; i++) {
			checkZero(word, i);
		}
	}

	private void checkZero(String word, int i) {
		if (word.charAt(i) == '0') {
			throw new IllegalStateException("1 ~ 9사이의 숫자로 입력해 주세요");
		}
	}

	private void isThreeDigitNumber(int value) {
		if (value > 999 || value < 100) {
			throw new IllegalStateException("3자리 수를 입력해 주세요");
		}
	}

	//다시시작 입력 기능
}
