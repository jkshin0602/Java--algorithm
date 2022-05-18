package fastcampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N과 M(2)
//https://www.acmicpc.net/problem/15650
public class Main15650 {

	static int N, M;
	static int[] selected, used;
	static StringBuilder sb = new StringBuilder();

	static void rec_func(int k) {
		if (k == M + 1) { // 다 골랐다면
			for (int i = 1; i <= M; i++) {
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
		}else{
			for (int cand = selected[k-1]+1; cand <= N; cand++) {
				selected[k] = cand;
				rec_func(k+1);
				selected[k] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[N + 1];
		used = new int[N + 1];

		rec_func(1);
		System.out.println(sb);
	}

}
