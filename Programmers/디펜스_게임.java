package programmers;

import java.util.PriorityQueue;

public class 디펜스_게임 {

	//처음에 병사 n명을 가지고 있다.
	//매 라운드마다 enemy[i] 마리 적 등장
	//남은 병사 중 enemy[i] 만큼 소모하며 enemy[i] 마리 적을 막을 수 있음
	//남은 병수의 수 보다 현재 라운드의 적의 수가 더 많으면 게임 종료
	//무적권을 사용하면, 병사의 소모 없이 한 라운드 공격 막기 가능
	//무적권은 최대 k 번 사용

	// 1 ≤ n ≤ 1,000,000,000
	// 1 ≤ k ≤ 500,000
	// 1 ≤ enemy의 길이 ≤ 1,000,000
	// 1 ≤ enemy[i] ≤ 1,000,000

	public static int solution(int n, int k, int[] enemy) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < enemy.length; i++) {
			q.add(enemy[i]);
			if (q.size() > k) {
				n -= q.poll();
			}
			if (n < 0) {
				return i;
			}
		}
		return enemy.length;
	}

	public static void main(String[] args) {
		System.out.println(solution(7, 3, new int[] {4, 2, 4, 5, 3, 3, 1}));
		System.out.println(solution(1, 3, new int[] {1, 1, 1, 1}));
		System.out.println(solution(2, 4, new int[] {3, 3, 3, 3}));
	}
}
