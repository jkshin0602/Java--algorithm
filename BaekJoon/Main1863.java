package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main1863 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] height = new int[N + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			height[i] = y;
		}

		int answer = 0;
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i <= N; i++) {
			while (!s.isEmpty() && s.peek() > height[i]) {
				answer++;
				s.pop();
			}

			if (!s.isEmpty() && s.peek() == height[i]) {
				continue;
			}

			s.push(height[i]);
		}

		System.out.println(answer);
	}

}
