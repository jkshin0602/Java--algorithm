import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2798 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 카드의 갯수
		int M = Integer.parseInt(st.nextToken()); // M 최대값
		int[] card = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int k = j+1; k < N; k++) {
					int sum = card[i] + card[j] + card[k];
					if(sum <= M)
						max = Math.max(max, sum);
				}
			}
		}
		System.out.println(max);
		//O(N^3)
		// 재귀함수 이용 가능
	}


}
