package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main2828 {
	//https://www.acmicpc.net/problem/2828

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int left = 1;
		int right = M;

		int apple = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 0; i < apple; i++) {
			int pollPosition = Integer.parseInt(br.readLine());

			if (right < pollPosition) {
				//1. 떨어지는 사과 위치보다 바구니가 왼쪽에 있다면 바구니를 오른쪽으로 이동시켜야 한다.
				while (right < pollPosition) {
					right++;
					left++;
					answer++;
				}
			} else if (left > pollPosition) {
				//2. 떨어지는 사과 위치보다 바구니가 오른쪽에 있다면 바구니를 왼쪽으로 이동시켜야 한다.
				while (left > pollPosition) {
					right--;
					left--;
					answer++;
				}
			}

			//3. 떨어지는 사과 위치가 바구니의 위치와 맞다면 바구니를 이동할 필요 없다.
		}

		System.out.println(answer);
	}
}
