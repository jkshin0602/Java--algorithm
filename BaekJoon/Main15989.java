
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15989 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); 

		//D[i][j] = 정수i를 만들때 마지막으로 더한수 j를 사용함  
		//중복 제거 -> 오름차순으로 더하기 
		//D[i][1] = 바로 앞에 더한수는 1 
		//D[i][2] = 바로 앞에 더한수는 1,2이 올수있음 
		//D[i][3] = 바로 앞에 더한수는 1,2,3 올수있음 
		
		//D[i][1] = D[i-1][1]; 
		//D[i][2] = D[i-2][1] + D[i-2][2];
		//D[i][3] = D[i-3][1] + D[i-3][2] + D[i-3][3]

		int[][] D = new int[10001][4];
		
		D[1][1] = 1; // 1
		D[1][2] = 0; 
		D[1][3] = 0;
		
		D[2][1] = 1; // 1+1
		D[2][2] = 1; // 2
		D[2][3] = 0;
		
		D[3][1] = 1; // 1+1+1
		D[3][2] = 1; // 1+2
		D[3][3] = 1; // 3
		
		for(int i=4; i<10001; i++) {
			D[i][1] = D[i-1][1]; 
			D[i][2] = D[i-2][1] + D[i-2][2];
			D[i][3] = D[i-3][1] + D[i-3][2] + D[i-3][3];
		}
		 
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
	
			System.out.println(D[N][1]+D[N][2]+D[N][3]);		
		}
		
		
		
	}
	
	
	
}
