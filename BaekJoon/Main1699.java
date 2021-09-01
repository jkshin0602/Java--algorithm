import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main1699 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] D = new int[N+1];
		
		//마지막수가 i^2라 가정하면, 그 이전까지의 합은 N-i^2이다.
		//즉 D[N-i^2]를 구해 +1을 해주면 D[N]을 구할 수 있다.
		//N -> i, i-> j (for문)
		
		//점화식
		//D[i] = min(D[i], D[i-j*j]+1) 
		for(int i=1; i<=N; i++){
			D[i] = i; //최소갯수를 구할때는 초기값을 0으로 설정하면안된다. 
			for(int j=1; j*j <=i; j++){ // j*j는 현재의 i(N)값을 넘을 수 없기 때문 (반복횟수 줄여줌)
				if(D[i] > D[i-j*j]+1){ //만약 작다면 갱신해준다.
					D[i] = D[i-j*j]+1;
				}
			}
		}
		System.out.println(D[N]);
		
	}

}
