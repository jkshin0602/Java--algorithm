
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1455 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] coin = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				coin[i][j] = str.charAt(j) - '0';
			}
		}

		//1. 배열의끝 (2,2)부터 1을 만나면 모두 뒤집어 준다 .
		//2. 한번 뒤집을때마다 그 기준점은 0이 고정되어 있다.
		/*
		 * 00  2,2
		 * 01   --> 2,2 선택 
		 * 
		 * 11  2,1
		 * 10  --> 2,1 선택 
		 * 
		 * 01  1,2
		 * 00  --> 1,2 선택 
		 * 
		 * 10  1,1
		 * 00 --> 1,1 선
		 * 
		 * 00 
		 * 00
		 * 
		 */		
		int cnt = 0;
		for(int i=N-1; i>=0; i--) {
			for(int j=M-1; j>=0; j--) {
				if(coin[i][j] == 1) {
					cnt++;
					
					for(int k=0; k<=i; k++) {
						for(int h=0; h<=j; h++) {
							if(coin[k][h] == 1) {
								coin[k][h]=0;
							}else if(coin[k][h] == 0){
								coin[k][h]=1; 
							}
						}
					}
					
					
				}
			}
		}
		System.out.println(cnt);
		
		
	}
	
	
	
	
}
