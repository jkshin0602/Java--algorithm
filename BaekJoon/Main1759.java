package baekjoon.브루트포스.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1759 {

	static int L, C;
	static char[] chars;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	static void go(int k) {
		if (k == L + 1) {
			int vowel = 0, consonant = 0;
			for (int i = 1; i <= L; i++) {
				if (isVowel(chars[selected[i]])) {
					vowel++;
				} else {
					consonant++;
				}
			}
			if (vowel >= 1 && consonant >= 2) {
				for (int i = 1; i <= L; i++) {
					sb.append(chars[selected[i]]);
				}
				sb.append("\n");
			}
		} else {
			for (int i = selected[k - 1] + 1; i <= C; i++) {
				selected[k] = i;
				go(k + 1);
				selected[k] = 0;
			}

		}
	}

	private static boolean isVowel(char x) {
		return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
	}

	public static void main(String[] args) throws Exception {
		input();
		Arrays.sort(chars, 1, C + 1);
		go(1);
		System.out.println(sb);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		chars = new char[C + 1];
		selected = new int[L + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= C; i++) {
			chars[i] = st.nextToken().charAt(0);
		}
	}

}
