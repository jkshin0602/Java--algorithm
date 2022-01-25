package Cho.week_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main15991 {
	
	public static final int MOD = 1_000_000_009;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 T
		long[] D = new long[100001];
		//D[i] = 정수 i를 만드는 대칭을 이루는 합을 나타내는 방법의 갯수 
		//1+대칭+1
		//2+대칭+2
		//3+대칭+3
		//D[i] = D[i-2] + D[i-4] + D[i-6] % mod;
		
		D[0] = 0;
		D[1] = 1;
		D[2] = 2;
		D[3] = 2; 
		D[4] = 3;
		D[5] = 3;
//		1 1 1 1 1
//		2 1 2
//		1 3 1
		D[6] = 6; 
//		1 1 1 1 1 1
//		1 1 2 1 1
//		1 2 2 1
//		2 1 1 2
//		2 2 2
//		3 3
		
		for(int i=7; i<100001; i++) {
			D[i] = (D[i-2] + D[i-4] + D[i-6]) % MOD;
		}

		
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(D[N]);
		}
	}
	
	
	
}
