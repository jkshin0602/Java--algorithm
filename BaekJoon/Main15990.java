
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main15990 {
	
	public static long[][] D; //메모리 제이션
	public static final int mod = 1_000_000_009;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T =	Integer.parseInt(br.readLine()); //테스트 케이스 개수
		D = new long[100_001][4];

		
		for(int i=0; i<T; i++){
			int n = Integer.parseInt(br.readLine());
			sb.append(add(n)).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}

	//Bottom-up 방식
	public static int add(int n){
		D[1][1] = 1; //1
		D[2][2] = 1; //2
		D[3][1] = 1; //2+1
		D[3][2] = 1; //1+2
		D[3][3] = 1; //3
		
		for(int i=4; i<= n; i++){
//		점화식
//		D[i][1] = (D[i-1][2] + D[i-1][3]) % mod
//		D[i][2] = (D[i-2][1] + D[i-2][3]) % mod
//		D[i][3] = (D[i-3][1] + D[i-3][2]) % mod
			D[i][1] = (D[i-1][2] + D[i-1][3]) % mod;
			D[i][2] = (D[i-2][1] + D[i-2][3]) % mod;
			D[i][3] = (D[i-3][1] + D[i-3][2]) % mod;
		}
		
		return (int) ((D[n][1] + D[n][2] + D[n][3]) % mod);
	}

}
