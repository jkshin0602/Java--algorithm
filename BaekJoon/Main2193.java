import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main2193 {
	
	public static long[][] D; 
	public static long[] DP;
	public static long[] memo;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //N자리 수 입력
		D = new long[N+1][2];
		DP = new long[N+1];
		memo = new long[N+1];
		
		System.out.println(pinary(N));
	
	}
	
	// 2차원 다이나믹 배열 
	public static long pinary(int n){
		//점화식
		//D[N][0] = D[N-1][0] + D[N-1][1]
		//D[N][1] = D[N-1][0]
		D[1][0] = 0;
		D[1][1] = 1;
		for(int i=2; i<=n; i++){
			D[i][0]= D[i-1][0] + D[i-1][1];			
			D[i][1]= D[i-1][0];
		}
		
		return D[n][0] + D[n][1];
	}
	
	//1차원 다이나믹 배열
	public static long pinary1(int n){
		//점화식
		//D[N] = D[N-1][N-2]
		if(n < 3) {
			DP[n]=1;
		}
		
		for(int i=3; i<=n; i++){
			DP[i] = DP[i-1] + DP[i-2];
		}
		
		return DP[n];
	}
	
	//피보나치 수열로 풀기
	public static long pinary2(int n){
		if(n < 3){
			return 1;
		}
		if(memo[n] > 0) return memo[n];
		memo[n] = pinary2(n-1) + pinary2(n-2);
		return memo[n];
		
	}
	
}
