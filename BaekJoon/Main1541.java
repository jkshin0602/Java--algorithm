package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1541 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int ans = 0;
		List<String> l = new ArrayList<>();

		if (s.contains("-")) {
			StringTokenizer st = new StringTokenizer(s, "-");
			while (st.hasMoreTokens()) {
				String s1 = st.nextToken();
				if (s1.contains("+")) {
					StringTokenizer st1 = new StringTokenizer(s1, "+");
					int tmp = 0;
					while (st1.hasMoreTokens()) {
						tmp += Integer.parseInt(st1.nextToken());
					}
					l.add(tmp + "");
					continue;
				}
				l.add(s1);
			}
			for (int i = 0; i < l.size(); i++) {
				if (i == 0) {
					ans = Integer.parseInt(l.get(i));
					continue;
				}
				ans -= Integer.parseInt(l.get(i));
			}
		} else {
			StringTokenizer st = new StringTokenizer(s, "+");
			while (st.hasMoreTokens()) {
				ans += Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(ans);

	}

}
