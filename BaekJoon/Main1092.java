package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main1092 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Integer> cranes = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cranes.add(Integer.parseInt(st.nextToken()));
		}

		int M = Integer.parseInt(br.readLine());
		List<Integer> boxes = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			boxes.add(Integer.parseInt(st.nextToken()));
		}

		cranes.sort(Collections.reverseOrder());
		boxes.sort(Collections.reverseOrder());

		if (cranes.get(0) < boxes.get(0)) {
			System.out.println(-1);
			return;
		}

		int ans = 0;
		while (!boxes.isEmpty()) {
			int boxIdx = 0;
			for (int i = 0; i < N; ) {
				if (boxIdx == boxes.size()) { //박스를 모두 탐색했다면 종료
					break;
				}

				if (cranes.get(i) >= boxes.get(boxIdx)) { //제거 가능하다면
					boxes.remove(boxIdx); //박스 삭제
					i++;
				} else {
					boxIdx++;
				}
			}
			ans++;
		}

		System.out.println(ans);
	}
}

