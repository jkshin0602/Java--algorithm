package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 메뉴_리뉴얼 {

	//코스 요리 제공
	//2가지 이상의 단품 메뉴로 구성
	//최소 2명 이상의 손님으로부터 주문된 단품 메뉴 조합에 대해서만 코스 요리 후보 포함
	private static Map<Integer, Map<String, Integer>> map;
	private static Set<Integer> set;
	private static int courseMax;

	public static String[] solution(String[] orders, int[] course) {
		map = new HashMap<>();
		set = new HashSet<>();
		courseMax = course[course.length - 1];

		for (int n : course) {
			map.put(n, new HashMap<>());
			set.add(n);
		}

		for (String order : orders) {
			go(getSorting(order), new StringBuilder(), 0, new boolean[order.length()]);
		}

		List<String> ans = getAns(course);

		Collections.sort(ans);

		return ans.toArray(new String[0]);
	}

	private static List<String> getAns(int[] course) {
		List<String> ans = new ArrayList<>();

		for (int n : course) {
			int max = 0;
			Map<String, Integer> tmp = map.get(n);
			for (String key : tmp.keySet()) {
				max = Math.max(max, tmp.get(key));
			}

			if (max < 2) {
				continue;
			}

			for (String key : tmp.keySet()) {
				if (tmp.get(key) == max) {
					ans.add(key);
				}
			}
		}

		return ans;
	}

	private static void go(String order, StringBuilder sb, int t, boolean[] check) {
		int len = sb.length();
		if (set.contains(len)) {
			String comb = sb.toString();
			map.get(len).put(comb, map.get(len).getOrDefault(comb, 0) + 1);
			if (sb.length() == courseMax)
				return;
		}

		for (int i = t; i < order.length(); i++) {
			if (!check[i]) {
				sb.append(order.charAt(i));
				check[i] = true;
				go(order, sb, i + 1, check);
				check[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	private static String getSorting(String menu) {
		char[] chars = menu.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}
			, new int[] {2, 3, 4})));
		System.out.println(Arrays.toString(solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}
			, new int[] {2, 3, 5})));
		System.out.println(Arrays.toString(solution(new String[] {"XYZ", "XWY", "WXA"}
			, new int[] {2, 3, 4})));
	}
}
