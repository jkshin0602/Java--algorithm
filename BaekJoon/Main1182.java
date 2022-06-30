package baekjoon.브루트포스.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1182 {

	static int N, S, ans;
	static int[] A;

	//k번째 원소를 포함시킬 지 정하는 함수
	//value = k-1 번째 원소까지 골라진 원소들의 합

	static void go(int k, int value) {
		if (k == N + 1) {
			if (value == S)
				ans++;
		} else {
			go(k + 1, value + A[k]);

			go(k + 1, value);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		A = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		go(1, 0);
		if (S == 0) {
			ans--;
		}
		System.out.println(ans);
	}

}
