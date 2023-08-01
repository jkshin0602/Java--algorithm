package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main20365 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();

		int blue = 0;
		int red = 0;

		while (s.contains("BB") || s.contains("RR")) {
			s = s.replace("BB", "B").replace("RR", "R");
		}

		int answer = 1; //반드시 어떤색이든 먼저 칠한다.

		//적은 색의 값이 정답
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'B') {
				blue++;
			} else {
				red++;
			}
		}

		answer += Math.min(blue, red);
		System.out.println(answer);
	}
}
