package programmers;

import java.util.Arrays;

public class 가장가까운같은글자 {

	// if(알파벳이 등장한적이 있다면)
	// 		마지막 등장위치 가져오기, 등장 위치 갱신
	// else
	// 		마지막 등장위치 갱신

	public static int[] solution(String s) {
		int[] location = new int[s.length()];
		int[] alpha = new int[26];

		Arrays.fill(alpha, -1);
		for (int i = 0; i < s.length(); i++) {
			if (alpha[s.charAt(i) - 'a'] > -1) {
				location[i] = i - alpha[s.charAt(i) - 'a'];
				alpha[s.charAt(i) - 'a'] = i;
				continue;
			}
			alpha[s.charAt(i) - 'a'] = i;
			location[i] = -1;
		}

		return location;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("banana")));
		System.out.println(Arrays.toString(solution("foobar")));
		System.out.println(Arrays.toString(solution("s")));
		System.out.println(Arrays.toString(solution("ss")));
		System.out.println(Arrays.toString(solution("sss")));
		System.out.println(Arrays.toString(solution("sssss")));
	}
}
