package Cho.week_4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2559_1 {

	static int N;
	static int K;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //온도를 측정한 전체 날짜 수 N
		K = Integer.parseInt(st.nextToken()); //합을 구하기 위한 연속적인 날짜의 수 K
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
	
		int sum = 0;

		for(int i=0; i<K; i++) {
			sum += arr[i];
		}
		
		int max = sum;
		
		for(int i=1; i<=N-K; i++) { 
			sum -= arr[i-1];
			sum += arr[i+K-1];
			max = Math.max(sum, max);
			
		}
		System.out.println(max);
	

	}
	
	
	
	

}
