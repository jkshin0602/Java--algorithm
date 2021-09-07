import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main11057 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //수의 길이 N
		long[][] D = new long[N+1][10];
		final int MOD = 10_007;
		
		for(int i=0; i<10; i++){
			D[1][i] = 1; //수의 길이가 1이면 모두 오르막수이다.
		}
		//점화식
		//D[i][j] = 길이가 i이고 마지막 숫자가 j인 오르막 수의 개수
		//D[i][j] += D[i-1][k](0<= k <= j)
		
		for(int i=2; i<=N; i++){ 
			for(int j=0; j<10; j++){ //j의 범위 마지막 숫자는 0부터 9까지 가능
				for(int k=0; k<=j; k++){ //k의 범위 (0<= k <= j)
					D[i][j] += D[i-1][k]; //모든 경우의 수를 더해준다.
					D[i][j] %= MOD;
				}
			}
		}
		long ans = 0;
		for(int i=0; i<10; i++){
			ans += D[N][i];
		}
		ans %= MOD;
		System.out.println(ans);
		
		
		
	}

}
