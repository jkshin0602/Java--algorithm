package book.nadongbin.구현;

public class 시각 {

	public static int solution(int N) {
		int ans = 0;

		for (int h = 0; h <= N; h++) {
			for (int m = 0; m < 60; m++) {
				for (int s = 0; s < 60; s++) {
					String time = String.valueOf(h) + m + s;
					if (time.contains("3")) {
						ans++;
					}
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(solution(5));
	}

}
