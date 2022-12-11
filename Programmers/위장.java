package programmers;

import java.util.HashMap;
import java.util.Map;

public class 위장 {

	public static int solution(String[][] clothes) {
		Map<String, Integer> map = getClothesPartCountMap(clothes);
		// 모든 부위를 착용 안하는 경우의 수 - 1
		return getAnswer(map) -1;
	}

	private static int getAnswer(Map<String, Integer> map) {
		int answer = 1;
		for (String s : map.keySet()) {
			// 착용안하는 경우의 수 = +1
			answer *= (map.get(s)+1);
		}
		return answer;
	}

	private static Map<String, Integer> getClothesPartCountMap(String[][] clothes) {
		Map<String, Integer> map = new HashMap<>();
		for (String[] clothe : clothes) {
			if (map.containsKey(clothe[1])) {
				map.put(clothe[1], map.get(clothe[1]) + 1);
				continue;
			}
			map.put(clothe[1], 1);
		}
		return map;
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[][] {{"yellowhat", "headgear"},
			{"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
		System.out.println(solution(new String[][] {{"crowmask", "face"},
			{"bluesunglasses", "face"}, {"smoky_makeup", "face"}}));
	}
}
