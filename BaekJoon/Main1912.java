import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main1912 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //수열 갯수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N]; //수열
		int[] D = new int[N]; //최대길이 수열
		
		for(int i=0; i<N; i++){
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		//점화식 
		//D[i] = max(D[i-1] + A[i] , D[i]) 
		
		for(int i=0; i<N; i++){
			D[i] = A[i]; //연속하지 않은 경우
			if(i == 0 ) continue;
			if(D[i] < D[i-1] + A[i]){ //연속하는 경우
				D[i] = D[i-1] + A[i];
			}
		}
		
		int ans = A[0];
		for(int i=0; i<N; i++){
			if(ans < D[i]){
				ans = D[i];
			}
		}
		System.out.println(ans);
		
	}

}
