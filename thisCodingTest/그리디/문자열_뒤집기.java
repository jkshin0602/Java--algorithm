package book.nadongbin.문제.그리디;

import java.util.StringTokenizer;

public class 문자열_뒤집기 {

	// 0과 1로만 이루어진 문자열 S
	// 이 문자열에 있는 모든 숫자를 전부 같게 만들려고 한다.
	// 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것
	// 최소 뒤집기 횟수

	public static int solution(String s) {
		StringTokenizer st1 = new StringTokenizer(s, "1");
		StringTokenizer st2 = new StringTokenizer(s, "0");

		return Math.min(st1.countTokens(), st2.countTokens());
	}

	public static void main(String[] args) {
		System.out.println(solution("0001100"));
		System.out.println(solution("000011000111000"));
		System.out.println(solution("10101010"));
	}
}
