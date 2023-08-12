package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main8980 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());

		List<Post> posts = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int box = Integer.parseInt(st.nextToken());
			posts.add(new Post(from, to, box));
		}

		posts.sort((o1, o2) -> {
			if (o1.to == o2.to) {
				return o1.from - o2.from;
			}
			return o1.to - o2.to;
		});

		int[] box = new int[N + 1];
		int total = 0;
		for (int i = 0; i < M; i++) {
			Post post = posts.get(i);
			int max = 0;
			//지나가는 구간에 박스 최댓값 구하기
			for (int j = post.from; j < post.to; j++) {
				max = Math.max(max, box[j]);
			}

			//실을 수 있는 박스
			int possible = Math.min(C - max, post.box);
			total += possible;
			for (int j = post.from; j < post.to; j++) {
				box[j] += possible;
			}
		}
		System.out.println(total);
	}

	private static class Post {
		int from, to, box;

		public Post(int from, int to, int box) {
			this.from = from;
			this.to = to;
			this.box = box;
		}
	}
}
