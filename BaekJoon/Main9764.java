
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9764 {
	
	public static final int MOD = 100999;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] D = new int[2001][2001];
	
		//D[i][j] = 1~j 사이의 수들의 합으로 i를 만드는 방법의 수 
		//1. j를 포함하지 않고 i를 만드는 경우
		// D[i][j] = D[i][j-1];  
		//2. j를 포함해서 i를 만드는 경우 
		// if(i>=j)  D[i][j] = (D[i][j] + D[i-j][j-1]) % mod ; 
		// D[i-j][j-1] = i-j를 1 ~ j-1 사이의 수들로 만드는방법의 수 
		
		//D[1][0] = 0
		//D[1][1] = 0 + 1 = 1;
		//D[2][0] = 0;
		//D[2][1] = D[1][0] + 0 = 0;
		//D[2][2] = 1;
		//D[3][0] = 0;
		//D[3][1] = D[2][0]+ D[3][1] = 0;
		//D[3][2] = D[1][1] + D[3][2] = 1;
		//D[3][3] = D[0][2] + D[3][2] = 1 + 1 = 2;
		//D[4][0]  = 0;
		//D[4][1] = D[3][0] = 0;
		//D[4][2] = D[2][1] = 0;
		//D[4][3] = D[1][2] = 1;
		//D[4][4] = 1 + 1 = 2;

		for(int i=0; i<2001; i++) { //자기자신을 사용할때의 경우의 수 초기화 
			D[0][i] = 1; 
		}
		
		for(int i=1; i<2001; i++) {
			for(int j=1; j<2001; j++) {
				D[i][j] = D[i][j-1];  //j를 포함하지 않고 i를 만드는 경우
				if(i >= j) {
					D[i][j] += D[i-j][j-1];
					D[i][j] %= MOD;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 T
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());	
			System.out.println(D[N][N]);		
		}
	
	}
	
	
	
}
