package programmers;

public class 최대값과최솟값 {

	public static String solution(String s) {
		String[] strings = s.split(" ");
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (String string : strings) {
			int number = Integer.parseInt(string);
			max = Math.max(max, number);
			min = Math.min(min, number);
		}

		return min + " " + max;
	}

	public static void main(String[] args) {
		System.out.println(solution("1 2 3 4"));
		System.out.println(solution("-1 -2 -3 -4"));
		System.out.println(solution("-1 -1"));
	}
}
