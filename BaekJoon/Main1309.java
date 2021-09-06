import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main1309 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //세로의 길이 : N
		int[][] D = new int[N+1][3];
		final int mod = 9901;
		
		//점화식
//		D[N][0] = N번 줄에 배치하지 않음
//		D[N][1] = N번 줄의 왼쪽에만 배치
//		D[N][2] = N번 줄의 오른쪽에만 배치
		//점화식
//		D[N][0] = D[N-1][0] + D[N-1][1] + D[N-1][2]
//		D[N][1] = D[N-1][0] + D[N-1][2] 
//		D[N][2] = D[N-1][0] + D[N-1][1]
		
		D[1][0] = 1;
		D[1][1] = 1;
		D[1][2] = 1; 
		
		for(int i=2; i<=N; i++){
			D[i][0] = (D[i-1][0] + D[i-1][1] + D[i-1][2])%mod; //3
			D[i][1] = (D[i-1][0] + D[i-1][2])%mod; //2
			D[i][2] = (D[i-1][0] + D[i-1][1])%mod; //2 
		}
		System.out.println((D[N][0] + D[N][1] + D[N][2])%mod);
		
	}

}
