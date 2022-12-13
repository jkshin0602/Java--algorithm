package programmers;

public class 올바른괄호의개수 {

	private static int[] d;

	//D[i]= D[0] * D[i-1] + D[1] * D[i-2] + ... + D[i-1]*D[0];

	public static int solution(int n) {
		return init(n);
	}

	private static int init(int n) {
		d = new int[n + 1];
		d[0] = d[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				d[i] += d[j - 1] * d[i - j];
			}
		}
		return d[n];
	}

	public static void main(String[] args) {
		System.out.println(solution(2));
		System.out.println(solution(3));
	}
}

