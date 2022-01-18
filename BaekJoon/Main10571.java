
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10571 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int T = Integer.parseInt(br.readLine()); 
		StringTokenizer st;
		
		//D[i] = D[i]를 마지막으로 하고, 중량이 높아지면서, 선명도 값이 낮아지는  부분수열 최장길이 
		//D[i] = max(D[j] + 1, D[i]) 
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine()); 
			float[] W = new float[N];
			float[] C = new float[N];
		
			int[] D = new int[N];
			
			for(int i=0; i<N; i++) {
				st= new StringTokenizer(br.readLine());
				W[i] = Float.parseFloat(st.nextToken());
				C[i] = Float.parseFloat(st.nextToken());
			}
			
			for(int i=0; i<N; i++) {
				D[i] = 1;
				for(int j=0; j<i; j++) {
					if(W[i] > W[j] && C[i] < C[j]&& D[i] < D[j]+1){
						//W[i] > W[j] = 앞의 수열의 무게가 더 낮아야 함 
						//C[i] < C[j] = 앞의 수열의 선명도가 더 높아야함 
						
						D[i] = D[j]+1;
					}
				}
			}
			
			int max = -1;
			for(int i=0; i<N; i++) {
				max = Math.max(max, D[i]);
			}
			
			System.out.println(max);

		}
		
		
		
	}
	
	
	
}
