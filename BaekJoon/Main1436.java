package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main1436 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 666; ; i++) {
			if (String.valueOf(i).contains("666")) {
				N--;
			}
			if (N == 0) {
				System.out.println(i);
				break;
			}
		}

	}
}
