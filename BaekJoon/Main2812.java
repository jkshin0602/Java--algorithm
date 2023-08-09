package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main2812 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String num = br.readLine();
		Stack<Character> s = new Stack<>();

		for (int i = 0; i < N; i++) {
			char input = num.charAt(i);
			while (K > 0 && !s.isEmpty() && s.peek() < input) {
				s.pop();
				K--;
			}
			s.add(input);
		}

		StringBuilder sb = new StringBuilder();
		while (!s.isEmpty()) {
			if (K > 0) {
				K--;
				s.pop();
				continue;
			}
			sb.append(s.pop());
		}

		System.out.println(sb.reverse());
	}
}
