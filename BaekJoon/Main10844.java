import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main10844 {
	
	public static long[][] D; //메모이제이션
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //경우의 수 N 입력
		D = new long[N+1][10];
		System.out.println(stairs(N));
	}
	
	public static long stairs(int n){
		for(int i=1; i<=9; i++) D[1][i] = 1; //N이 1일때 1~9까지 한번씩 밖에 못들어감
		
		for(int i=2; i<=n; i++){
			for(int j=0; j<=9; j++){
				//점화식 : D[N][L] = 길이가 N인 계단수, 마지막으로 사용한 수 L
				//D[N][L] = D[N-1][L-1] + D[N-1][L+1]
				if(j == 0){ //이전 자릿수는 1만 가능
					D[i][0] = D[i-1][1] % 1_000_000_000;
				}else if(j == 9){ //이전 자리수는 8만 가능
					D[i][9] = D[i-1][8] % 1_000_000_000;
				}else{
					D[i][j] = (D[i-1][j-1] + D[i-1][j+1]) % 1_000_000_000;
				}
			}
		}
		long ans = 0;
		for(int i=0; i<=9; i++) {
			ans += D[n][i];
		}
		return ans % 1_000_000_000;
	}

}
