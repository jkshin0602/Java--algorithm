package programmers;

public class 비밀지도 {

	//1. 지도는 한 변의 길이가 n인 정사각형 배열, ""과 "#" 두 종류로 이루어짐(공백, 벽)
	//2. 전체 지도는 두 장의 지도를 겹쳐서 얻음, 지도 1과 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서 벽이고, 지도1과 지도2에서 모두 공백인 부분은 전체 지도에서도 공백
	//3. 정수 배열
	//4. 암호화된 배열은 각 가로줄에서 벽부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		return int2DArrayToStringArray(sumMap(go(arr1), go(arr2)));
	}

	// int[][] -> String[]
	private static String[] int2DArrayToStringArray(int[][] map) {
		int len = map.length;
		String[] stringsMap = new String[len];
		for (int i = 0; i < len; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < len; j++) {
				if (map[i][j] == 1) {
					sb.append('#');
				} else {
					sb.append(' ');
				}
			}
			stringsMap[i] = sb.toString();
		}
		return stringsMap;
	}

	// int[][] + int[][] = int[][]
	private static int[][] sumMap(int[][] map1, int[][] map2) {
		int len = map1.length;
		int[][] map = new int[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (map1[i][j] == map2[i][j]) {
					map[i][j] = map1[i][j];
				} else {
					map[i][j] = 1;
				}
			}
		}
		return map;
	}

	// int[] -> int[][]
	private static int[][] go(int[] arr) {
		int len = arr.length;
		int[][] map = new int[len][len];
		for (int i = 0; i < len; i++) {
			String tmp = toBinary(arr[i], len);
			for (int j = 0; j < len; j++) {
				if (tmp.charAt(j) == '1') {
					map[i][j] = 1;
				}
			}
		}
		return map;
	}

	// 2진수 얻어내기, if 조건문은 자릿수에 맞게 숫자 맞춰주기
	private static String toBinary(int num, int len) {
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			sb.append(num % 2);
			num /= 2;
		}
		if (sb.length() != len) {
			do {
				sb.append('0');
			} while (sb.length() < len);
		}
		return sb.reverse().toString();
	}

}
