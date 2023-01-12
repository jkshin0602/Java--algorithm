package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 영어끝말잇기 {

	// 1. 1번부터 번호 순서대로 한 사람씩 단어 말함
	// 2. 마지막 사람이 말하면 다시 1번 시작
	// 3. 앞 사람이 말한 단어의 마지막 문자로 시작하는 단어를 말함
	// 4. 이전에 등장했던 단어는 사용할 수 없음
	// 5. 한 글자 단어는 사용 불가

	public static int[] solution(int n, String[] words) {
		List<String> list = new ArrayList<>();
		int idx = 0;
		list.add(words[0]);

		for (int i = 1; i < words.length; i++) {
			if (!list.contains(words[i])) {
				String beforeWord = list.get(idx);
				if (beforeWord.charAt(beforeWord.length() - 1) != words[i].charAt(0)) {
					return fail(n, i);
				}
				idx++;
				list.add(words[i]);
			} else {
				return fail(n, i);
			}
		}

		return new int[] {0, 0};
	}

	private static int[] fail(int n, int i) {
		int order = (i / n) + 1;
		int num = (i % n) + 1;
		return new int[] {num, order};
	}

	public static void main(String[] args) {
		System.out.println(
			Arrays.toString(solution(3,
				new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}))
		);
		System.out.println(
			Arrays.toString(solution(5,
				new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure",
					"establish", "hang", "gather", "refer", "reference", "estimate", "executive"}))
		);
		System.out.println(
			Arrays.toString(solution(2,
				new String[] {"hello", "one", "even", "never", "now", "world", "draw"}))
		);
	}
}
