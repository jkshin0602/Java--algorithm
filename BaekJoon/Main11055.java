import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main11055 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //수열의 길이 N
		int[] A = new int[N]; //수열 
		int[] D = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<N; i++){
			A[i] = Integer.parseInt(st.nextToken());
		}

		//점화식
		//D[i] = max(D[i], D[j]+A[i])
		//LIS에서는 D[j]+1 , 즉 길이를 비교하지만 여기서는 D[j] = 현재까지의 합 , 마지막 수 A[i]를 더해주어서
		//최대값을 구한다.
		//j는 i보다 앞에있으므로 j < i 
		//또한 수열이 성립되어야 하므로 D[j] < D[i]
		for(int i=0; i<N; i++){
			D[i] = A[i];
			for(int j=0; j<i; j++){
				if(D[j] < D[i] && D[i] < D[j] + A[i]){
					D[i] = D[j] + A[i];
				}
 			}
		}
		
		int ans = 0;
		for(int i=0; i<N; i++){
			if(ans < D[i]){
				ans = D[i];
			}
		}
		System.out.println(ans);
		
		
		
	}

}
