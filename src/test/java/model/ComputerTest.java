package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {

	Computer computer = new Computer();

	@Test
	void computerSize() {
		assertThat(computer.getNumberSize()).isEqualTo(3);
	}
}