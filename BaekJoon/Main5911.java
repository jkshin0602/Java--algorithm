
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5911 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 친구수 N 
		int B = Integer.parseInt(st.nextToken()); // 돈 B
		
		int[] P = new int[N]; // 선물 가격
		int[] S = new int[N]; // 배송 가격 
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			P[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		sort_sum(P, S);

		// 1. 탐욕 접근 -> 총합 배열 정렬 
		// 2. 2중 for문으로 한개의 상품에 쿠폰적용하고, 그 외의 모든 상품을 검사 
		// 3. N^2 
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			int tmp=1; // 이미 한개의 상품은 포함 
			int money = B - (P[i]/2 + S[i]); //하나의 상품에 쿠폰 적용 
			if(money < 0) continue;	// 0이 나오면 못쓴다 
			
			for(int j=0; j<N; j++) {		
				if(P[j]+S[j] <= money && i != j) { // 총합이 현재 money보다 작으면 && 쿠폰적용된 상품은 제외 
					money -= P[j]+S[j];
					tmp++;
				}
			}
			answer = Math.max(answer, tmp);
		
		}
		
		System.out.println(answer);
		

		
	}
	
	public static void sort_sum(int[] P, int[] S) { //버블정렬 활용 -> 총합으로 배열 정렬 
		
		boolean check = false;
		int tmp = 0;
		int len = P.length;
		
		while(!check) { 
			check = true; 
			for(int i=0; i<len-1; i++) {
				if(P[i] + S[i] > P[i+1] + S[i+1]) { 
					tmp = P[i];
					P[i] = P[i+1];
					P[i+1] = tmp;
					
					tmp = S[i];
					S[i] = S[i+1];
					S[i+1] = tmp;
					check = false;
				}
			}
		}
	}
	
	
}
