package programmers;

import java.util.Arrays;

public class 다트게임 {

	public static int solution(String dartResult) {
		int[] points = new int[3];

		int cnt = 0;
		int tmp = 0;
		for (int i = 0; i < dartResult.length(); i++) {
			char c = dartResult.charAt(i);
			if (isPoint(c)) {
				points[cnt++] = pointCalc(c, Integer.parseInt(dartResult.substring(tmp, i)));
				tmp = i + 1;
			}
			tmp = getBonus(dartResult, points, cnt, tmp);
		}

		return Arrays.stream(points).sum();
	}

	private static int getBonus(String dartResult, int[] points, int cnt, int tmp) {
		if (tmp < dartResult.length()) {
			if (dartResult.charAt(tmp) == '*') {
				if (cnt < 2) {
					points[cnt - 1] *= 2;
				} else {
					points[cnt - 1] *= 2;
					points[cnt - 2] *= 2;
				}
				tmp++;
			} else if (dartResult.charAt(tmp) == '#') {
				points[cnt - 1] *= -1;
				tmp++;
			}
		}
		return tmp;
	}

	private static boolean isPoint(char c) {
		return c == 'S' || c == 'D' || c == 'T';
	}

	private static int pointCalc(char c, int point) {
		if (c == 'D') {
			point *= point;
		}
		if (c == 'T') {
			point *= point * point;
		}
		return point;
	}

	public static void main(String[] args) {
		System.out.println(solution("1S2D*3T"));
		System.out.println(solution("1D2S#10S"));
		System.out.println(solution("1D2S0T"));
		System.out.println(solution("1S*2T*3S"));
		System.out.println(solution("1D#2S*3S"));
		System.out.println(solution("1T2D3D#"));
		System.out.println(solution("1D2S3T*"));
	}
}
