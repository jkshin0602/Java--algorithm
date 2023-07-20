package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main1541 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		String[] split = br.readLine().split("-");

		for (int i = 0; i < split.length; i++) {
			int sum = 0;
			String[] split2 = split[i].split("\\+");
			for (String sub2 : split2) {
				sum += Integer.parseInt(sub2);
			}

			if (i == 0) {
				ans += sum;
			} else {
				ans -= sum;
			}

		}

		System.out.println(ans);
	}
}
