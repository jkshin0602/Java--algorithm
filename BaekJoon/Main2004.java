import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main2004 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//nCm = n!/ (n-m)! * m!   =  n!의 0의개수 - (n-m)! * m! 의 0의 개수 
		int a = zeroCount(N, 5) - zeroCount(N-M, 5)-zeroCount(M, 5);
		int b = zeroCount(N, 2) - zeroCount(N-M, 2)-zeroCount(M, 2);
		System.out.println(Math.min(a, b));
		
		
	}
	//0의 개수를 구하는 방법 
	// 소인수 분해 했을 때 5의 개수를 찾아주면 된다.
	public static int zeroCount(int n, int pow){
		int cnt = 0;
		int result = 0;
		int i = 1;
		
		while(result < n){
			result = (int) Math.pow(pow, i);
			cnt += (n/result);
			i++;
		}
		
		return cnt;	
	}
	
}
