import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main6236 {
	
	static int N, M;
	static int[] arr;

	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //N일동안 
		M = Integer.parseInt(st.nextToken()); //M번 뺀다
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(func());
		
		
		
	}
	
	static int func() {
		
		int left = 1;
		int right = 100000 * 10000;
		int ans = 0;
		while(left <= right) {
			int mid = (left + right) / 2; //인출 가능 금액 
			int money = mid; // 잔액 = 인출 가능 금액 
			int cnt = 1; //돈 봅은 횟수
			for(int i=0; i<N; i++) { // N일동안 돈을 뽑는다.
				
				if(arr[i] > mid) { //뽑을돈 > 인출 가능 금액  --> 뽑기 불가
					cnt = 0;
					break;
				}
				
				if(money < arr[i]) {//  돈이 부족하면 
					money = mid; //돈을 뽑는다.
					cnt ++;
				}
				money -= arr[i]; //잔액 - 뽑을돈 
				
			}
			if(cnt > 0 && cnt <= M) { //돈을뽑은 횟수가 M보다 적으면, 인출 가능 금액을 줄인다.-> 횟수 상승
				ans = mid; 
				right = mid - 1;
			}else { //돈을 뽑은 횟수가 더 많으면 , 인출 가능 금액을 늘린다 -> 횟수 감소 
				left = mid + 1;
			}
			
		}
		
		return ans;
		
	}

}
