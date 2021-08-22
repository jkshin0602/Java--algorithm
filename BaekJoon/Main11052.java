import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main11052 {
	
	public static int[] d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //카드개수 N개
		int[] P = new int[N+1]; //가격 
		d = new int[N+1]; //메모리제이션 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++){
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		//점화식 : D[N] = max(D[N], D[N-i]+P[i])
		for(int i=1; i<=N; i++){
			for(int j=1; j<=i; j++){
				d[i] = Math.max(d[i], d[i-j] + P[j]);
			}
		}
		System.out.println(d[N]);
	}

}
