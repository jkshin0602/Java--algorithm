package baekjoon.그리디;

import java.util.*;
import java.io.*;

class Main11399 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		int tmp = 0;
		int ans = 0;
		while (!pq.isEmpty()) {
			tmp += pq.poll();
			ans += tmp;
		}
		System.out.println(ans);
	}
}