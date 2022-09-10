package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main1789 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		long i = 0;
		for (; i <= S; i++) {
			if (((i * i) + i) / 2 == S) {
				System.out.println(i);
				break;
			}
			if (((i * i) + i) / 2 > S) {
				System.out.println(i - 1);
				break;
			}
		}

	}
}
