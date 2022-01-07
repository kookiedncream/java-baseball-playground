package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class ValidationTest {

	@Test
	@DisplayName("인풋이 주어졌을 때 중복된 값이 있는지 확인")
	void doesNotSame() {
		Balls userBalls = new Balls(Arrays.asList(1, 2, 2));
		Validation validator = new Validation();
		boolean result = validator.isSame(userBalls);
		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("인풋이 주어졌을 때 값이 세자리인지 확인")
	void doesItThreeDigit() {
		Balls userBalls = new Balls(Arrays.asList(1, 2));
		int size = userBalls.getSize();
		assertThat(size == 3).isFalse();
	}

	@Test
	@DisplayName("인풋이 주어졌을 때 1~9까지 입력되었는지 확인")
	void hasItRightRange() {
		Balls userBalls = new Balls(Arrays.asList(0, 1, 2));
		Validation validator = new Validation();
		boolean result = validator.isRightRange(userBalls);
		assertThat(result).isFalse();
	}


}
