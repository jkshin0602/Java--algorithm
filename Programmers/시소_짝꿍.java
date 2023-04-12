package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 시소_짝꿍 {

	//시소 중심으로 2,3,4 거리의 지점에 좌석이 있다.
	//시소를 두 명이 탈 때, 탑승한 사람의 무게와 시소 측과 좌석 간의 거리의 곱이 양쪽이 같다면 시소 짝꿍
	// 1:1, 2:1, 3:2, 4:3

	public static long solution(int[] weights) {
		long ans = 0;
		Map<Double, Integer> map = new HashMap<>();

		Arrays.sort(weights);

		for (int w : weights) {
			ans += getMate(w, map);
		}

		return ans;
	}

	private static long getMate(int w, Map<Double, Integer> map) {
		long count = 0;
		double d1 = w * 1.0;
		double d2 = (w * 2.0) / 3.0;
		double d3 = (w * 1.0) / 2.0;
		double d4 = (w * 3.0) / 4.0;
		
		if(map.containsKey(d1)) count += map.get(d1);
		if(map.containsKey(d2)) count += map.get(d2);
		if(map.containsKey(d3)) count += map.get(d3);
		if(map.containsKey(d4)) count += map.get(d4);

		map.put(d1, map.getOrDefault(d1, 0) + 1);
		
		return count;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {100, 180, 360, 100, 270}));
		System.out.println(solution(new int[] {100, 200, 300, 400}));
	}
}
