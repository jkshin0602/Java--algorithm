package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main1543 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();

		int al = A.length();
		int bl = B.length();

		int ans = 0;

		for (int i = 0; i < al - bl + 1; ) {
			boolean c = true;
			for (int j = 0; j < bl; j++) {
				if (A.charAt(i + j) != B.charAt(j)) {
					c = false;
				}
			}
			if (!c) {
				i++;
			} else {
				ans++;
				i += bl;
			}
		}

		System.out.println(ans);
	}
}
