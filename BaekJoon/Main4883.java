
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4883 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) {
				break;
			}
			tc++;
			int[][] D = new int[100000][3];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<3; j++) {
					D[i][j] = Integer.parseInt(st.nextToken());
				}				
			}
			
			// D[i][1] = (i,1) 정점까지 도착하는 최소비용 
			// D[i][1] = min(D[i-1][0], D[i-1][1], D[i-1][2])
			D[0][0] = 1001;
			D[0][2] += D[0][1];
			
			
			for(int i=1; i<100000; i++) {
				if(i == N) break;
				for(int j=0; j<3; j++) {
					if(j == 0) {
						D[i][j] += Math.min(D[i-1][0], D[i-1][1]);					
					}else if(j == 1) {
						D[i][j] += Math.min(D[i-1][0], Math.min( D[i-1][1], Math.min( D[i-1][2],D[i][0])));
					}else if(j ==2) {
						D[i][j] += Math.min(D[i-1][1], Math.min(D[i-1][2], D[i][1]));
					}
				}
				
			}
			
			System.out.println(tc+". "+D[N-1][1]);
		}
		
		
	}
	
	
	
}
