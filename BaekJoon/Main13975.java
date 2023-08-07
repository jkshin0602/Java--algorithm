package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main13975 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int K = Integer.parseInt(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}

			long answer = 0;
			while (!pq.isEmpty()) {
				Long x1 = pq.poll();
				if (pq.isEmpty()) {
					pq.add(x1);
					break;
				}
				Long x2 = pq.poll();

				pq.add(x1 + x2);
				answer += x1 + x2;
			}

			System.out.println(answer);
		}

	}
}
