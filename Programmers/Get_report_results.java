package programmers;

import java.util.*;

public class Get_report_results {
	public int[] solution(String[] id_list, String[] report, int k) {

		int user_len = id_list.length; // id 개수
		int report_len = report.length; // 처리해야할 신고 수
		StringTokenizer st;
		boolean[][] check = new boolean[user_len][user_len]; // check 2차원배열

		for (int i = 0; i < report_len; i++) {
			st = new StringTokenizer(report[i]);
			int sinGoza = find_user(id_list, st.nextToken()); // 신고자 idx
			int sinGoDang = find_user(id_list, st.nextToken()); // 신고당한사람 idx
			check[sinGoza][sinGoDang] = true; // 1번만 신고되므로 boolean으로 체크
		}

		int[] singo_cnt = new int[user_len];
		int[] answer = new int[user_len];

		// 신고당한 횟수를 세줌
		for (int i = 0; i < user_len; i++) {
			for (int j = 0; j < user_len; j++) {
				if (check[i][j])
					singo_cnt[j]++;
			}
		}

		// 정지 기준 k를 넘긴 유저를 신고한 사람에게 결과를 알려줘야함
		for (int i = 0; i < user_len; i++) {
			if (singo_cnt[i] >= k) {
				for (int j = 0; j < user_len; j++) {
					if (check[j][i]) {
						answer[j]++;
					}
				}
			}
		}

		return answer;
	}

	// user의 idx값을 반환하는 함수
	public static int find_user(String[] id_list, String username) {
		for (int i = 0; i < id_list.length; i++) {
			if (id_list[i].equals(username))
				return i;
		}
		return -1;
	}

}
