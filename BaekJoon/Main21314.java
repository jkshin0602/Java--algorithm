package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main21314 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		//최대값 - 붙어 있는 M을 최대한 합치고, K로 5의 단위로 변환
		//최소값 - 붙어 있는 M을 최대한 합침, K는 개별적으로

		System.out.println(getMax(s));
		System.out.println(getMin(s));
	}

	private static String getMin(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		boolean state = false;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (!state && c == 'K') {
				sb.append(5);
				continue;
			}

			if (c == 'M') { //M의 갯수를 최대한 세준다.
				count++;
				state = true;
			}
			else if (state && c == 'K') { //M이 등장한 상태에서 K가 등장하면
				sb.append(1).append("0".repeat(count - 1)).append(5);
				state = false;
				count = 0;
			}
		}

		if (count != 0) {
			sb.append(1).append("0".repeat(count - 1));
		}

		return sb.toString();
	}

	private static String getMax(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		boolean state = false;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (!state && c == 'K') { //K가 단독으로 나왔을 때
				sb.append(5);
				continue;
			}

			if (c == 'M') {
				count++;
				state = true;
			}
			else if (state && c == 'K') { //M이 있는 상태에서 K가 나왔을 때
				sb.append(5).append("0".repeat(count));
				state = false;
				count = 0;
			}

		}

		//남은 M이 있을 때
		if (count != 0) {
			sb.append("1".repeat(count));
		}

		return sb.toString();
	}

}
