package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

	private final List<Ball> balls;

	public Balls(List<Integer> ball) {
		this.balls = getBalls(ball);
	}

	private List<Ball> getBalls(List<Integer> ball) {
		List<Ball> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			list.add(new Ball(i, ball.get(i)));
		}
		return list;
	}

	public int getValue(int position) {
		return balls.get(position).getValue();
	}
}
