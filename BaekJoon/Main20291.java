package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main20291 {

	static int N;
	static TreeMap<String, Integer> m = new TreeMap<>();
	static StringBuilder sb = new StringBuilder();
	static String[] s;

	public static void main(String[] args) throws Exception {
		input();
		go();
		System.out.println(sb);
	}

	private static void go() {
		s = new String[m.size()];
		for (String key : m.keySet()) {
			sb.append(key).append(' ').append(m.get(key)).append('\n');
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), ".");
			st.nextToken();
			String tmp = st.nextToken();
			if (m.containsKey(tmp)) {
				m.put(tmp, m.get(tmp) + 1);
			} else {
				m.put(tmp, 1);
			}
		}
	}
}
