package book.nadongbin.그래프이론;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 팀_결성 {

	public static String[] solution(int N, String[] info) {
		List<String> ans = new ArrayList<>();
		int[] parent = new int[N+1];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		for (String s : info) {
			StringTokenizer st = new StringTokenizer(s);
			int oper = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			//union
			if (oper == 0) {
				unionParent(parent, a, b);
			} else {
				if (findParent(parent, a) == findParent(parent, b)) {
					ans.add("YES");
				} else {
					ans.add("NO");
				}
			}
		}

		return ans.toArray(new String[0]);
	}

	private static void unionParent(int[] parent, int a, int b) {
		a = findParent(parent, a);
		b = findParent(parent, b);

		if (a < b) {
			parent[b] = a;
			return;
		}
		parent[a] = b;
	}

	private static int findParent(int[] parent, int x) {
		if (parent[x] != x) {
			parent[x] = findParent(parent, parent[x]);
		}

		return parent[x];
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(7, new String[] {
			"0 1 3", "1 1 7", "0 7 6", "1 7 1", "0 3 7", "0 4 2", "0 1 1", "1 1 1"
		})));
	}
}
