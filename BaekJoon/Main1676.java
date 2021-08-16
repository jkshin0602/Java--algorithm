import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main1676 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int result = 0;
		int i = 1;
		//0의 개수를 구하는 방법 
		// 소인수 분해 했을 때 5의 개수를 찾아주면 된다.
		
		while(result < N){
			result = (int) Math.pow(5, i);
			cnt += (N/result);
			i++;
		}
		
		System.out.println(cnt);
	}
	
}
