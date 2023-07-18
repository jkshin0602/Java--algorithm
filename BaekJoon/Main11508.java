package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main11508 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<Integer> C = new ArrayList<>(N);

		for (int i = 0; i < N; i++) {
			C.add(Integer.parseInt(br.readLine()));
		}

		C.sort(Collections.reverseOrder());

		int answer = 0;

		for (int i = 0; i < N; i++) {
			if ((i + 1) % 3 == 0) {
				continue;
			}
			answer += C.get(i);
		}

		System.out.println(answer);
	}
}
