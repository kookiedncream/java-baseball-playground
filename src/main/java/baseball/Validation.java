package baseball;

public class Validation {
	public boolean isSame(Balls userBalls) {
		int firstBall = getBall(userBalls, 0);
		int secondBall = getBall(userBalls, 1);
		int thirdBall = getBall(userBalls, 2);

		if (doesItSame(firstBall, secondBall, thirdBall)) {
			return true;
		}
		return false;
	}

	private int getBall(Balls userBalls, int i) {
		return userBalls.getValue(i);
	}

	private boolean doesItSame(int firstBall, int secondBall, int thirdBall) {
		return firstBall == secondBall || firstBall == thirdBall || secondBall == thirdBall;
	}

	public boolean isRightRange(Balls userBalls) {
		int sum = getBall(userBalls, 0) * 100 + getBall(userBalls, 1) * 10 + getBall(userBalls, 2);
		if (isThreeDigit(sum)) {
			return true;
		}
		return false;
	}

	private boolean isThreeDigit(int sum) {
		return sum >= 100 && sum <= 999;
	}
}
