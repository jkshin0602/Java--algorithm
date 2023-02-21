package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 압축 {

	//LZW(Lempel-Ziv-Welch) 압축 알고리즘

	public static int[] solution(String msg) {
		ArrayList<String> dictionary = init();
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < msg.length(); i++) {
			StringBuilder w = new StringBuilder(String.valueOf(msg.charAt(i)));

			// w 에 들어온 문자가 마지막 문자인경우 종료
			if (i == msg.length() - 1) {
				ans.add(dictionary.indexOf(w.toString()));
				break;
			}

			String c = String.valueOf(msg.charAt(i + 1));

			// 사전에 w+c가 있다면
			while (dictionary.contains(w + c)) {
				// w = w + c 갱신
				// c = w + c의 다음글자로 갱신
				w.append(c);
				i++;

				if (i == msg.length() - 1 || c.equals("")) {
					c = "";
					break;
				}

				c = String.valueOf(msg.charAt(i + 1));
			}

			// w + c 가 사전에 없다면 , 사전에 추가
			if (!dictionary.contains(w + c)) {
				dictionary.add(w + c);
			}

			int x = dictionary.indexOf(w.toString());
			if (x != -1) {
				ans.add(x);
			}

			// c 에 들어온 문자가 마지막글자면 종료
			if (i == msg.length() - 1 && !c.equals("")) {
				ans.add(dictionary.indexOf(c));
			}

		}

		return ans.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}

	private static ArrayList<String> init() {
		ArrayList<String> dictionary = new ArrayList<>();
		dictionary.add("");

		char c = 'A';
		for (int i = 0; i < 26; i++) {
			dictionary.add(String.valueOf(c));
			c += 1;
		}

		return dictionary;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("KAKAO")));
		System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
		System.out.println(Arrays.toString(solution("ABABABABABABABAB")));
	}
}
