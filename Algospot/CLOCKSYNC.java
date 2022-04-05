package algospot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CLOCKSYNC {

	public static final int INF = 9999;
	public static int[] clock = new int[16];
	public static ArrayList<Integer[]> clockSwitch = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		init();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		while (C-- > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 16; i++) {
				clock[i] = Integer.parseInt(st.nextToken());
			}
			int ans = function(0);
			if (ans >= 9999) {
				ans = -1;
			}
			System.out.println(ans);
		}
		System.out.println();
	}

	private static void init() {
		Arrays.asList(new Integer[] {0, 1, 2}, new Integer[] {3, 7, 9, 11},
				new Integer[] {4, 10, 14, 15}, new Integer[] {0, 4, 5, 6, 7}, new Integer[] {6, 7, 8, 10, 12},
				new Integer[] {0, 2, 14, 15}, new Integer[] {3, 14, 15}, new Integer[] {4, 5, 7, 14, 15},
				new Integer[] {1, 2, 3, 4, 5}, new Integer[] {3, 4, 5, 9, 13})
			.forEach(integers -> clockSwitch.add(integers));
	}

	private static int function(int btn) {
		if(btn == 10){
			return checkClock() ? 0 : INF;
		}

		int cnt = INF;
		/*
		* 시계를 4번 누르면 다시 원상태로 복구
		* 그에 따라 다시 3시간전으로 돌리는 함수 불필요
		* 그래서 4번까지 탐색
		* 4 ^ (스위치갯수) 10 = 4^10
		* 10중 for 문으로 탐색 가능
		* */
		for (int i = 0; i < 4; i++) {
			cnt = Math.min(cnt, i + function(btn + 1)); // i= 몇번 눌렀는지 + function() 다 눌리면 0 반환
			button(findClocks(btn));
		}

		return cnt;
	}

	private static boolean checkClock() {
		for (int i = 0; i < 16; i++) {
			if(clock[i] !=12)
				return false;
		}
		return true;
	}

	private static void button(Integer[] moveClocks) {
		for (Integer moveClock : moveClocks) {
			clock[moveClock] += 3;
			if (clock[moveClock] == 15) {
				clock[moveClock] = 3;
			}
		}
	}

	private static Integer[] findClocks(int switchNum) {
		return clockSwitch.get(switchNum);
	}

}
