import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14889 {
	
	public static int N, ans = Integer.MAX_VALUE;
	public static int[][] map;

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 N = Integer.parseInt(br.readLine());
		 map = new int[N][N];
		 for(int i=0; i<N; i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 for(int j=0; j<N; j++) {
				 map[i][j] = Integer.parseInt(st.nextToken());
			 }
		 }
		 
		 combination(0, 0, new boolean[N]);
		 
		 System.out.println(ans);
			
	}

	
	public static void combination(int start, int cnt, boolean[] checked) {
		
		if(cnt == N/2) {
			int left = 0, right = 0;
			
			for(int i=0; i<N; i++) {
				if(checked[i]) {
					for(int j=i+1; j<N; j++) {
						if(checked[j]) {
							left += map[i][j] + map[j][i];
						}
					}
				}else {
					for(int j=i+1; j<N; j++) {
						if(!checked[j]) {
							right += map[i][j] + map[j][i];
						}
					}
				}
			}
			
			ans = Math.min(ans, Math.abs(left-right));
			return;
		}
		
		for(int i=start; i<N; i++) {
			checked[i] = true;
			combination(i+1, cnt+1, checked);
			checked[i] = false;
		}
		
	}

	
}
