package programmers;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기_1 {

	public static int solution(String numbers) {
		Set<Integer> numberSet = new HashSet<>();
		makeNumber(numberSet, numbers.toCharArray(), new boolean[numbers.length()], "");

		System.out.println(numberSet);
		int answer = 0;
		for (Integer num : numberSet) {
			if (isPrime(num)) {
				answer++;
			}
		}

		return answer;
	}

	private static boolean isPrime(int num) {
		if(num <= 1)
			return false;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static void makeNumber(Set<Integer> numberSet, char[] numbers, boolean[] used, String s) {
		for (int i = 0; i < numbers.length; i++) {
			if (!used[i]) {
				s += String.valueOf(numbers[i]);
				used[i] = true;
				makeNumber(numberSet, numbers, used, s);
				s = s.substring(0, s.length() - 1);
				used[i] = false;
			}else{
				numberSet.add(Integer.parseInt(s));
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(solution("17"));
		System.out.println(solution("011"));
	}
}
