package algospot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Picnic {
	public static int n, m;
	public static boolean[][] isFriends;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		isFriends = new boolean[10][10];

		while (C-- > 0) {
			for (int i = 0; i < 10; i++) {
				Arrays.fill(isFriends[i], false);
			}
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 학생의 수
			m = Integer.parseInt(st.nextToken()); // 친구쌍의 수

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				isFriends[a][b] = isFriends[b][a] = true;
			}
			System.out.println(findFriends(new boolean[10]));//이미 짝을 지은 사람을 체크
		}
	}

	public static int findFriends(boolean[] taken) {
		int a = -1;
		for (int i = 0; i < n; i++) {
			if (!taken[i]) { //짝을 안지은사람을 찾음
				a = i;
				break;
			}
		}
		if(a == -1) return 1; // 짝을 다지으면 경우의 수 1 증가
		int cnt = 0;
		for (int i = a + 1; i < n; i++) {
			if (!taken[i] && isFriends[a][i]) { //짝안지은 사람이면서 && 친구관계이면
				taken[a] = taken[i] = true;
				cnt += findFriends(taken);
				taken[a] = taken[i] = false;
			}
		}
		return cnt;
	}


}
