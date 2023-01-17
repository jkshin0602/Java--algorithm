package programmers;

public class 멀리뛰기 {

	//한번에 1칸 or 2칸

	//1 1 = 1
	//2 2 = 1+1,  2
	//3 3 = 1+1+1,1+2 	2+1,
	//5 4 = 1+1+1+1, 1+2+1, 1+1+2, 2+1+1, 2+2

	public static long solution(int n) {
		long[] d = new long[n + 1];

		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		d[0] = 0;
		d[1] = 1L;
		d[2] = 2L;

		for (int i = 3; i <= n; i++) {
			d[i] = (d[i - 1] + d[i - 2]) % 1234567;
		}

		return d[n];
	}

	public static void main(String[] args) {
		System.out.println(solution(4));
		System.out.println(solution(3));
	}
}
