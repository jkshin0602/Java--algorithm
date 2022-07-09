package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1715 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			q.add(Integer.parseInt(br.readLine()));
		}
		if (N == 1) {
			System.out.println(0);
			return;
		}
		int ans = 0;
		while (true) {
			int a = q.poll() + q.poll();
			ans += a;
			q.add(a);
			if (q.size() == 1) {
				break;
			}
		}

		System.out.println(ans);

	}

}
