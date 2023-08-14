package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main3687 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		long[] dp = getMin();

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			String max = getMax(N);

			sb.append(dp[N]).append(' ').append(max).append('\n');
		}
		System.out.println(sb);
	}

	//제일 작게 만드는 방법
	//D[i] = i개의 성냥개비를 사용하여 만들 수 있는 제일 작은 수
	private static long[] getMin() {
		long[] d = new long[101];

		Arrays.fill(d, Long.MAX_VALUE);
		d[2] = 1;
		d[3] = 7;
		d[4] = 4;
		d[5] = 2;
		d[6] = 6;
		d[7] = 8;
		d[8] = 10;

		String[] minNumberUseMatchstick = {"1", "7", "4", "2", "0", "8"};

		for (int i = 9; i <= 100; i++) {
			for (int j = 2; j <= 7; j++) {
				String s = d[i - j] + minNumberUseMatchstick[j - 2];
				d[i] = Math.min(Long.parseLong(s), d[i]);
			}
		}

		return d;
	}

	//제일 크게 만드는 방법
	//2개씩 나눠서 1로 만든다, 나머지가 있다면 몫에서 -1 해서 3개를 만든다.
	private static String getMax(int n) {
		StringBuilder sb = new StringBuilder();
		int cnt = n / 2;
		if (n % 2 != 0) {
			cnt--;
			sb.append(7);
		}

		for (int i = 0; i < cnt; i++) {
			sb.append(1);
		}

		return sb.toString();
	}
}
