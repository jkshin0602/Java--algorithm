package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 롤케이크_자르기 {

	// 각 조각에 동일한 가짓수의 토핑이 올라가게 자르기

	public static int solution(int[] topping) {
		int answer = 0;
		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < topping.length; i++) {
			map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
		}

		for (int i = 0; i < topping.length; i++) {
			set.add(topping[i]);
			map.put(topping[i], map.get(topping[i]) - 1);
			if (map.get(topping[i]) == 0) {
				map.remove(topping[i]);
			}
			if (set.size() == map.size()) {
				answer++;
			}

		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 1, 3, 1, 4, 1, 2}));
		System.out.println(solution(new int[] {1, 2, 3, 1, 4}));
	}
}
