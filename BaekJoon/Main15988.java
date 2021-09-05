import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main15988 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		final long mod = 1_000_000_009;
	
		int T = Integer.parseInt(br.readLine()); // 테스트케이스개수 T
		
		//점화식
		//D[i] = D[i-1] + D[i-2] + D[i-3]
		//D[0] = 1
		//D[1] = 1
		//D[2] = 2
		//D[3] = 4;
		long[] D = new long[1_000_001];
		
		D[0] = 1;
		D[1] = 1;
		D[2] = 2;	
		for(int i=3; i<=1_000_000; i++){
			D[i] = (D[i-1]+D[i-2]+D[i-3]) % mod;
		}

		for(int i=0; i<T; i++){
			int N = Integer.parseInt(br.readLine()); //정수 N			
			sb.append(D[N]).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
}
