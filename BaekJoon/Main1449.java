package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main1449 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] a = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;
		Arrays.sort(a);
		for (int i = 0; i < N; i++) {
			if (i == N - 1) {
				ans++;
				break;
			}

			int tmp = a[i++];
			while (N > i) { //테이프길이 안에 들어오는만큼
				if (a[i] - tmp + 1 <= L) {
					i++;
				} else {
					i--;
					break;
				}
			}
			ans++;
		}
		System.out.println(ans);
	}
}
