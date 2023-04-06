package programmers;

import java.util.PriorityQueue;

public class 혼자_놀기의_달인 {

	//2 <= cards.length <= 100
	//cards[i] = i + 1번 상자에 담긴 카드에 적힌 숫자
	//cards[i] = x -> cards[x] = y -> cards[y] = i : 열려 있는 상자 까지 계속 연다. -> 1번 그룹
	//1번 그룹을 제외하고 남는 상자가 없으면 게임 종료 -> 점수 0점 획득
	//남은 상자 중 임의의 상자를 골라서 똑같이 그룹을 만듬
	//1번 그룹 x ... x n 번 그룹 = 최대 값 구하기

	private static boolean[] visited;
	private static int[] card;
	private static PriorityQueue<Integer> pq;

	public static int solution(int[] cards) {
		card = cards;
		visited = new boolean[cards.length];
		pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

		for (int i = 0; i < cards.length; i++) {
			if (!visited[i]) {
				int count = go(i, 0);
				pq.add(count);
			}
		}

		return pq.size() < 2 ? 0 : pq.poll() * pq.poll();
	}

	private static int go(int current, int count) {
		if (!visited[current]) {
			int x = card[current];
			visited[current] = true;
			count = go(x - 1, count + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {8, 6, 3, 7, 2, 5, 1, 4}) == 12);
		System.out.println(solution(new int[] {2, 3, 1}) == 0);
	}
}
