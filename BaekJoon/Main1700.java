package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main1700 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] order = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}

		boolean[] used = new boolean[101];
		int ans = 0;
		int put = 0;
		for (int i = 0; i < K; i++) {
			int tmp = order[i];

			if (!used[tmp]) { // 2. 꽂혀 잇지 않은 경우
				if (put < N) {//2-1. 구멍이 넉넉하면, 비어있는 공간간에 꽂기
					used[tmp] = true;
					put++;
				} else {//2-2. 구멍이 없다면,
					ArrayList<Integer> list = new ArrayList<>();
					for (int j = i; j < K; j++) { //  콘센트들이 나중에 사용되는지 확인
						if (used[order[j]] && !list.contains(order[j])) {
							list.add(order[j]);
						}
					}

					if (list.size() != N) {//2-2-1. 콘센트중 일부만 나중에 사용된다면,
						for (int j = 0; j < used.length; j++) {
							if (used[j] && !list.contains(j)) { //나중에 사용되지 않는 콘센트 제거
								used[j] = false;
								break;
							}
						}
					} else {//2-2-2. 콘텐츠중 모두 나중에 사용된다면,
						int remove = list.get(list.size() - 1);  // 늦게 사용되는 콘센트를 제거
						used[remove] = false;
					}
					used[tmp] = true;
					ans++;
				}
			}
			//  1. 이미 꽂혀있다
		}

		System.out.println(ans);

	}

}
