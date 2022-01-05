package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallTest {
	@Test
	@DisplayName("1개의 위치와 값을 가지는 ball 클래스 테스트")
	void makeBall() {
		Ball computer = new Ball(0, 1);
		int position = computer.getPosition();
		int value = computer.getValue();

		assertThat(position).isEqualTo(0);
		assertThat(value).isEqualTo(1);
	}
}
