import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main9465 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 T
		int[][] D;
		int[][] A;
		int[] ans = new int[T];
		
		for(int t = 0; t<T; t++){
			int N = Integer.parseInt(br.readLine()); //가로의길이 입력 N 
			D = new int[N+1][3];
			A = new int[N+1][2];
			
			for(int i=0; i<2; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1;j<=N;j++){
					A[j][i] = Integer.parseInt(st.nextToken());
				}	
			}
			
			//점화식
			//D[i][j] = 2xi 에서 얻을 수 있는 최대 점수, i번 열에서 뜯는 스티커는 j
//			j = 0 → 뜯지않음
//			j = 1 → 위쪽 스티커를 뜯음
//			j = 2 → 아래쪽 스티커를 뜯음
			//스티커를 대각으로 뜯거나, 뜯으면 안된다. -> 경우의 수들
			
			for(int i=1; i<=N; i++){
				D[i][0] = Math.max(D[i-1][0], Math.max(D[i-1][1], D[i-1][2])); //i-1 열에서 스티커를 어떻게 뜯었는지 상관없다.
				D[i][1] = Math.max(D[i-1][0], D[i-1][2]) + A[i][0]; //i-1열에서 위쪽 스티커를 뜯으면 안된다.
				D[i][2] = Math.max(D[i-1][0], D[i-1][1]) + A[i][1]; //i-1열에서 아래쪽 스티커를 뜯으면 안된다.
			}
			ans[t] = Math.max(D[N][0], Math.max(D[N][1], D[N][2]));
			
		}
		for(int i=0; i<ans.length; i++){
			System.out.println(ans[i]);
		}
		
	}

}
