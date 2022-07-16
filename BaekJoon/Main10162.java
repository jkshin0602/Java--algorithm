package baekjoon.그리디;

import java.util.*;
import java.io.*;

class Main10162{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		sb.append(N / 300).append(' ');
		N %= 300;
		sb.append(N / 60).append(' ');
		N %= 60;
		sb.append(N / 10).append(' ');
		N %= 10;

		if (N != 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(sb);
	}
}
