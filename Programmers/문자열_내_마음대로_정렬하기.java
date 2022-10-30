package programmers;

import java.util.Arrays;

public class 문자열_내_마음대로_정렬하기 {

	public static String[] solution(String[] strings, int n) {
		Arrays.sort(strings, (o1, o2) -> {
			if (o1.charAt(n) == o2.charAt(n)) {
				return o1.compareTo(o2);
			}
			return o1.charAt(n) - o2.charAt(n);
		});

		return strings;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"sun", "bed", "car"}, 1)));
		System.out.println(Arrays.toString(solution(new String[] {"abce", "abcd", "cdx"}, 2)));

	}

}
