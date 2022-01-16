
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9711 {
	
	public static long[] D = new long[10001];
	
	public static void main(String[] args) throws IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		D[0] = 0;
		D[1] = 1;
		D[2] = 1;

		StringTokenizer st;
		int cnt = 0;
		while(T-- >0) {
			cnt++;
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());	
			
			if(P == 1 && Q == 1) {
				System.out.println("Case #"+cnt+": "+0);
				continue;
			}
			
			for(int i=2; i<=P; i++) {
				D[i] = (D[i-1] + D[i-2]) % Q;
			}

			System.out.println("Case #"+cnt+": "+D[P]);
		}
		
	}
	

	
}
