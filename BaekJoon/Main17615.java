package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main17615 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();

		int red = 0;
		int blue = 0;
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == 'R') {
				red++;
			} else {
				blue++;
			}
		}

		//왼쪽으로 빨간공 이동
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == 'R') {
				count++;
			} else {
				break;
			}
		}
		//전체 ball 갯수 - 왼쪽에 연속된 빨간공 개수 = 오른쪽에서 왼쪽으로 이동시킬 빨간공 개수
		int min = red - count;

		//오른쪽으로 빨간공 이동
		count = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (s.charAt(i) == 'R') {
				count++;
			} else {
				break;
			}
		}
		min = Math.min(min, red - count);

		//왼쪽으로 파란공 이동
		count = 0;
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == 'B') {
				count++;
			} else {
				break;
			}
		}
		min = Math.min(min, blue - count);

		//오른쪽으로 파란공 이동
		count = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (s.charAt(i) == 'B') {
				count++;
			} else {
				break;
			}
		}
		min = Math.min(min, blue - count);

		System.out.println(min);
	}
}
