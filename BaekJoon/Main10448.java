package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main10448 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] triangularNumber = new int[45];
		triangularNumber[1] = 1;

		for (int i = 2; i < 45; i++) {
			triangularNumber[i] = triangularNumber[i - 1] + i;
		}

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int K = Integer.parseInt(br.readLine());
			boolean flag = false;

			for (int i = 1; i < 45; i++) {
				if (flag) {
					break;
				}
				for (int j = 1; j < 45; j++) {
					if (flag) {
						break;
					}
					for (int k = 1; k < 45; k++) {
						if (triangularNumber[i] + triangularNumber[j] + triangularNumber[k] == K) {
							flag = true;
							break;
						}
					}
				}
			}

			if (flag) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}
}
