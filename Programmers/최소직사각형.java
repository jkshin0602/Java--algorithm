package programmers;

public class 최소직사각형 {

	//가장 작은 지갑 만들기

	public static int solution(int[][] sizes) {
		int len = sizes.length;
		boolean[] check = new boolean[len]; // false = 가로가 더 길다, true : 세로가 더 길다
		int hMax = 0, wMax = 0, hCount = getLongHeightCount(sizes, len, check);

		if ((len / 2) < hCount) { //세로가 긴 명함이 더 많으면, 세로를 기준으로
			for (int i = 0; i < len; i++) {
				if (!check[i]) {
					swap(sizes[i]);
				}
			}
		} else { //가로가 긴 명함이 더 많으면, 가로를 기준으로
			for (int i = 0; i < len; i++) {
				if (check[i]) {
					swap(sizes[i]);
				}
			}
		}
		for (int i = 0; i < len; i++) {
			wMax = Math.max(wMax, sizes[i][0]);
			hMax = Math.max(hMax, sizes[i][1]);
		}
		return hMax * wMax;
	}

	private static int getLongHeightCount(int[][] sizes, int len, boolean[] check) {
		int hCount = 0;
		for (int i = 0; i < len; i++) {
			if (sizes[i][0] < sizes[i][1]) { // 세로가 더 길다면
				check[i] = true;
				hCount++;
			}
		}
		return hCount;
	}

	private static void swap(int[] sizes) {
		int tmp = sizes[0];
		sizes[0] = sizes[1];
		sizes[1] = tmp;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}}) == 4000);
		System.out.println(solution(new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}) == 120);
		System.out.println(solution(new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}) == 133);
	}
}
