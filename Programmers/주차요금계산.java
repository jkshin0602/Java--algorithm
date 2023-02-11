package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 주차요금계산 {

	//출차내역이 없다면 23:59에 출차된 것으로 간주
	//누적 주차 시간이 기본 시간이라면 기본 요금 청구
	//누적 주차 시간이 기본 시간을 초과하면, 기본 요금에 더해서 초과한 시간에 대해서 단위 시간마다 단위 요금 부여
	//초과한 시간이 단위 시간으로 나누어 떨어지지 않으면 올림

	public static int[] solution(int[] fees, String[] records) {
		Map<String, String> map = new HashMap<>();
		StringTokenizer st;
		Map<String, Integer> ans = new TreeMap<>(Comparator.comparingInt(Integer::parseInt));

		for (int i = 0; i < records.length; i++) {
			st = new StringTokenizer(records[i]);
			String time = st.nextToken();
			String carNumber = st.nextToken();
			String state = st.nextToken();

			if (state.equals("IN")) {
				map.put(carNumber, time);
				continue;
			}

			int min = getMin(time, map.get(carNumber));

			ans.put(carNumber, ans.getOrDefault(carNumber, 0) + min);
			map.remove(carNumber);
		}

		//출차하지 않은 차량은 11:59분에 출차했다고 설정
		if (!map.isEmpty()) {

			for (String carNumber : map.keySet()) {
				int min = getMin("23:59", map.get(carNumber));
				ans.put(carNumber, ans.getOrDefault(carNumber, 0) + min);
			}
		}

		return getAnswer(ans, fees);
	}

	/**
	 * 요금 계산
	 *
	 * @param ansMap : <차량번호, 주차 시간(분)>
	 * @return 차번호 오름차순 요금 int[] 배열
	 * @fees[0] 기본 시간
	 * @fees[1] 기본 요금
	 * @fees[2] 단위 시간
	 * @fees[3] 단위 요금
	 */
	private static int[] getAnswer(Map<String, Integer> ansMap, int[] fees) {
		List<Integer> ans = new ArrayList<>();

		for (String carNumber : ansMap.keySet()) {
			int min = ansMap.get(carNumber);
			int fee = 0;

			if (min <= fees[0]) { //기본 시간 이하라면 기본요금 부과
				fee += fees[1];
			} else { //기본 시간 이상이면 기본 요금 + 단위 시간 계산해 단위 요금 부과
				fee += (((int)Math.ceil(((double)min - fees[0]) / fees[2])) * fees[3]) + fees[1];
			}

			ans.add(fee);
		}
		return ans.stream()
			.mapToInt(Integer::intValue).toArray();
	}

	/**
	 * 시간 변환
	 *
	 * @param outTime : 출차 시간
	 * @param inTime  : 입차 시간
	 * @return 출차시간(o1) - 입차시간(o2) = 주차 사용 시간(분)
	 * @format "HH:MM"
	 */
	private static int getMin(String outTime, String inTime) {
		StringTokenizer st = new StringTokenizer(outTime, ":");
		int o1 = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
		st = new StringTokenizer(inTime, ":");
		int o2 = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

		return o1 - o2;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {180, 5000, 10, 600},
			new String[] {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
				"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
		System.out.println(Arrays.toString(solution(new int[] {120, 0, 60, 591},
			new String[] {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"})));
		System.out.println(Arrays.toString(solution(new int[] {1, 461, 1, 10}, new String[] {"00:00 1234 IN"})));
	}
}
