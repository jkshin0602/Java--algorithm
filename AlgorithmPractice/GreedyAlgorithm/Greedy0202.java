package CodeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy0202 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 배열의 크기 N
		int M = Integer.parseInt(st.nextToken()); // 더하기 횟수 M
		int K = Integer.parseInt(st.nextToken()); // 연속더하기 불가한 횟수 K
		// K <= M
		
		int num[] = new int[N];

		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<N; i++){
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num); //정렬 
		int first = num[N-1]; //첫번째로 큰 수
		int second = num[N-2]; // 두번째로 큰수
		
		//가장 큰 수가 더해지는 횟수 계산
		int count = (M/ (K+1)) * K;   
		count += M % (K+1); // M / (K+1)이 나머지가 발생할때 추가로 더해줘야 한다.
		
		int ans = 0;
		ans += count * first; // 큰수 더하 기
		ans += (M-count) * second; //두번 째로 큰 수 더하기
		
		System.out.println(ans);
		
		
		
	}

}
