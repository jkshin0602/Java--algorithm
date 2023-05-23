package book.nadongbin.문제.그리디;

import java.util.Arrays;

public class 볼링공_고르기 {

	//두 사람은 서로 무게가 다른 볼링공을 고른다
	//볼링 공은 총 N개가 있으며, 각 볼링공마다 무게가 적혀 있고, 공의 번호는 1번부터 순서대로 부여된다.
	//같은 무게의 공이 여러개 있을 수 있지만, 서로 다른 공으로 간주한다.
	//볼링공의 무게는 1부터 M까지 자연수 형태로 존재한다.
	//두 사람이 고를 수 있는 볼링공 번호의 조합

	//N개를 중복없이 고르는 경우의 수

	public static int solution(int M, int[] bowlingBalls) {
		int answer = 0;

		Arrays.sort(bowlingBalls);
		int[] w = new int[11];

		for (int i = 0; i < bowlingBalls.length; i++) {
			w[bowlingBalls[i]]++;
		}

		int n = bowlingBalls.length;
		for (int i = 1; i <= M; i++) {
			n -= w[i];
			answer += w[i] * n;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(3, new int[] {1, 3, 2, 3, 2}));
		System.out.println(solution(5, new int[] {1, 5, 4, 3, 2, 4, 5, 2}));
	}
}
