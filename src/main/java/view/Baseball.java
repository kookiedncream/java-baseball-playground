package view;

public class Baseball {

	public Baseball() {
		startGame();
	}

	private void startGame() {
		System.out.println("게임 시작");
	}

	//입력 기능 프린트
	public void inputMessage() {
		System.out.print("숫자를 입력해 주세요 : ");
	}

	//다시 시작 기능 프린트
	public void restart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
}
