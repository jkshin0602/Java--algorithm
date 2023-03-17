package programmers;

public class 덧칠하기 {

	//구역 1...n개
	//롤러의 길이 m 미터,
	//롤러는 구역의 일부분만 포함되게 칠하지 않음
	//한 구역에 여러번 페인트를 칠해도 되지만, 칠할 곳은 반드시 칠해야댐
	//페인트질 하는 횟수의 최소 횟수

	public static int solution(int n, int m, int[] section) {
		int paint = section[0] - 1;
		int ans = 0;

		for (int i : section) {
			if (paint < i) {
				paint = i + m - 1;
				ans++;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(solution(8, 4, new int[] {2, 3, 6}));
		System.out.println(solution(5, 4, new int[] {1, 3}));
		System.out.println(solution(4, 1, new int[] {1, 2, 3, 4}));
	}
}
