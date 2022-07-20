package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16953 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		Queue<Pair> q = new LinkedList<>();

		q.add(new Pair(A, 1));
		while (!q.isEmpty()) {
			Pair tmp = q.poll();
			if (tmp.a == B) {
				System.out.println(tmp.c);
				return;
			}
			if (tmp.a > B) {
				continue;
			}
			if ((tmp.a * 2) <= B) {
				q.add(new Pair(tmp.a * 2, tmp.c + 1));
			}
			if ((tmp.a * 10) + 1 <= B) {
				q.add(new Pair((tmp.a * 10) + 1, tmp.c + 1));
			}
		}
		System.out.println(-1);
	}

	private static class Pair {
		long a;
		int c;


		public Pair(long a, int c) {
			this.a = a;
			this.c = c;
		}
	}

}
