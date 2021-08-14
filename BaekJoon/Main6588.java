import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main6588 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		//에라토스네스의 체를 사용해 소수 판별
		boolean[] check= new boolean[1000001];  //지워졌으면 true
		int n = 1000000; //100까지 소수
		for(int i=2; i<=n; i++){
				if(!check[i]){ //소수이면 
					for(int j= i*2; j<=n; j+=i){ // i*(i+j)로 배수를 지운다.
							check[j] = true; //소수가 아니라고 표시
					}
				}
		}
		
		
		while(true){
			int T = Integer.parseInt(br.readLine());
			boolean exist = false;
			 
			if(T == 0){ //종료
				System.out.println(sb);
				break;
			}
			
			for(int i=3; i<=T; i+=2){ //홀수단위로 2씩 증가해 홀수 유지
				if(!check[i] && !check[T-i]){ //둘다 소수이면 답을 찾음  T = i + (T-i) 형태로 나타낼 수 있다.
					sb.append(T+" = "+i+" + "+(T-i)).append("\n");
					exist = true;
					
					break;
				}
			}
			
			if(! exist){
				sb.append("Goldbach's conjecture is wrong.").append("\n");
			
			}
			
		}
	
		
		
	}

}
