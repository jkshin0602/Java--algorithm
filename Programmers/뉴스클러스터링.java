package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 뉴스클러스터링 {

	//자카드 유사도 : 집합 간의 유사도를 검사하는 방법
	//두 집합 A,B 사이의 자카드 유사도 J(A,B)는 두 교집합 크기를 두 집합의 합집합 크기로 나눈 값으로 정의

	//문자열 유사도 계산
	//FRANCE , FRENCH , 2글자씩 끊어서
	//A={FR,RA,AN,NC,CE} B={FR,RE,EN,NC,CH}
	//A ∩ B = {FR,NC} A ∪ B = {FR,RA,AN,NC,CE,RE,EN,CH} 2/8 = 0.25

	//2<=str1,str2<=1000
	//문자열은 두 글자씩 끊어서 다중 집합의 원소로 만듦
	//영문자로 된 글자 쌍만 유효, 기타 공백이나, 숫자, 특수문자가 들어가있으면 그 쌍을 버림
	//다중 집합 원소 사이를 비교할 때, 대문자와 소문자의 차이는 무시
	//0 <= 유사도 <=1 (실수),
	//유사도 * 65536 -> 소수점 버림

	public static int solution(String str1, String str2) {
		Set<String> set = new HashSet<>();
		Map<String, Integer> map1 = initMap(str1, set);
		Map<String, Integer> map2 = initMap(str2, set);

		int unionSize = getUnionSize(map1, map2, set);

		if (unionSize == 0)
			return 65536;

		int intersectionSize = getIntersectionSize(map1, map2);

		return intersectionSize * 65536 / unionSize;
	}

	private static int getIntersectionSize(Map<String, Integer> map1, Map<String, Integer> map2) {
		int intersectionSize = 0;

		for (String s : map2.keySet()) {
			if (map1.containsKey(s)) {
				intersectionSize += Math.min(map1.get(s), map2.get(s));
			}
		}

		return intersectionSize;
	}

	private static int getUnionSize(Map<String, Integer> map1, Map<String, Integer> map2, Set<String> set) {
		int unionSize = 0;

		for (String s : set) {
			unionSize += Math.max(map1.getOrDefault(s, 0), map2.getOrDefault(s, 0));
		}

		return unionSize;
	}

	private static Map<String, Integer> initMap(String str, Set<String> set) {
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length() - 1; i++) {
			String tmp = str.substring(i, i + 2).toUpperCase();
			if (!tmp.matches("^[A-Z]*$")) {
				continue;
			}

			map.put(tmp, map.getOrDefault(tmp, 0) + 1);
			set.add(tmp);
		}

		return map;
	}

	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french"));
		System.out.println(solution("handshake", "shake hands"));
		System.out.println(solution("aa1+aa2", "AAAA12"));
		System.out.println(solution("E=M*C^2", "e=m*c^2"));
		System.out.println(solution("abab", "baba"));

	}
}
