package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main1715 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			pq.add(input);
		}

		int answer = 0;
		while (pq.size() > 1) {
			Integer x1 = pq.poll();
			Integer x2 = pq.poll();
			answer += x1 + x2;
			pq.add(x1 + x2);
		}

		System.out.println(answer);
	}
}
