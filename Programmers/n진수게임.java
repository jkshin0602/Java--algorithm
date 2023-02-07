package programmers;

public class n진수게임 {

	//1. 숫자를 0부터 차례대로 말한다. 첫번째 사람은 0, 두번째 사람은 1, ... 열번째 사람은 9
	//2. 10 이상의 숫자부터는 한자리씩 끊어서 말한다. 열한번째 사람은 10의 첫자리인 1, 열두번째 사람은 둘째 자리인 0

	// 2 <= 진법(n) <= 16
	// 0 < 미리 구할 숫자의 개수(t) <= 1,000
	// 2 <= 게임 참가 인원(m) <= 100
	// 1 <= 튜브의 순서(p) <= m

	private static String[] str = {"A", "B", "C", "D", "E", "F"};

	public static String solution(int n, int t, int m, int p) {
		String s = getArithmeticString(n, t, m);
		StringBuilder sb = new StringBuilder();

		int order = 1;
		for (int i = 0; i < s.length(); i++) {
			if (sb.length() == t)
				break;
			if (order > m) {
				order = 1;
			}
			if (order == p) {
				sb.append(s.charAt(i));
			}
			order++;
		}

		return sb.toString();
	}

	private static String getArithmeticString(int n, int t, int m) {
		StringBuilder sb = new StringBuilder("0");
		StringBuilder s;
		for (int i = 1; i <= t * m; i++) {
			s = new StringBuilder();
			int tmp = i;
			while (tmp > 0) {
				int x = tmp % n;
				if (x == 10) {
					s.append(str[0]);
				} else if (x == 11) {
					s.append(str[1]);
				} else if (x == 12) {
					s.append(str[2]);
				} else if (x == 13) {
					s.append(str[3]);
				} else if (x == 14) {
					s.append(str[4]);
				} else if (x == 15) {
					s.append(str[5]);
				} else {
					s.append(x);
				}
				tmp /= n;
			}

			sb.append(s.reverse());
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution(2, 4, 2, 1).equals("0111"));
		System.out.println(solution(16, 16, 2, 1).equals("02468ACE11111111"));
		System.out.println(solution(16, 16, 2, 2));
	}
}
