package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main1439 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int zero =0, one = 0;
		char c = ' ';
		for (int i = 0; i < S.length(); i++) {
			if (c != S.charAt(i)) {
				c = S.charAt(i);
				if (c == '0') {
					zero++;
				} else {
					one++;
				}
			}
		}
		System.out.println(Math.min(zero, one));
	}
}
