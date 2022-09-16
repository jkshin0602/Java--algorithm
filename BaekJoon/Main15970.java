package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main15970 {

	static int N, ans;
	static ArrayList<Integer>[] a;

	public static void main(String[] args) throws Exception {
		input();
		sort();
		find();
	}

	private static void find() {
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < a[i].size(); j++) {
				int toLeft = toLeft(i, j);
				int toRight = toRight(i, j);
				ans += Math.min(toLeft, toRight);
			}
		}
		System.out.println(ans);
	}

	private static int toLeft(int color, int idx) {
		if (idx == 0)
			return Integer.MAX_VALUE;
		return a[color].get(idx) - a[color].get(idx - 1);
	}

	private static int toRight(int color, int idx) {
		if (idx == a[color].size() - 1)
			return Integer.MAX_VALUE;
		return a[color].get(idx + 1) - a[color].get(idx);
	}

	private static void sort() {
		for (int i = 1; i <= N; i++) {
			a[i].sort(null);
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		a = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			a[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int spot = Integer.parseInt(st.nextToken());
			int color = Integer.parseInt(st.nextToken());
			a[color].add(spot);
		}
	}

}
