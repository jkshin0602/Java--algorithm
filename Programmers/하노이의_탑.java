package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 하노이의_탑 {

	//한 번에 하나의 원판만 옮길 수 있다.
	//큰 원판이 작은 원판 위에 있어서는 안된다.

	private static List<int[]> ans;

	public static int[][] solution(int n) {
		ans = new ArrayList<>();
		go(n, 1, 3, 2);
		int[][] answer = new int[ans.size()][];
		for (int i = 0; i < ans.size(); i++) {
			answer[i] = ans.get(i);
		}

		return answer;
	}

	private static void go(int n, int from, int to, int mid) {
		if (n == 1) {
			ans.add(new int[] {from, to});
			return;
		}
		//1번 기둥의 n-1 개를 3번을 걸쳐 2번으로 이동
		go(n - 1, from, mid, to);

		//가장 큰 n을 1에서 3으로 이동
		ans.add(new int[] {from, to});

		//2번 기둥의 n-1개를 1번을 걸쳐 3번으로 이동
		go(n - 1, mid, to, from);
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(solution(2)));
		System.out.println(Arrays.deepToString(solution(3)));
	}
}
