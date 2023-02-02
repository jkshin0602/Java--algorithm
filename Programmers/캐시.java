package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 캐시 {

	//캐시 교체 알고리즘 LRU(Least Recently Used)
	//가장 오랫동안 참조되지 않은 페이지를 교체하는 방법
	//cache hit = 실행시간 1
	//cache miss = 실행시간 5
	//영문자로만 구성, 대소문자 구분 x

	public static int solution(int cacheSize, String[] cities) {
		Queue<String> caches = new LinkedList<>();
		int time = 0;

		if (cacheSize == 0) {
			return cities.length * 5;
		}

		for (String city : cities) {
			String cityLowerCase = city.toLowerCase();
			if (caches.contains(cityLowerCase)) { // 이미 존재하면
				caches.remove(cityLowerCase); // 최신화
				caches.offer(cityLowerCase);
				time++;
			} else {// 캐시 미스라면
				if (caches.size() < cacheSize) { // 여유 공간이 있다면
					caches.offer(cityLowerCase);
				} else { // 여유 공간이 없다면, 가장 먼저 참조된 페이지 삭제
					caches.poll();
					caches.offer(cityLowerCase);
				}
				time += 5;
			}
		}

		return time;
	}

	public static void main(String[] args) {
		System.out.println(solution(3,
			new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
		System.out.println(solution(3,
			new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
		System.out.println(solution(2,
			new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju",
				"NewYork", "Rome"}));
		System.out.println(solution(5,
			new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju",
				"NewYork", "Rome"}));
		System.out.println(solution(2, new String[] {"Jeju", "Pangyo", "NewYork", "newyork"}));
		System.out.println(solution(0, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
		System.out.println(solution(3, new String[] {"a","b","a"}));
		System.out.println(solution(10, new String[] {"1","2","3","2"}));
		System.out.println(solution(0, new String[] {"a", "b", "a", "a", "a"}));

	}
}
