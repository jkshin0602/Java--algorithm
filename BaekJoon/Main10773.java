package baekjoon.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Main10773 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> s = new Stack<>();
		int K = Integer.parseInt(br.readLine());
		int ans = 0;
		int before = -1;
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0 && i != 0) {
				s.pop();
				continue;
			}
			s.add(n);
		}

		while (!s.isEmpty()) {
			ans += s.pop();
		}
		System.out.println(ans);
	}
}
