import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main2775 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		int[][] apt = new int[15][15];
		
		for(int i=0; i<15; i++){
			apt[i][1] = 1;
			apt[0][i] = i;
		}
		
		for(int i=1; i<15; i++){
			for(int j=2; j<15; j++){
				apt[i][j] = apt[i][j-1] + apt[i-1][j]; // -1호 + 아래층 호의 합 
			}
		}
		
		for(int i=0; i<T; i++){
			int k = Integer.parseInt(bf.readLine());
			int n = Integer.parseInt(bf.readLine());
			System.out.println(apt[k][n]);
		}
	}	

}

