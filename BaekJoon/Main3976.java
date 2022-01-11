
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3976 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int c = Integer.parseInt(br.readLine()); // 테스트 케이스 c
		
		while(c-- > 0) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); //지정해놓은 점의 개수 n
			int[][] d = new int[n+1][2];
			int[][] pas = new int[n+1][2];
			int[][] dbb = new int[n+1][2];
			
			int l1 = Integer.parseInt(st.nextToken());  // 수비수 -> 스트라이커1 패스 난이도 
			int l2 = Integer.parseInt(st.nextToken());  // 수비수 -> 스트라이커2 패스 난이도 		
			int s1 = Integer.parseInt(st.nextToken());  // 스트라이커1 슛 난이도 
			int s2 = Integer.parseInt(st.nextToken());  // 스트라이커2 슛 난이도 
			
			st= new StringTokenizer(br.readLine());
			// 스트라이커1 -> 스트라이커 2 패스 난이도 
			for(int i=0; i<n-1; i++) {
				pas[i][0] = Integer.parseInt(st.nextToken());
			}
			st= new StringTokenizer(br.readLine());
			// 스트라이커1 드리블난이도  
			for(int i=0; i<n-1; i++) {
				dbb[i][0] = Integer.parseInt(st.nextToken());
			}
			st= new StringTokenizer(br.readLine());
			// 스트라이커2 -> 스트라이커 1 패스 난이도 
			for(int i=0; i<n-1; i++) {
				pas[i][1] = Integer.parseInt(st.nextToken());
			}
			st= new StringTokenizer(br.readLine());
			// 스트라이커2 드리블난이도  
			for(int i=0; i<n-1; i++) {
				dbb[i][1] = Integer.parseInt(st.nextToken());
			}
			
			d[0][0] = l1;
			d[0][1] = l2;
			
			for(int i=1; i<n; i++) {
				//             min(s1 드리블, s2->s1 패스)
				d[i][0] = Math.min(d[i-1][0]+dbb[i-1][0], d[i-1][1]+pas[i-1][1]);
				//	           min(s2 드리블, s1->s2 패스)
				d[i][1] = Math.min(d[i-1][1]+dbb[i-1][1], d[i-1][0]+pas[i-1][0]);
			}
			int answer = Math.min(d[n-1][0]+s1, d[n-1][1]+s2);
			System.out.println(answer);
			
		}
		
		
	}
	
	
	
}
