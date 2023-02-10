package programmers;

public class 피로도 {

	// 1 <= k <= 5,000
	// 1 <= dungeons 세로길이(행) <= 8
	// [최소 필요 피로도, 소모 피로도]
	// 최소 필로도 >= 소모 피로도
	// 1 <= 최소 피로도, 소모 피로도 <= 1,000
	// 중복 가능

	// 최대한 많이 탐험

	private static boolean[] isVisit;

	public static int solution(int k, int[][] dungeons) {
		isVisit = new boolean[dungeons.length];

		return go(k, dungeons);
	}

	private static int go(int k, int[][] dungeons) {
		int ans = 0;

		for (int i = 0; i < dungeons.length; i++) {
			if (!isVisit[i] && k >= dungeons[i][0]) {
				isVisit[i] = true;
				ans = Math.max(ans, go(k - dungeons[i][1], dungeons));
				isVisit[i] = false;
			}
		}

		return Math.max(ans, adventure(isVisit));
	}

	private static int adventure(boolean[] isVisit) {
		int count = 0;
		for (boolean v : isVisit) {
			if (v)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(solution(80, new int[][] {{80, 20}, {50, 40}, {30, 10}}));
	}
}
