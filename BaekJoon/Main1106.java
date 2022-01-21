
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1106 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken()); //호텔 고객 C명을 늘림 , C <= 1000
		int N = Integer.parseInt(st.nextToken()); //도시의 개수 N, N<=20 
		
		//3원에 5명 
		//D[i] = i명의 고객을 늘릴 때 필요한 최소한의 비용
		//D[12] = min(D[12], D[12-5]+3, D[12-4]+3, ..., D[12-1]+3)

		int[] D = new int[C+101]; // 고객 수 + 최대고객수 
		// C = 최소인원 -> 이 이상으로 탐색 
		D[0] = 0;
		for(int i=1; i<C+101; i++) 
			D[i] = 999999;
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int fee = Integer.parseInt(st.nextToken()); // <= 100
			int customer = Integer.parseInt(st.nextToken()); // <= 100
			
			for(int j=customer; j<C+101; j++) 
				D[j] = Math.min(D[j], D[j-customer]+fee);	
		}
		
		int ans = 999999;
		for(int i=C; i<C+101; i++){
			ans = Math.min(ans, D[i]);
		}
		System.out.println(ans);
	
		
		
		
		

		
		
		
	}
	
	
	
}
