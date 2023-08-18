package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main1202 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Jewel> jewels = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			jewels.add(new Jewel(weight, value));
		}

		jewels.sort((o1, o2) -> {
			if (o1.weight == o2.weight) {
				return o2.value - o1.value;
			}
			return o1.weight - o2.weight;
		});

		List<Integer> bags = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			int volume = Integer.parseInt(br.readLine());
			bags.add(volume);
		}

		Collections.sort(bags);

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		long answer = 0;

		for (int i = 0, j = 0; i < K; i++) {
			while (j < N && jewels.get(j).weight <= bags.get(i)) {
				pq.add(jewels.get(j++).value);
			}

			if (!pq.isEmpty()) {
				answer += pq.poll();
			}
		}

		System.out.println(answer);
	}

	private static class Jewel {
		int weight;
		int value;

		public Jewel(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
}
