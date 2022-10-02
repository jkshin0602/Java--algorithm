package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Main1181 {

	static int N;
	static Set<String> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	static String[] s;

	public static void main(String[] args) throws Exception {
		input();
		go();
		System.out.println(sb);
	}

	private static void go() {
		s = new String[set.size()];
		set.toArray(s);
		Arrays.sort(s, ((o1, o2) -> {
			if (o1.length() == o2.length()) {
				return o1.compareTo(o2);
			}
			return o1.length() - o2.length();
		}));

		for (String tmp: s) {
			sb.append(tmp).append('\n');
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			set.add(s);
		}
	}

}
