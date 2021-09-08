import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main1932 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] D = new int[N+1][N+1];
		int[][] A = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = 1;
			while(st.hasMoreTokens()){
				A[i][n] = Integer.parseInt(st.nextToken());
				n++;
			}
		}
		
		//점화식 
		//D[i][j] = i행의 j번째가 선택되었을 때 최대 합
		//i,j 가 선택되었을 때 그전에 올 수 있는 경우의 수는 2가지이다.
		//D[i-1][j-1] , D[i-1][j] 이다.
		//이제 i,j까지 선택되었 을 때
		//D[i-1][j-1] + A[i][j], D[i-1][j] +A[i][j] 의 최대수를 구해주면 된다.
		//D[i][j] = max(D[i-1][j], D[i-1][j-1]) + A[i][j];
		
		for(int i=1; i<=N; i++){
			for(int j=1; j<=i; j++){
				D[i][j] = Math.max(D[i-1][j], D[i-1][j-1])+A[i][j];
			}
		}
			
		int ans = 0;
		for(int i=1; i<=N; i++){
			for(int j=1; j<=i; j++){
				if(ans < D[i][j]){
					ans = D[i][j];
				}
			}
		}
		System.out.println(ans);
		
		
	}
	
}
