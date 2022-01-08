package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GenerateTest {

	@Test
	@DisplayName("서로 다른 3개의 번호가 생성되는지 테스트")
	void generate() {
		Balls computer = new Balls();
		int size = computer.getSize();
		assertThat(size).isEqualTo(3);
	}
}
