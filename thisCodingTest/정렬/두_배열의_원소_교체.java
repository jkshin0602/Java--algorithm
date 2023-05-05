package book.nadongbin.정렬;

import java.util.Arrays;
import java.util.Collections;

public class 두_배열의_원소_교체 {

	public static int solution(int K, int[] A, int[] B) {
		Arrays.sort(A);
		Integer[] bArr = Arrays.stream(B).boxed().toArray(Integer[]::new);
		Arrays.sort(bArr, Collections.reverseOrder());

		for (int i = 0; i < K; i++) {
			if (A[i] < bArr[i]) {
				int tmp = A[i];
				A[i] = bArr[i];
				bArr[i] = tmp;
			}

		}

		return Arrays.stream(A)
			.sum();
	}

	public static void main(String[] args) {
		System.out.println(solution(3, new int[] {1, 2, 5, 4, 3}, new int[] {5, 5, 6, 6, 5}));
	}
}
