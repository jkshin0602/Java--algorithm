import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main1149 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //집의 수 N 
		int[][] D = new int[N][3];
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++){
				D[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//점화식
		// j = 0 : 빨강
		// j = 1 : 초록
		// j = 2 : 파랑
		//D[i][0] = min(D[i-1][1], D[i-1][2]) + A[i][0]
		//D[i][1] = min(D[i-1][0], D[i-1][2]) + A[i][1]
		//D[i][2] = min(D[i-1][0], D[i-1][1]) + A[i][2]
		// A[i][j] = 사용자 입력값
		//모든 경우의 수를 찾아서 최종적으로 작은 누적합을 찾아야한다.
		
		for(int i=1; i<N; i++){
			D[i][0] += Math.min(D[i-1][1], D[i-1][2]);
			D[i][1] += Math.min(D[i-1][0], D[i-1][2]);
			D[i][2] += Math.min(D[i-1][0], D[i-1][1]);
			
		}
		System.out.println(Math.min(Math.min(D[N-1][0],D[N-1][1]),D[N-1][2]));
		
	}
}
