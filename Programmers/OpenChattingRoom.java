package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
	public String[] solution(String[] record) {
		StringTokenizer st;
		Map<String, String> user = new HashMap<>();
		int cnt = 0;
		for (String s : record) {
			st = new StringTokenizer(s);
			String state = st.nextToken();
			String uid = st.nextToken();
			String name = null;
			if (!state.equals("Leave")) {
				name = st.nextToken();
			}
			if (state.equals("Enter")) {
				cnt++;
				if (!user.containsKey(uid)) {
				} else {
					user.remove(uid);
				}
				user.put(uid, name);
			} else if (state.equals("Change")) {
				user.put(uid, name);
			} else if (state.equals("Leave")) {
				cnt++;
			}
		}
		String[] answer = new String[cnt];
		int i = 0;
		for (String s : record) {
			st = new StringTokenizer(s);
			String state = st.nextToken();
			String uid = st.nextToken();
			if (state.equals("Enter")) {
				String name = user.get(uid);
				answer[i++] = name + "님이 들어왔습니다.";
			} else if (state.equals("Leave")) {
				String name = user.get(uid);
				answer[i++] = name + "님이 나갔습니다.";
			} else {
				continue;
			}

		}
		return answer;
	}

}