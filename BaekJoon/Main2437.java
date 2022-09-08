package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main2437 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		list.sort(null);

		int sum = list.get(0);
		int min = sum +1;
		for (int i = 1; i < N; i++) {
			if (sum + 1 >=  list.get(i)) {
				sum += list.get(i);
				min = sum + 1;
			}
		}
		System.out.println(list.get(0) != 1 ? 1 : min);

	}
}
