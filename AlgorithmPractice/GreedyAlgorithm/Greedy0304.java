package CodeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Greedy0304 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 자연수 N 
		int K = Integer.parseInt(st.nextToken()); // 나눌 수 K
		// N >= K
		
		int cnt = 0;
		
		while(true){
			//(N == K로 나누어떨어지는 수)가 될 때까지 1씩 빼기
			int target = (N / K) * K; 
			cnt += (N - target);
			N = target;
			// N이 K보다 작을 때 (더이상 나눌 수 없을 때) 종료
			if(N < K){
				break;
			}
			// K로 나누기
			cnt += 1;
			N /= K;
			
		}
		cnt += (N-1);
		System.out.println(cnt);
		
	}

}
