
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14754 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] box = new int[n][m];
		boolean[][] check = new boolean[n][m];
		
		for(int i=0; i<n ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. 가로에서 가장 높은 박스, 세로에서 가장 높은 박스를 각 줄마다 구한다.
		// 2. 측면이든, 앞이든 영향을 주는 높이는 가장 높은 박스들이다. 
		// 3. 같은 check 배열에 담는다. 
	
		for(int j=0; j<m; j++) {
			int max = -1;
			int x =0, y=0;
			for(int i=0; i<n; i++) {
				if(box[i][j] > max) {
					max = box[i][j];
					x = i;
					y = j; 
				}
			}
			check[x][y] = true;
		}

		
		for(int i=0; i<n; i++) {
			int max = -1;
			int x = 0, y=0;
			for(int j=0; j<m; j++) {
				if(box[i][j] > max) {
					max = box[i][j];
					x = i;
					y = j;
				}
			}
			if(!check[x][y]){
				check[x][y] = true;
			}
		}
		
		long answer = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!check[i][j]) {
					answer += box[i][j];
				}
			}
		}
		System.out.println(answer);
		
		
	}
}
