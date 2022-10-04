package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main10816 {

	static int N, M;
	static int[] n, m;
	static StringBuilder sb = new StringBuilder();

	private static void go() {
		for (int i = 0; i < M; i++) {
			sb.append(upper_bound(m[i]) - lower_bound(m[i])).append(' ');
		}
	}

	public static int lower_bound(int target) {
		int L = 0;
		int R = N;
		while (L < R) { //lower bound : 찾고자 하는 값의 첫번째 위치
			int mid = (L + R) / 2;
			if (n[mid] >= target) { //값을 찾아도 Right를 내린다. 반복문이 종료되면 그 위치가 찾고자 하는 값의 첫번째 위치
				R = mid;
			} else if (n[mid] < target) {
				L = mid + 1;
			}
		}
		return L;
	}

	public static int upper_bound(int target) {
		int L = 0;
		int R = N;
		while (L < R) { //upper bound : 찾고자 하는 값보다 큰 수의 첫번째 위치
			int mid = (L + R) / 2;
			if (n[mid] > target) {
				R = mid;
			} else if (n[mid] <= target) { // 찾아도 Left를 올린다. 반복문이 종료되면 그위치가 큰 값의 첫번째 위치
				L = mid + 1;
			}
		}
		return L;
	}

	public static void main(String[] args) throws Exception {
		input();
		go();
		System.out.println(sb);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		n = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			n[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		m = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(n);
	}
}
