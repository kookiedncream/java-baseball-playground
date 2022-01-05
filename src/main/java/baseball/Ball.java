package baseball;

public class Ball {

	private static int position;
	private static int value;

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
}
