package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main2217 {
	//https://www.acmicpc.net/problem/2217

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Integer> ropes = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			ropes.add(Integer.parseInt(br.readLine()));
		}

		ropes.sort(Collections.reverseOrder());

		int answer = 0;
		for (int i = ropes.size() - 1; i >= 0; i--) {
			int max = ropes.get(i) * (i + 1);
			answer = Math.max(answer, max);
		}

		System.out.println(answer);
	}
}
