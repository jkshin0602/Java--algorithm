package book.nadongbin.그리디;

public class _1이_될_때까지 {

	public static int solution(int N, int K) {

		int ans = 0;
		while (N > 1) {
			ans++;
			if (N % K == 0) {
				N /= K;
				continue;
			}
			N--;
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(solution(25,5));
		System.out.println(solution(17,4));
	}


}
