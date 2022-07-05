package baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main9461 {

	static long[] D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			D = new long[N + 1];
			System.out.println(go(N));
		}
	}

	static long go(int N) {
		if (N == 1 || N == 2 || N == 3)
			return 1;
		if (N == 4 || N == 5)
			return 2;
		if (N == 6)
			return 3;
		if (D[N] > 0)
			return D[N];
		return D[N] = go(N - 5) + go(N - 1);
	}

	//D[1] = 1
	//D[2] = 1
	//D[3] = 1
	//D[4] = 2
	//D[5] = 2
	//D[6] = 3
	//D[7] = 4
	//D[8] = 5
	//D[9] = 7
	//D[10] = 9
	//D[11] = 12

	//D[1]+D[5] = 1+2 = 3 = D[6]
	//D[2]+D[6] = 1+3 = 4 = D[7]
	//D[3]+D[7] = 1+4 = 5 = D[8]
	//D[4]+D[8] = 2+5 = 7 = D[9]
	//D[5]+D[9] = 2+7 = 9 = D[10]

}
