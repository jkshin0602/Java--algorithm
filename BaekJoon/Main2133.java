import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main2133 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] D = new int[N+1];
		D[0] = 1;
		for(int i=2; i<=N; i++){
			D[i] = 3*D[i-2];
			for(int j=i-4; j>=0; j-=2){
				D[i] += 2* D[j];
			}
		}
		System.out.println(D[N]);
		

	}

}
