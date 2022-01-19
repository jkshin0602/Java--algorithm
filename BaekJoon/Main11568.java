
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11568 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); 
		int[] card = new int[N];
		int[] D = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		//LIS(가장 긴 증가하는 부분 수열) 
		//D[i] = max(D[i], D[j]+1)
		
		int ans = -1;
		for(int i=0; i<N; i++) {
			D[i] = 1;
			for(int j=0; j<i; j++) {
				if(card[i] > card[j]) {
					D[i] = Math.max(D[i], D[j]+1);
				}
			}
			ans = Math.max(ans, D[i]);
		}

		
		System.out.println(ans);

		
		
		
	}
	
	
	
}
