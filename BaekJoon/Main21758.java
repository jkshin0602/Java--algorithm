package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main21758 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] honey = new int[N + 1];
		int[] sum = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			honey[i] = Integer.parseInt(st.nextToken());
			sum[i] = honey[i] + sum[i - 1];
		}

		int answer = 0;

		//벌1(고정), 벌2(이동), 벌통(고정)
		for (int i = 2; i < N; i++) {
			int bee1 = sum[N] - honey[1] - honey[i]; //합 - 자기 위치 - 두번째 벌 위치
			int bee2 = sum[N] - sum[i]; // 합 - 출발 위치까지 누적합 = 남은 이동거리 꿀 합
			int tmp = bee1 + bee2;
			answer = Math.max(answer, tmp);
		}

		//벌(고정), 벌통, 벌(고정)
		for (int i = 2; i < N; i++) {
			int bee1 = sum[i] - honey[1];
			int bee2 = sum[N - 1] - sum[i - 1];
			int tmp = bee1 + bee2;
			answer = Math.max(answer, tmp);
		}

		//벌통(고정), 벌1(이동), 벌2(고정)
		for (int i = 2; i < N; i++) {
			int bee1 = sum[i - 1];
			int bee2 = sum[N - 1] - honey[i];  //벌2는 N위치에 고정이니 N-1까지의 합에서 첫번째 벌의 위치 꿀을 제외해주면 된다.
			int tmp = bee1 + bee2;
			answer = Math.max(answer, tmp);
		}

		System.out.println(answer);
	}
}
