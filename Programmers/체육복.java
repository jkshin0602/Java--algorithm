package programmers;

import java.util.Arrays;

public class 체육복 {

	private static boolean[] lostCheck;
	private static boolean[] reserveCheck;

	public static int solution(int n, int[] lost, int[] reserve) {
		initBooleanArrays(lost, reserve);
		arraysSort(lost, reserve);
		return n - lostCheck.length + countSelf(lost, reserve) + countReserve(lost, reserve);
	}

	private static int countReserve(int[] lost, int[] reserve) {
		int answer = 0;
		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (canReserve(lost, reserve, i, j)) {
					checked(i, j);
					answer++;
					break;
				}
			}
		}
		return answer;
	}

	private static void initBooleanArrays(int[] lost, int[] reserve) {
		lostCheck = new boolean[lost.length];
		reserveCheck = new boolean[reserve.length];
	}

	private static void arraysSort(int[] lost, int[] reserve) {
		Arrays.sort(lost);
		Arrays.sort(reserve);
	}

	private static boolean canReserve(int[] lost, int[] reserve, int i, int j) {
		return !lostCheck[i] && !reserveCheck[j] && isSideNumber(lost[i], reserve[j]);
	}

	private static int countSelf(int[] lost, int[] reserve) {
		int self = 0;
		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] == reserve[j]) {
					checked(i, j);
					self++;
				}
			}
		}
		return self;
	}

	private static void checked(int i, int j) {
		lostCheck[i] = true;
		reserveCheck[j] = true;
	}

	private static boolean isSideNumber(int lost, int reserve) {
		return lost + 1 == reserve || lost - 1 == reserve;
	}

	public static void main(String[] args) {
		System.out.println(solution(5, new int[] {2, 4}, new int[] {1, 3, 5}));
		System.out.println(solution(5, new int[] {2, 4}, new int[] {3}));
		System.out.println(solution(3, new int[] {3}, new int[] {1}));
		System.out.println(solution(3, new int[] {1, 2, 3}, new int[] {1, 2, 3}));
	}
}
