package book.nadongbin.문제.정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 실패율 {
	//실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어의 수

	public static int[] solution(int N, int[] stages) {
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

		List<Integer> list = new ArrayList<>(map.keySet());

		list.sort((o1, o2) -> {
			if (map.get(o2) - map.get(o1) == 0.0) {
				return o1 - o2;
			}
			return Double.compare(map.get(o2), map.get(o1));
		});

		int[] result = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3})));
		System.out.println(Arrays.toString(solution(4, new int[] {4, 4, 4, 4, 4})));
	}
}
