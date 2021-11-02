import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 동전의 종류 N
		int K = Integer.parseInt(st.nextToken()); // 가치의 합 K 
		// 동전 개수의 최소값을 구함
		int coinType[] = new int[N];
		for(int i=0; i<N; i++){
			coinType[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for(int i=N-1; i>=0; i--){
			cnt += K / coinType[i];
			K %= coinType[i];
		}
		System.out.println(cnt);
		
	}

}
