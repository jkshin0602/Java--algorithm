package programmers;

public class N개의최소공배수 {

	public static int solution(int[] arr) {

		if (arr.length == 1) {
			return arr[0];
		}

		int lcm = arr[0];

		for (int i = 1; i < arr.length; i++) {
			int gcd = gcd(lcm, arr[i]);
			lcm = lcm(lcm, arr[i], gcd);
		}

		return lcm;
	}

	private static int lcm(int a, int b, int gcd) {
		return a * b / gcd;
	}

	private static int gcd(int a, int b) {
		int tmp = a % b;

		if (tmp == 0) {
			return b;
		} else {
			return gcd(b, tmp);
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 6, 8, 14}));
		System.out.println(solution(new int[] {1, 2, 3}));
	}
}
