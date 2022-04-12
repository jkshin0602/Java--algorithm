package programmers;

public class TakeAGroupPhoto {

	public static int answer = 0;
	public static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

	public static int solution(int n, String[] data) {
		boolean[] isVisited = new boolean[8];
		dfs("", isVisited, data);
		return answer;
	}

	private static void dfs(String names, boolean[] isVisited, String[] data) {
		if (names.length() == 7) {
			if (check(names, data)) {
				answer++;
			}
			return;
		}
		for (int i = 0; i < 8; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				String name = names + friends[i];
				dfs(name, isVisited, data);
				isVisited[i] = false;
			}
		}
	}

	private static boolean check(String names, String[] datas) {
		for (String data : datas) {
			int pos1 = names.indexOf(data.charAt(0)); //조건제시한 프렌즈 위치1
			int pos2 = names.indexOf(data.charAt(2)); //상대 프렌즈 위치2
			char op = data.charAt(3); //수식
			int index = data.charAt(4) - '0'; //거리
			if (op == '=') {
				if (!(Math.abs(pos1 - pos2) == index + 1)) {
					return false;
				}
			} else if (op == '>') {
				if (!(Math.abs(pos1 - pos2) > index + 1)) {
					return false;
				}
			} else if (op == '<') {
				if (!(Math.abs(pos1 - pos2) < index + 1)) {
					return false;
				}
			}
		}
		return true;
	}

}
