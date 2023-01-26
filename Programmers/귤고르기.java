package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 귤고르기 {

	//1 <= k <= tangerine <= 100,000
	//1 <= tangerine[i] <= 10,000,000

	//수확한 귤 중 k개를 골라 상자 하나 담아에 판매
	//수확한 귤의 크기가 일정하지 않다
	//귤을 크기별로 분류했을 때 서로 다른 종류의 수를 최소화

	public static int solution(int k, int[] tangerine) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int t : tangerine) {
			map.put(t, map.getOrDefault(t, 0) + 1);
		}

		int sum = 0;
		int ans = 0;
		List<Integer> list = new ArrayList<>();
		for (Integer x : map.keySet()) {
			list.add(map.get(x));
		}
		list.sort(Collections.reverseOrder());

		for (Integer x : list) {
			ans++;
			sum += x;
			if (sum >= k) {
				break;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(solution(6, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
		System.out.println(solution(4, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
		System.out.println(solution(2, new int[] {1, 1, 1, 1, 2, 2, 2, 3}));
	}
}
