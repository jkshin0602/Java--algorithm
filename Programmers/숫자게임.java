package programmers;

import java.util.Arrays;

public class 숫자게임 {
	public static int solution(int[] A, int[] B) {

		int answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		int idx = B.length-1;
		for (int i = A.length - 1; i >= 0; i--) {
			if (A[i] < B[idx]) {
				idx--;
				answer++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {5, 1, 3, 7}, new int[] {2, 2, 6, 8}));
		System.out.println(solution(new int[] {2, 2, 2, 2}, new int[] {1, 1, 1, 1}));
	}

}
