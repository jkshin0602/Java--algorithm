package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NumberStringAndEnglishWord {

	public static int solution(String s) {

		Map<String, Integer> num = new HashMap<>();
		num.put("zero", 0);
		num.put("one", 1);
		num.put("two", 2);
		num.put("three", 3);
		num.put("four", 4);
		num.put("five", 5);
		num.put("six", 6);
		num.put("seven", 7);
		num.put("eight", 8);
		num.put("nine", 9);

		Set<String> keySet = num.keySet();

		for (String s1 : keySet) {
			s = s.replace(s1, num.get(s1).toString());
		}

		int answer = Integer.parseInt(s);

		return answer;
	}

}
