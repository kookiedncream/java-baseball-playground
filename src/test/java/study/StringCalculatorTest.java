package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

	@ParameterizedTest
	@CsvSource(value = {"2 + 3 * 4 / 2:10"}, delimiter = ':')
	void stringCalculatorTest(String value, Integer expected) {
		int result = calculate(value);
		assertThat(result).isEqualTo(expected);
	}

	private int calculate(String string) {
		String[] strings = string.split(" ");

		int temp = Integer.parseInt(strings[0]);

		for (int i = 1; i < strings.length; i = i + 2) {

			switch (strings[i]) {
				case "+":
					temp = temp + Integer.parseInt(strings[i + 1]);
					break;
				case "-":
					temp = temp - Integer.parseInt(strings[i + 1]);
					break;
				case "*":
					temp = temp * Integer.parseInt(strings[i + 1]);
					break;
				case "/":
					temp = temp / Integer.parseInt(strings[i + 1]);
					break;
			}
		}

		return temp;
	}

}