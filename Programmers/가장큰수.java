package programmers;

import java.util.Arrays;

public class 가장큰수 {

	public static String solution(int[] numbers) {
		// 1. int[] array to String[] array
		String[] numbersArray = Arrays.stream(numbers).mapToObj(String::valueOf)
			.toArray(String[]::new);

		// 2. 정렬 기준 (합친숫자가 큰 기준으로, DESC)
		Arrays.sort(numbersArray, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

		// 3. 정렬 후 가장 큰 값이 0이면 배열은 0으로만 이루어져 있다.
		if (numbersArray[0].equals("0")) {
			return "0";
		}

		return getLargestNumber(numbersArray);
	}

	private static String getLargestNumber(String[] numbersArray) {
		StringBuilder sb = new StringBuilder();
		for (String s : numbersArray) {
			sb.append(s);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {6, 10, 2}));
		System.out.println(solution(new int[] {3, 30, 34, 5, 9}));
		System.out.println(solution(new int[] {0, 0, 0, 0})); // 예외 케이스
	}
}
