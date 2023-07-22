package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main19941 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String s = br.readLine();

		boolean[] visited = new boolean[N];

		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'P') {
				int startIdx = Math.max(i - K, 0);
				int endIdx = Math.min(i + K, N - 1);
				for (int j = startIdx; j <= endIdx; j++) {
					if (s.charAt(j) == 'H' && !visited[j]) {
						visited[j] = true;
						answer++;
						break;
					}
				}
			}

		}

		System.out.println(answer);
	}
}
