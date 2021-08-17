import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main17087 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //동생의 수 N
		int S = Integer.parseInt(st.nextToken()); //수빈이의 위치 점 S
		
		int[] interval = new int[N]; //동생 N명의 각각의 위치 와 수빈이의 위치 S 의 차이
		
		st = new StringTokenizer(br.readLine()); //동생N명의 위치 입력받음
		for(int i=0; i<N; i++){
			interval[i] =  Math.abs(Integer.parseInt(st.nextToken())-S); //거리 차이 계산해서 저장
		}
		
		if(N == 1){ //동생이 1명이면 한명의 거리값만 출력하면된다.
			System.out.println(interval[0]); 
			System.exit(0); 
		}
		
		int D = gcd(interval[0], interval[1]); //
		for(int i=2; i<N; i++){
			D = gcd(D,interval[i]); //D값 갱신 
		}
		System.out.println(D);
		
		
	}

	public static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
