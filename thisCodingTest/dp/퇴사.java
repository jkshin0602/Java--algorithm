package book.nadongbin.문제.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {

	//1<=T<=5
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[15];
		int[] P = new int[15];
		int[] D = new int[16];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		//D[i] = i번째 날부터 마지막날까지 낼 수 있는 최대 이익
		//D[i] = max(P[i] + d[T[i] + i], max)

		int maxValue = 0;
		for (int i = N - 1; i >= 0; i--) {
			int time = T[i] + i;
			if (time <= N) { //상담이 기간 안에 끝나는 경우
				D[i] = Math.max(P[i] + D[time], maxValue);
				maxValue = D[i];
			} else {
				//상담이 기간을 벗어나는 경우
				D[i] = maxValue;
			}
		}

		System.out.println(maxValue);
	}
}
