package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Balls {

	private final List<Ball> balls;

	public Balls(List<Integer> ball) {
		this.balls = getBalls(ball);
	}

	public Balls() {
		List<Integer> intBall = new ArrayList<>();
		Random random = new Random();
		getRandomBall(intBall, random);
		this.balls = getBalls(intBall);
	}

	private void getRandomBall(List<Integer> intBall, Random random) {
		while (intBall.size() < 3) {
			int randomBall = random.nextInt(8) + 1;
			makeRandomBall(intBall, randomBall);
		}
	}

	private void makeRandomBall(List<Integer> intBall, int randomBall) {
		if (doesItContain(intBall, randomBall)) {
			return;
		}
		intBall.add(randomBall);
	}

	private boolean doesItContain(List<Integer> intBall, int randomBall) {
		return intBall.contains(randomBall);
	}

	private List<Ball> getBalls(List<Integer> ball) {
		List<Ball> list = new ArrayList<>();
		for (int i = 0; i < ball.size(); i++) {
			list.add(new Ball(i, ball.get(i)));
		}
		return list;
	}

	public int getValue(int position) {
		return balls.get(position).getValue();
	}


	public BallStatus play(Ball userBall) {

		return balls.stream()
				.map(answer -> answer.play(userBall))
				.filter(status -> status != BallStatus.NOTHING)
				.findFirst()
				.orElse(BallStatus.NOTHING);
	}

	public int getSize() {
		return balls.size();
	}
}
