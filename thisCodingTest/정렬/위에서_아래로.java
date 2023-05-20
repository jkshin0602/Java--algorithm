package book.nadongbin.정렬;

import java.util.Arrays;
import java.util.Collections;

public class 위에서_아래로 {

	public static int[] solution(int[] N) {
		Integer[] array = Arrays.stream(N).boxed()
			.toArray(Integer[]::new);

		Arrays.sort(array, Collections.reverseOrder());

		return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {15, 27, 12})));
	}
}
