package book.nadongbin.구현;

public class 왕실의_나이트 {

	public static int[] dy = {-2, -2, 1, -1, 2, 2, -1, -1};
	public static int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};

	public static int solution(String location) {
		int ans = 0;
		int y = location.charAt(0) - 'a' + 1;
		int x = location.charAt(1) - '0';

		for (int i = 0; i < 8; i++) {
			int ny = dy[i] + y;
			int nx = dx[i] + x;

			if (isNotMap(ny, nx)) {
				continue;
			}
			ans++;
		}

		return ans;
	}

	private static boolean isNotMap(int ny, int nx) {
		return ny < 1 || ny > 8 || nx < 1 || nx > 8;
	}

	public static void main(String[] args) {
		System.out.println(solution("a1"));
	}
}
