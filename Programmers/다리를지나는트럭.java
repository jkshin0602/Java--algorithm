package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

	// 다리 위에 최대 bridge_length 만큼 트럭 올리기 가능
	// 다리는 weight 이하의 무게 까지 가능
	// 트럭이 통과하는 시간은 bridge_length

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		Queue<Integer> bridge = new LinkedList<>();
		int sum = 0;
		int time = 0;
		for (int i = 0; i < truck_weights.length; i++) {
			while (true) {
				int truck_weight = truck_weights[i];

				//1. 다리에 아무것도 없는 경우
				if (bridge.isEmpty()) {
					bridge.add(truck_weight);
					sum += truck_weight;
					time++;
					break;
				} //2. 다리의 길이에 꽉찬경우
				else if (bridge.size() == bridge_length) {
					sum -= bridge.poll();
					continue;
				}
				// 3. 다리의 길이만큼 차지 않은 경우
				if (sum + truck_weight <= weight) { // 3-1. 트럭이 더 올라갈 수 있는 경우
					bridge.add(truck_weight);
					sum += truck_weight;
					time++;
					break;
				}
				//3-2. 트럭이 못올라가는 경우 0을 넣어 트럭을 건너게 함(큐의 길이 증가)
				bridge.add(0);
				time++;
			}
		}
		//4. 마지막에 건너는 트럭 시간 추가
		return time + bridge_length;
	}

	public static void main(String[] args) {
		System.out.println(solution(2, 10, new int[] {7, 4, 5, 6}));
		System.out.println(solution(100, 100, new int[] {10}));
		System.out.println(solution(100, 100, new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
	}
}
