import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15651 {
	
	static int N;
	static int M;
	
	static int[] arr = new int[10];
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //1부터 M까지 자연수 중에서 
		M = Integer.parseInt(st.nextToken()); // M개를 고른 수 (중복 허용)
		

		func(0);
		
		System.out.println(sb); 	
		

	}
	
	static void func(int k) { //k개까지 수를 택했다
		if(k == M) { // M개까지의 수를 택했으면 출력 
			for(int i=0; i<M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=1; i<=N; i++) { //1부터 n까지의 수에 대해
			arr[k] = i; //k번째를 i로 정한다. 
			func(k+1); 
			
		}
	}
	
	
	

}
