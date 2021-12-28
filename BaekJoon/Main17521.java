
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17521 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //요일수 n
		long W = Long.parseLong(st.nextToken()); //보유 현금 W
		int[] price = new int[n]; 
		for(int i=0; i<n; i++) {
			price[i] = Integer.parseInt(br.readLine());
		}
		
		//1. price[i] < price[i+1] 코인 매수  
		//2. price[i] > price[i+1] 코인 매도 
		
		long coin = 0;
		
		for(int i=0; i<n-1; i++) {
			if(price[i] < price[i+1] && W >= price[i]) { //매수 
				coin += (W/price[i]);
				W %= price[i];
			}else if(price[i] > price[i+1] && coin != 0) { //매도 
				W += (coin*price[i]);
				coin = 0;
			}
		}
		
		W = W + coin*price[n-1];

		System.out.println(W);
				
		
	}
}
