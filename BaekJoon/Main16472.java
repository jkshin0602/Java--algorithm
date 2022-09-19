package baekjoon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main16472 {

	static int N;
	static String S;
	static int[] cnt;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void add(char x) {
		cnt[x - 'a']++;
	}

	private static void remove(char x) {
		cnt[x - 'a']--;
	}

	private static void go() {
		int len = S.length(), ans = 0;
		for (int R = 0, L = 0; R < len; R++) {
			add(S.charAt(R));
			int kind;
			while (true) {
				kind = 0;
				for (int i = 0; i < 26; i++) {
					if (cnt[i] != 0)
						kind++;
				}
				if (kind <= N) {
					break;
				}
				remove(S.charAt(L));
				L++;
			}
			ans = Math.max(ans, R - L + 1);
		}
		System.out.println(ans);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = br.readLine();
		cnt = new int[26];
	}
}
