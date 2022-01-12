
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main21758 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine()); //  꿀통의 개수N
		int[] honey = new int[N+1];
		int[] sum = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N; i++) {
			honey[i] = Integer.parseInt(st.nextToken());
			sum[i] = honey[i]+ sum[i-1];
		}

		int ans = 0;
		
		//벌 벌 벌통
		for(int i=2; i<=N-1; i++) {
//	       			 |      첫번째  벌 		   	   |   두번째 벌 
			int tmp = sum[N] - honey[1] - honey[i] + sum[N] - sum[i];		
			ans = Math.max(ans, tmp);
		}
		
		//벌 벌통 벌
		for(int i=2; i<=N-1; i++) {
			//         오른쪽 벌         |  왼쪽벌  
			int tmp = sum[N-1]-sum[i-1]+sum[i]-sum[1];
			ans = Math.max(ans, tmp);
		}
		
		//벌통 벌 벌 
		for(int i=2; i<=N-1; i++) {
			//         첫번째 벌  |           두번째벌 
			int tmp = sum[N-1] - honey[i] + sum[i-1];
			ans = Math.max(ans, tmp);
		}
		System.out.println(ans);
		
		
		
		
	}
	
	
}
