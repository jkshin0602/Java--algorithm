package programmers;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {

	//일정 금액을 지불하면 10일 동안 회원 자격 부여
	//회원을 대상으로 매일 한 가지 제품을 할인
	//할인 제품은 하루에 하나씩 구매 가능
	//원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입
	private static int ans;

	public static int solution(String[] want, int[] number, String[] discount) {
		Map<String, Integer> wantMap = new HashMap<>();
		ans = 0;

		for (int i = 0; i < number.length; i++) {
			wantMap.put(want[i], number[i]);
		}
		for (int i = 0; i <= discount.length - 10; i++) {
			go(new HashMap<>(wantMap), discount, i);
		}

		return ans;
	}

	private static void go(Map<String, Integer> wantMap, String[] discount, int startIdx) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = startIdx; i < startIdx + 10; i++) {
			map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
		}
		for (String discountKey : map.keySet()) {
			if (wantMap.containsKey(discountKey)) {
				wantMap.put(discountKey, wantMap.get(discountKey) - map.get(discountKey));
				if (wantMap.get(discountKey) <= 0) {
					wantMap.remove(discountKey);
				}
			}
		}
		if (wantMap.isEmpty()) {
			ans++;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[] {"banana", "apple", "rice", "pork", "pot"},
			new int[] {3, 2, 2, 2, 1},
			new String[] {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
				"pot", "banana", "apple", "banana"}));
		System.out.println(solution(new String[] {"apple"},
			new int[] {10},
			new String[] {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
				"banana"}));

	}
}
