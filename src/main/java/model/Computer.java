package model;

import java.util.HashSet;
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
		Set<Integer> numbers = new HashSet<>();

		while (numbers.size() < SIZE) {
			numbers.add((int) (Math.random() * MAX_VALUE) + MIN_VALUE);
		}

		return numbers;
	}

	public int getNumberSize() {
		return answer.size();
	}
}
