
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //계단의 개수 
		int[] num = new int[301];
		
		for(int i=1; i<=N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		// D[i] = i번째 계단까지 오면서 얻을 수 있는 최댓값 
		// D[i] = max(num[i]+D[i-2], num[i] + num[i-1]+D[i-3])

		int[] D = new int[301];
		D[1] = num[1];
		D[2] = num[2] + D[1];
		
		for(int i=3; i<=N; i++) {
			D[i] = Math.max(num[i]+D[i-2], num[i]+num[i-1]+D[i-3]);
		}
		
		System.out.println(D[N]);
		
		
		
	}
	
	
	
}
