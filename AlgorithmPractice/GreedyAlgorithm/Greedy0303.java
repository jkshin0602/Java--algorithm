package CodeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Greedy0303 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 행의 개수 N
		int M = Integer.parseInt(st.nextToken()); // 열의 개수 M
		int card[][] = new int[N][M];
		int result = 0;
		
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int minNum = 10_001;
			for(int j=0; j<M; j++){
				card[i][j] = Integer.parseInt(st.nextToken());
				minNum = Math.min(minNum, card[i][j]);//행에서 가장 낮은 수 
			}
			result = Math.max(minNum, result); //행들 중에서 가장 큰 수
		}
		System.out.println(result);
		
		
	}

}
