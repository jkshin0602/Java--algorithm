package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 실패율 {

	public static int[] solution(int N, int[] stages) {
		HashMap<Integer, Double> map = getMap(N, stages);
		List<Integer> list = new ArrayList<>(map.keySet());

		sortByValue(map, list);

		return listToIntArray(list);
	}

	private static int[] listToIntArray(List<Integer> list) {
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	private static void sortByValue(HashMap<Integer, Double> map, List<Integer> list) {
		list.sort((o1, o2) -> {
			if (map.get(o2) - map.get(o1) == 0) {
				return o1 - o2;
			}
			if (map.get(o2) - map.get(o1) > 0) {
				return 1;
			} else if (map.get(o2) - map.get(o1) < 0) {
				return -1;
			}
			return 0;
		});
	}

	private static HashMap<Integer, Double> getMap(int N, int[] stages) {
		HashMap<Integer, Double> map = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			int nonClear = 0;
			int player = 0;
			for (int stage : stages) {
				if (stage >= i) {
					player++;
					if (stage == i) {
						nonClear++;
					}
				}
			}
			if (player == 0) {
				map.put(i, 0.0);
				continue;
			}
			double fail = (double)nonClear / player;

			map.put(i, fail);
		}
		return map;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3})));
		System.out.println(Arrays.toString(solution(4, new int[] {4, 4, 4, 4, 4})));
	}
}
