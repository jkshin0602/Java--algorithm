package programmers;

public class TwoThousandSixteen년 {

	private static int[] dayOfMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

	public static void main(String[] args) {
		System.out.println(solution(5, 24));
	}

	public static String solution(int a, int b) {
		int currentDay = 5;
		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= 31; j++) {
				if (i == a && j == b) {
					break;
				}
				if (isCheck(i, j)) {
					currentDay++;
					if (currentDay == 7) {
						currentDay = 0;
					}
				}

			}
		}

		return day[currentDay];
	}

	private static boolean isCheck(int month, int day) {
		return dayOfMonth[month] >= day;
	}
}
