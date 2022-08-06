package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Main10610 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Character[] a = new Character[s.length()];
		int sum = 0;
		boolean checkZero = false;
		for (int i = 0; i < s.length(); i++) {
			a[i] = s.charAt(i);
			if (a[i] != '0') {
				sum += a[i] + '0';
			} else {
				checkZero = true;
			}

		}
		Arrays.sort(a, Comparator.reverseOrder());
		if (sum % 3 == 0 && checkZero) {
			print(a);
		} else {
			System.out.println(-1);
		}
	}

	public static void print(Character[] a) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			sb.append(a[i]);
		}
		System.out.println(sb);
	}
}
