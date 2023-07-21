package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main16953 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int answer = go(A, B);
		System.out.println(answer);
	}

	private static int go(int a, int b) {
		int count = -1;

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(a, 1));

		while (!q.isEmpty()) {
			Pair p = q.poll();

			if (p.result == b) {
				count = p.count;
				break;
			}

			long multiply = p.result * 2;
			long add = (p.result * 10) + 1;

			if (multiply <= b) {
				q.add(new Pair(multiply, p.count + 1));
			}

			if (add <= b) {
				q.add(new Pair(add, p.count + 1));
			}
		}

		return count;
	}

	private static class Pair {
		long result;
		int count;

		public Pair(long result, int count) {
			this.result = result;
			this.count = count;
		}
	}
}
