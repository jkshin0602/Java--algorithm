package baekjoon.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main2475 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		for (int i = 0; i < 5; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			ans += tmp * tmp;
		}
		ans %= 10;
		System.out.println(ans);

	}
}
