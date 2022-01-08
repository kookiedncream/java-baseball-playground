package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

	private static Balls computer;

	@BeforeEach
	void init() {
		computer = new Balls(Arrays.asList(1, 2, 3));
	}

	@Test
	@DisplayName("1개의 위치와 값을 가지는 ball 클래스 테스트")
	void makeBall() {
		Ball computer = new Ball(0, 1);
		int position = computer.getPosition();
		int value = computer.getValue();

		assertThat(position).isEqualTo(0);
		assertThat(value).isEqualTo(1);
	}

	@Test
	@DisplayName("3개의 위치와 값을 가지는 ball 클래스 테스트")
	void makeBalls() {
		int value1 = computer.getValue(0);
		int value2 = computer.getValue(1);
		int value3 = computer.getValue(2);

		assertThat(value1).isEqualTo(1);
		assertThat(value2).isEqualTo(2);
		assertThat(value3).isEqualTo(3);
	}

	@Test
	@DisplayName("숫자가 1개일 때 스트라이크 기능 구현")
	void strike1() {
		Ball com = new Ball(1, 5);
		BallStatus status = com.play(new Ball(1, 5));
		assertThat(status).isEqualTo(BallStatus.STRIKE);
	}
	@Test
	@DisplayName("숫자가 1개일 때 볼 기능 구현")
	void ball1() {
		Ball com = new Ball(1, 5);
		BallStatus status = com.play(new Ball(2, 5));
		assertThat(status).isEqualTo(BallStatus.BALL);
	}
	@Test
	@DisplayName("숫자가 1개일 때 낫싱 기능 구현")
	void nothing1() {
		Ball com = new Ball(1, 5);
		BallStatus status = com.play(new Ball(2, 6));
		assertThat(status).isEqualTo(BallStatus.NOTHING);
	}


	@Test
	@DisplayName("숫자가 3개일 때 판단 기능 구현(3스트라이크/게임 끝)")
	void match3() {
		Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
		Judge answer = new Judge(userBalls, computer);
		int strike = answer.getStrike();
		int ball = answer.getBall();

		assertThat(strike).isEqualTo(3);
		assertThat(ball).isEqualTo(0);
		assertThat(answer.isGameEnd()).isTrue();
	}

	@Test
	@DisplayName("숫자가 3개일 때 판단 기능 구현(2볼 1스트라이크)")
	void match21() {
		Balls userBalls = new Balls(Arrays.asList(2, 1, 3));
		Judge answer = new Judge(userBalls, computer);
		int strike = answer.getStrike();
		int ball = answer.getBall();

		assertThat(strike).isEqualTo(1);
		assertThat(ball).isEqualTo(2);
	}
	@Test
	@DisplayName("숫자가 3개일 때 판단 기능 구현(낫싱)")
	void match0() {
		Balls userBalls = new Balls(Arrays.asList(4, 5, 6));
		Judge answer = new Judge(userBalls, computer);

		assertThat(answer.isNothing()).isTrue();
	}
}
