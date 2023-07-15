package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main14916 {
	//https://www.acmicpc.net/problem/14916

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		if (n == 1 || n == 3) {
			System.out.println(-1);
			return;
		}

		int answer = n / 5;
		n %= 5;

		if (n % 2 != 0) {
			answer--;
			n += 5;
		}

		answer += n / 2;

		System.out.println(answer);
	}
}
