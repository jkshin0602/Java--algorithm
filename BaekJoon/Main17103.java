import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17103 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//에라토스네스의 체로 소수 판별 
		boolean[] check= new boolean[1000001];  //지워졌으면 true
		int n = 1000000; //100까지 소수
		for(int i=2; i<=n; i++){
				if(!check[i]){ //소수이면 
					for(int j= i*2; j<=n; j+=i){ // i*(i+j)로 배수를 지운다.
							check[j] = true; //소수가 아니라고 표시
					}
				}
		}
		//check[j] = false 면 소수이다
		check[0] = check[1] = true;
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스
		for(int i=0; i<T; i++){
			int cnt = 0;
			int N = Integer.parseInt(br.readLine()); //정수 N은 짝수/백만이하

			//for(int j=3; j<=N/2; j+=2) 기존반복문에서 교체한다.
			//즉 절반만 비교하면 된다.
			for(int j=2; j<=N/2; j++){ //홀수단위로 2씩 증가해 홀수 유지
				//N/2까지 비교하는 이유 : 3 5 , 5 3 이런식으로 같으면 한개로 인정되기 때문에 
				//N/2로하면 3 5 까지만 비교하게된다. 
				//서로 대칭이 되기 때문이다.
				if(!check[j] && !check[N-j]){//소수이고 & N-j값도 소수이면 골드바흐 파티션 성립 
					
					cnt++;
				}
			}		
			System.out.println(cnt);
		}

		
	}//main
	
	
}
