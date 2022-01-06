package baseball;

public class Judge {

	private int ball;
	private int strike;

	public Judge(Balls userBalls, Balls computer) {

		int ball = 0;
		int strike = 0;

		for (int i = 0; i < 3; i++) {
			strike += getStrike(userBalls, computer, i);

			ball += getBall(userBalls, computer, i);
			continue;
		}

		this.ball = ball;
		this.strike = strike;
	}

	private int getBall(Balls userBalls, Balls computer, int i) {
		if (BallStatus.BALL == computer.play(new Ball(i, userBalls.getValue(i)))) {
			return 1;
		}
		return 0;
	}

	private int getStrike(Balls userBalls, Balls computer, int i) {
		if (BallStatus.STRIKE == computer.play(new Ball(i, userBalls.getValue(i)))) {
			return 1;
		}
		return 0;
	}

	public int getStrike() {
		return this.strike;
	}

	public int getBall() {
		return this.ball;
	}

	public boolean isNothing() {
		return (this.ball == 0) && (this.strike == 0);
	}

	public boolean isGameEnd() {
		return this.strike == 3;
	}
}
