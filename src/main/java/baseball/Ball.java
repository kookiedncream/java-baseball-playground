package baseball;

public class Ball {

	private final int position;
	private final int value;

	public Ball(int position, int value) {
		this.position = position;
		this.value = value;
	}

	public int getPosition() {
		return this.position;
	}

	public int getValue() {
		return this.value;
	}

	public BallStatus play(Ball ball) {
		if (this.equals(ball)) {
			return BallStatus.STRIKE;
		}
		if (matchBallValue(ball.getValue(), this.value)) {
			return BallStatus.BALL;
		}

		return BallStatus.NOTHING;
	}

	private boolean matchBallValue(int value, int p) {
		return value == p;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Ball ball = (Ball) o;
		return position == ball.position && value == ball.value;
	}
}
