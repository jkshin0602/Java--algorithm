
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main5619 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 수의 개수 N
	
		int[] num = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);   //정렬 
		
		// 6개까지 정렬하면 된다 
		int[] ans = new int[6];

		int s = 0;
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(s==6) break;
				ans[s++] = Integer.parseInt(num[i]+""+num[j]);
				ans[s++] = Integer.parseInt(num[j]+""+num[i]);
			}
		}

		Arrays.sort(ans);
		
		System.out.println(ans[2]);
		
	}
		
	
}
	
	
	

