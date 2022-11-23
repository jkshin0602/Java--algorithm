package programmers;

import java.util.HashMap;
import java.util.Map;

class 성격유형검사하기 {
	public String solution(String[] survey, int[] choices) {
		int n = survey.length;

		Map<String, Integer> map = new HashMap<>();
		initMap(map);
		for (int i = 0; i < n; i++) {
			choice(survey[i], choices[i], map);
		}

		return find(map);
	}

	public void choice(String survey, int v, Map<String, Integer> map) {
		if (v > 4) {
			String s = survey.charAt(1) + "";
			int jumsu = map.get(s) + findJumsu(v);
			map.put(s, jumsu);

		} else if (v < 4) {
			String s = survey.charAt(0) + "";
			int jumsu = map.get(s) + findJumsu(v);
			map.put(s, jumsu);
		}
	}

	public String find(Map<String, Integer> map) {
		String answer = "";
		answer += findValue("R", "T", map);
		answer += findValue("C", "F", map);
		answer += findValue("J", "M", map);
		answer += findValue("A", "N", map);
		return answer;
	}

	public String findValue(String s1, String s2, Map<String, Integer> map) {
		int v1 = map.get(s1);
		int v2 = map.get(s2);
		if (v1 > v2) {
			return s1;
		} else if (v1 < v2) {
			return s2;
		}

		int compare = s1.compareTo(s2);
		if (compare > 0) {
			return s2;
		}
		return s1;
	}

	public void initMap(Map<String, Integer> map) {
		map.put("R", 0);
		map.put("T", 0);
		map.put("C", 0);
		map.put("F", 0);
		map.put("J", 0);
		map.put("M", 0);
		map.put("A", 0);
		map.put("N", 0);
	}

	public int findJumsu(int choice) {
		if (choice == 1 || choice == 7) {
			return 3;
		}
		if (choice == 2 || choice == 6) {
			return 2;
		}
		if (choice == 3 || choice == 5) {
			return 1;
		}
		return 0;
	}
}
