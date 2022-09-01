package baekjoon.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main11721 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();

		int a = s.length() / 10;
		int b = s.length() % 10;

		for (int i = 0; i < a * 10; i += 10) {
			sb.append(s, i, i + 10);
			sb.append('\n');
		}
		if (b > 0) {
			sb.append(s.substring(a * 10));
		}
		System.out.println(sb);

	}
}
