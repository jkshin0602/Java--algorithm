package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main2864 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();

		A = A.replaceAll("6", "5");
		B = B.replaceAll("6", "5");

		int min = Integer.parseInt(A) + Integer.parseInt(B);

		A = A.replaceAll("5", "6");
		B = B.replaceAll("5", "6");
		int max = Integer.parseInt(A) + Integer.parseInt(B);

		System.out.println(min + " " + max);

	}
}
