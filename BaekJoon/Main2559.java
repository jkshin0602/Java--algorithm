import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2559 {

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
		
	
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<=N-K; i++) { 
			int sum = 0;
			for(int j=i; j<i+K; j++) { //arr[i]~arr[i+K] 까지의 합을 구한다 
				sum += arr[j];
			}
			max = Math.max(max, sum); //max와 sum을 비교 
		}
		System.out.println(max);
	

	}
	
	
	
	

}
