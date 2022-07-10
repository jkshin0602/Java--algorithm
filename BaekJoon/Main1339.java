package baekjoon.그리디;

import java.io.*;
import java.util.*;

class Main1339 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = new String[N];
		Integer[] alpha = new Integer[26];
		Arrays.fill(alpha, 0);
		for (int i = 0; i < N; i++) {
			s[i] = br.readLine();
		}

		for (int i = 0; i < N; i++) {
			int num = 1;
			for (int j = s[i].length() - 1; j >= 0; j--) {
				alpha[s[i].charAt(j) - 65] += num;
				num *= 10;
			}
		}

		Arrays.sort(alpha, Collections.reverseOrder());
		int index = 0;
		int number = 9;
		int answer = 0;
		while (alpha[index] != 0) {
			answer += alpha[index++] * number--;
		}
		System.out.println(answer);
	}
}
