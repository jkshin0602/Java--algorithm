package baekjoon.브루트포스.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15663 {

	static int N, M;
	static int[] selected, nums, used;
	static StringBuilder sb = new StringBuilder();

	static void go(int k) {
		if (k == M + 1) {
			for (int i = 1; i <= M; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append("\n");
		} else {
			int last_cand = 0;
			for (int i = 1; i <= N; i++) {
				if (used[i] == 1)
					continue;
				if (nums[i] == last_cand)
					continue;
				last_cand = nums[i];
				selected[k] = nums[i];
				used[i] = 1;
				go(k + 1);
				selected[k] = 0;
				used[i] = 0;
			}

		}
	}

	public static void main(String[] args) throws Exception {
		input();

		go(1);
		System.out.println(sb);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N + 1];
		used = new int[N + 1];
		selected = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums, 1, N + 1);
	}

}
