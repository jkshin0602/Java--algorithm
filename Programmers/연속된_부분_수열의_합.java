package programmers;

import java.util.Arrays;

public class 연속된_부분_수열의_합 {

	public static int[] solution(int[] sequence, int k) {
		int[] answer = new int[2];
		int[] partSum = init(sequence);

		int left = 0;
		int right = 0;
		int cur = Integer.MAX_VALUE;

		while (left <= right && right < partSum.length) {
			int part = partSum[right] - partSum[left];

			if (part <= k) { //부분합이 k보다 작거나 같다면
				if (part == k && cur > right - left) { //k랑 같다면, 부분합의 길이가 짧은 것이 답
					answer[0] = left;
					answer[1] = right - 1;
					cur = right - left;
				}
				right++; //오름차순 정렬이므로 right를 증가시키면 part 값이 증가됨
				continue;
			}

			left++; //오름차순 정렬이므로 left를 증가시키면 part 값이 감소됨
		}

		return answer;
	}

	private static int[] init(int[] sequence) {
		int[] partSum = new int[sequence.length + 1];
		partSum[0] = 0;

		for (int i = 0; i < sequence.length; i++) {
			partSum[i + 1] = partSum[i] + sequence[i];
		}

		return partSum;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5}, 7)));
		System.out.println(Arrays.toString(solution(new int[] {1, 1, 1, 2, 3, 4, 5}, 5)));
		System.out.println(Arrays.toString(solution(new int[] {2, 2, 2, 2, 2}, 6)));
	}
}
