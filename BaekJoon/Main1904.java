package baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1904 {

	private static int[] D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		D = new int[1000001];
		go(N);
		System.out.println(D[N]);
	}

	static int go2(int N) {
		if (N == 0 || N == 1)
			return 1;
		if (N == 2)
			return 2;
		if (D[N] > 0)
			return D[N];
		return D[N] = (go2(N - 1) + go2(N - 2)) % 15746;
	}

	static void go(int N) {
		D[0] = 1;
		D[1] = 1;
		D[2] = 2;
		for (int i = 3; i <= N; i++) {
			D[i] = (D[i - 1] + D[i - 2]) % 15746;
		}
	}

	//D[N] = N개로 만들 수 있는 2진 수열
	//D[1] = 1
	//D[2] = 2
	//D[3] = 2
	//D[4] = 5
	//D[N] = D[N-1] +1
	//D[N] = D[N-2] + 2
	//D[N] = D[N-1] + D[N-2] + 3

}
