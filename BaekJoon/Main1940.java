
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1940 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 재료의 개수 N
		int M = Integer.parseInt(br.readLine()); // 갑옷을 만드는데 필요한 수 M 
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for(int i=0 ; i<N; i++) {
			int tmp = M - num[i];
			
			for(int j=0; j<N; j++) {
				if(j == i) continue;
				if(tmp == num[j]) {

					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt/2);
		
	}
	
	
	
}
