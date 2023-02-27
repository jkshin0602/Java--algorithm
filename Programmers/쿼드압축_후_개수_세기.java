package programmers;

public class 쿼드압축_후_개수_세기 {

	// 압축하고자 하는 영역 S
	// S 내부에 있는 모든 수가 같은 값이라면, S를 해당 수 하나로 압축
	// 그렇지 않다면 S를 정확히 4개의 균일한 정사각형 영역으로 쪼갠뒤, 각 정사각형 영역에 대해 같은 방식으로 압축을 시도
	// 배열에 최종적으로 남는 0의 개수와 1의 개수 리턴

	private static int zero = 0;
	private static int one = 0;

	public static int[] solution(int[][] arr) {
		int len = arr.length;
		go(0, 0, len, arr);
		return new int[] {zero, one};
	}

	private static void go(int y, int x, int size, int[][] arr) {
		if (check(y, x, size, arr)) { // 1. 압축이 가능하다면
			if (arr[y][x] == 0) {
				zero++;
			} else {
				one++;
			}
			return;
		}

		int nextSize = size / 2;

		go(y, x, nextSize, arr);
		go(y, x + nextSize, nextSize, arr);
		go(y + nextSize, x, nextSize, arr);
		go(y + nextSize, x + nextSize, nextSize, arr);
	}

	private static boolean check(int y, int x, int size, int[][] arr) {
		int val = arr[y][x];

		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (arr[i][j] != val) {
					return false;
				}
			}
		}

		return true;
	}

}
