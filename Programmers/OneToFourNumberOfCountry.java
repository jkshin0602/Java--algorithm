package programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OneToFourNumberOfCountry {

	public String solution(int n) {
		String answer = "";
		int i = 0;
		while(0 < n) {
			i = n%3;

			if(0 == i) {
				n = n/3 -1;
				i = 4;
			}else n /= 3;

			if (i == 1) {
				answer = "1" + answer;
			}
			if (i == 2) {
				answer = "2" + answer;
			}
			if (i == 4) {
				answer = "4" + answer;
			}
		}

		return answer;
	}

	@Test
	void test() {
		assertEquals("1", solution(1));
		assertEquals("2", solution(2));
		assertEquals("4", solution(3));
		assertEquals("11", solution(4));
	}

}
