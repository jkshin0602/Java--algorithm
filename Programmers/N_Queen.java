package programmers;

public class N_Queen {

	private static int ans;
	private static int[] map;

	public static int solution(int n) {
		ans = 0;
		map = new int[n];

		go(0, n);

		return ans;
	}

	private static void go(int current, int n) {
		if (current == n) {
			ans++;
			return;
		}
		for (int i = 0; i < n; i++) {
			map[current] = i;
			if (check(current)) {
				go(current + 1, n);
			}
		}
	}

	private static boolean check(int i) {
		for (int j = 0; j < i; j++) {
			if (map[i] == map[j]) { //직선 상 위치
				return false;
			}
			if (Math.abs(i - j) == Math.abs(map[i] - map[j])) { //대각 위치
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(solution(4));
	}
}
