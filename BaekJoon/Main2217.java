package baekjoon.그리디;

import java.util.*;
import java.io.*;

class Main2217{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int max = -1;
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		while (!pq.isEmpty()) {
			max = Math.max(max, pq.poll() * (pq.size()+1));
		}
		System.out.println(max);

	}
}



