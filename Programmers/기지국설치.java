package programmers;

public class 기지국설치 {

	public static int solution(int n, int[] stations, int w) {
		int spreadRange = 2 * w + 1; // 전파 최대 범위
		int answer = 0;
		int idx = 1; // 탐색 시작 idx

		for (int station : stations) {
			if (idx < station - w) {// 설치되어있는 기지국 전파범위보다 idx가 작을 경우
				int start = station - w; // 전파범위 시작점
				answer += getCount(start - idx, spreadRange);
			}
			idx = station + w + 1; // 설치되어 있는 기지국 전파범위 +1 idx 갱신
		}

		// 설치된 기지국이 n의 길이보다 작으면 탐색된 idx 이후 추가 탐색 진행
		if (stations[stations.length - 1] + w + 1 <= n) {
			idx = stations[stations.length - 1] + w + 1;
			int start = n + 1;
			answer += getCount(start - idx, spreadRange);
		}

		return answer;
	}

	private static int getCount(int length, int spreadRange) {
		int count = length / spreadRange; // 전파가 안닫는 길이 / 전파 범위
		return length % spreadRange == 0 ? count : count+1; // count 나머지가 존재하면 기지국 1대 추가 설치
	}

	public static void main(String[] args) {
		System.out.println(solution(11, new int[] {4, 11}, 1));
		System.out.println(solution(16, new int[] {9}, 2));
	}
}
