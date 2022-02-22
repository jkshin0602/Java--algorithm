
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3474 {


	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 10 = 2와 5로 만들 수 있다.
		// N/(2의제곱) , N/(5의제곱) 의 최소값이 10을 만들 수 있는 갯수이다.
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 T 
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int f = 0;
			int t = 0;
			
			for(int i=2; i<=N; i*=2) {
				t += N/i;
			}
			for(int i=5; i<=N; i*=5) {
				f += N/i;
			}
			
			System.out.println(Math.min(f, t));
		}
	}
	

	
	
	
	
}
