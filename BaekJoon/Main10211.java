import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10211 {
	
	static int[] D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine()); //배열의 크기 N
			int[] X = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println(maximum(X));
			
		}
		

	}
	
	public static int maximum(int[] X) {
		D = new int[X.length]; 
		for(int i=0; i<X.length; i++) {
			D[i] = X[i]; //연속하지 않은경우 (새로운값으로 갱신) 
			if(i == 0) continue;
			if(D[i] < D[i-1] + X[i]) { //연속하는 경우 , 지금까지 합이랑 더했을때 더 크면 새로 갱신 
				D[i] = D[i-1] + X[i];
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<X.length; i++) {
			max = Math.max(max, D[i]);
		}
		
		return max;		
	}

}
