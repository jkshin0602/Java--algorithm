import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main1929 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int M = Integer.parseInt(st.nextToken()); //최소
		int N = Integer.parseInt(st.nextToken()); //최대
		
		boolean[] prime = new boolean[N+1];
		prime[0] = prime[1] = true;
		
		for(int i=2; i<=Math.sqrt(prime.length); i++){ // N의 제곱근 만큼만 해주면 된다 .N*N 까지 검사
			if(prime[i]) continue;
			for(int j= i*2; j<prime.length; j+=i){ //배수를 지움 ex)i=2-> 4 6 8 10 ...				   
				prime[j] = true; //소수가 아닌것들은 true;
			}
		}
		
		for(int i=M; i<=N; i++){
			if(!prime[i]){ //false 이면 소수이다.
				System.out.println(i);
			}
		}
	}
	
}
