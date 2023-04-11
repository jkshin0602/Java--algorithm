package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 우박수열_정적분 {

	//콜라츠 추측
	//모든 자연수에 n에 대해 다음 작업을 반복하면 항상 1로 만들 수 있는 추측
	//1-1. 입력된 수가 짝수면 2로 나눔
	//1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더함
	//2. 결과로 나온 수가 1보다 크다면 1번 작업을 반복

	public static double[] solution(int k, int[][] ranges) {
		List<Integer> graph = new ArrayList<>();

		List<Double> area = new ArrayList<>();
		double[] answer = new double[ranges.length];

		area.add(0.0);

		getCollatz(k, graph);
		getArea(graph, area);
		getCumulativeSum(area);

		for (int i = 0; i < ranges.length; i++) {
			int s = ranges[i][0];
			int e = graph.size() - 1 + ranges[i][1];

			if (e > s) {
				answer[i] = Double.parseDouble(String.format("%.1f", area.get(e) - area.get(s)));
			} else if (s > e) {
				answer[i] = -1.0;
			}
		}

		return answer;
	}

	private static void getCumulativeSum(List<Double> area) {
		for (int i = 1; i < area.size(); i++) {
			area.set(i, area.get(i - 1) + area.get(i));
		}
	}

	private static void getArea(List<Integer> graph, List<Double> area) {
		for (int i = 0; i < graph.size() - 1; i++) {
			int max = Math.max(graph.get(i + 1), graph.get(i));
			double answer = max - ((double)(Math.abs(graph.get(i + 1) - graph.get(i))) / 2);
			area.add(answer);
		}
	}

	private static void getCollatz(int k, List<Integer> graph) {
		graph.add(k);
		if (k == 1) {
			return;
		}
		int ans = k % 2 == 0 ? k / 2 : k * 3 + 1;

		getCollatz(ans, graph);
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[][] {{0, 0}, {0, -1}, {2, -3}, {3, -3}})));
		System.out.println(Arrays.toString(solution(10_000, new int[][] {{0, 0}, {0, -1}, {2, -3}, {3, -3}})));
	}
}
