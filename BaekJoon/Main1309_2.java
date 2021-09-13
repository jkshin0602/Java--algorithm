
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main1309_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //세로의 길이 : N
		int[] D = new int[N+1];
		int[] S = new int[N+1];
		final int mod = 9901;
		
		//점화식
		//S[i] = D[1] + D[2] + ... + D[i]
		//D[i] = D[i-1] + 2(D[i-2] + ... + D[1] + D[0])
		//D[i] = D[i-1] + 2 x S[i-2] 
		
		D[0] = 1; 
		S[0] = 1;
		D[1] = 2;
		S[1] = D[0] + D[1];
 		for(int i=2; i<=N; i++){
			D[i] = D[i-1] + 2 * S[i-2];
			S[i] = S[i-1] + D[i];
			D[i] = D[i] % 9901;
			S[i] = S[i] % 9901;
		}
		System.out.println(S[N]);
		
	}

}
