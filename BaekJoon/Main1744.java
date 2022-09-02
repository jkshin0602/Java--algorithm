package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main1744 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> a1 = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> a2 = new PriorityQueue<>();
		boolean isZero = false;

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n > 0) {
				a1.add(n);
			} else if (n < 0) {
				a2.add(n);
			} else {
				isZero = true;
			}
		}

		int ans = 0;

		while (!a1.isEmpty()) {
			if (a1.size() >=2) {
				Integer tmp1 = a1.poll();
				Integer tmp2 = a1.poll();
				if (tmp1 == 1 || tmp2 == 1) {
					ans += tmp1 + tmp2;
				} else {
					ans += tmp1 * tmp2;
				}
			} else {
				Integer tmp1 = a1.poll();
				ans += tmp1;
			}
		}
		while (!a2.isEmpty()) {
			if (a2.size() >= 2) {
				Integer tmp1 = a2.poll();
				Integer tmp2 = a2.poll();
				ans += tmp1 * tmp2;
			} else {
				int tmp1 = a2.poll();
				if (!isZero) {
					ans += tmp1;
				}
			}
		}

		System.out.println(ans);

	}
}
