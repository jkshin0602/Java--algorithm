import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15649 {
	
	static int N;
	static int M;
	
	static int[] arr = new int[10];
	static boolean[] check = new boolean[10];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 1~N지 자연수 중 
		M = Integer.parseInt(st.nextToken()); // 중복없이 M개를 고른 수열 
		func(0);
		System.out.println(sb);

	}
	
	static void func(int k) { //현재까지 k개의 수를 택하였다.
		if(k == M) { //m개를 모두 택했으면 
			for(int i=0; i<M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=1; i<=N; i++) { //1부터 N까지의 수에 대해	
			if(!check[i]) { //i가 사용되지 않았다면
				arr[k] = i; //k번쨰 수를 i로 정함
				check[i] = true; // i를 사용했다고 표시
				func(k+1); //다음 수를 정함
				check[i] = false; //i를 사용해서 확인했으니 다시 사용되지 않았다고 명시
			}
		}
		
	}

}
