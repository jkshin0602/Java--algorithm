
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2559_2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 날짜의 수  N
		int K = Integer.parseInt(st.nextToken()); // 합을구하기위한 연속적인 날짜의 수 K
		
		int[] t = new int[N+1]; 
		st = new StringTokenizer(br.readLine());

		int[] sums = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			t[i] = Integer.parseInt(st.nextToken());
			sums[i] = sums[i-1] + t[i];
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i=K; i<=N; i++) {
			//sums[i] - sums[i-K] = (i-K) ~ i 까지의 합 
			max = Math.max(max, sums[i] - sums[i-K]);
		}
		

		System.out.println(max);
		
		
	}
	
}
