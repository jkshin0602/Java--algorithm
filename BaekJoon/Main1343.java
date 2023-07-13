package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main1343 {
	//https://www.acmicpc.net/problem/1343

	private static final String A = "AAAA";
	private static final String B = "BB";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		while (input.contains("XXXX")) {
			input = input.replaceFirst("XXXX", A);
		}

		while (input.contains("XX")) {
			input = input.replaceFirst("XX", B);
		}

		if (input.contains("X")) {
			System.out.println(-1);
			return;
		}

		System.out.println(input);
	}

}
