
import java.util.Scanner;

public class Main1633 {

	public static void main(String[] args)  {
		
		//1. 백을 선택
		//2. 흑을 선택
		//3. 둘다 선택하지 않음 
		
		int[][] P = new int[1001][2];
		int[][][] D = new int[1001][16][16];
		//D[i][j][k] = max(D[i-1][j-1][k] + P[i][0], D[i-1][j][k-1]+P[i][1], D[i-1][i][j])
		
		int max_idx =  15;
		
		int cnt = 0;

		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			P[cnt][0] = sc.nextInt(); // 백
			P[cnt++][1] = sc.nextInt(); // 흑 
		}
		
		D[0][1][0] = P[0][0]; //첫번째 플레이어 백 
		D[0][0][1] = P[0][1]; //첫번째 플레이어 흑 
		
		int max = -1;
		for(int i=1; i<cnt; i++) {
			for(int j=0; j<=max_idx; j++) {
				for(int k=0; k<=max_idx; k++) {
					int tmp1 =0, tmp2 =0;
					if(j>0) { // i-1번째 참가자까지의 백 플레이어의 최대합 + 현재 백 플레이어값
						tmp1 = D[i-1][j-1][k] + P[i][0];
					}
					if(k>0) {// i-1번째 참가자까지의  흑 플레이어의 최대합 + 현재 흑 플레이어값
						tmp2 = D[i-1][j][k-1] + P[i][1];
					}
					D[i][j][k] = Math.max(D[i-1][j][k], Math.max(tmp1, tmp2));//가장큰값을 넣어줌 
					if(j==max_idx && k ==max_idx) {
						max = Math.max(max, D[i][j][k]);
					}
				}
			}
		}
		System.out.println(max);


	}
	
	
	
}
