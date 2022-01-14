
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2780 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//D[i][x] = i길이 마지막 사용된 수가 x인 비밀번호 갯수 
		//D[i-1][x] = i-1 길이의 마지막 사용된수가 x인 비밀번호 갯수
		//D[i][x] = D[i-1][x1] + D[i-1][x2] + ... (x1~xn: 인접하는 수의 개수) 
		
		int[][] D = new int[1001][10];
		for(int i=0; i<10; i++) {
			D[1][i] = 1;
		}
		
		for(int i=2; i<= 1000; i++) { 
			for(int j=0; j<10; j++) { //각 인접하는 숫자 x , D[i][j] = D[i-1][x]... 
				if(j == 0)	D[i][j] = D[i-1][7];
				else if(j == 1)	D[i][j] = D[i-1][2] + D[i-1][4];
				else if(j == 2)	D[i][j] = D[i-1][1] + D[i-1][3] + D[i-1][5];
				else if(j == 3)	D[i][j] = D[i-1][2] + D[i-1][6];
				else if(j == 4)	D[i][j] = D[i-1][1] + D[i-1][5] + D[i-1][7];
				else if(j == 5)	D[i][j] = D[i-1][2] + D[i-1][4] + D[i-1][6] + D[i-1][8];
				else if(j == 6) D[i][j] = D[i-1][3] + D[i-1][5] + D[i-1][9];
				else if(j == 7) D[i][j] = D[i-1][0] + D[i-1][4] + D[i-1][8];
				else if(j == 8) D[i][j] = D[i-1][5] + D[i-1][7] + D[i-1][9];
				else if(j == 9) D[i][j] = D[i-1][6] + D[i-1][8];
				D[i][j] %= 1234567;
			}
		}
		
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			for(int i=0; i<10; i++) {
				ans = (ans + D[N][i]) % 1234567;
			}
			System.out.println(ans);	
		}
			
	}

	
}
