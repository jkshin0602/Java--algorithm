import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main2225 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int mod = 1_000_000_000;
		int N = Integer.parseInt(st.nextToken()); // 0~N까지의 정수 K를 더해서 그 합이 N이 되는 경우의 수
		int K = Integer.parseInt(st.nextToken()); 
		long[][] D = new long[K+1][N+1];
		
		//점화식
		//D[K][N] = ∑ D[K-1][N-L]
		
		D[0][0] = 1L;
		for(int i=1; i<=K; i++){ 
			for(int j=0; j<=N; j++){ 
				for(int l=0; l<=j; l++){ // L은 J를 넘을 수 없다. 0 <= L <= N
					D[i][j] += D[i-1][j-l];
					D[i][j] %= mod;
				}
			}
		}
		System.out.println(D[K][N]);
		
	}

}
 