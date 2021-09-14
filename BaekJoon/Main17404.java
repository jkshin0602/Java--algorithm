import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main17404 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //집의 수 N 
		int[][] D = new int[N+1][3];
		int[][] A = new int[N+1][3];
		for(int i=1; i<=N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++){
				A[i][j] = Integer.parseInt(st.nextToken());
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
		//원형으로 생각하므로, 첫번쨰 집을 고정시킬 코드를 추가한다.
		
		int ans = 1000 * 1000 + 1;
		
		for(int k=0; k<=2; k++){ //첫집 색깔 고정
			for(int j=0; j<=2; j++){ //1번집의 색 결정을 미리 함
				if(j == k){ //0,1,2에 한개씩 넣어준다. 
					D[1][j] = A[1][j];
				}else{ 
					D[1][j] = 1000 * 1000 + 1;
				}
			}
			
			for(int i=2; i<=N; i++){
				D[i][0] = Math.min(D[i-1][1], D[i-1][2]) + A[i][0];
				D[i][1] = Math.min(D[i-1][0], D[i-1][2]) + A[i][1];
				D[i][2] = Math.min(D[i-1][0], D[i-1][1]) + A[i][2];
			}
			
			for(int j=0; j<=2; j++){ //D[n][j] 를 비교하므로 -> N번집 (마지막집)이랑 색을 비교한 다
				if(j == k) continue; //색이 같다면 패스
				ans = Math.min(ans , D[N][j]); //아니라면 최소값 구함
			}
		}
		System.out.println(ans);
		
	}

}
