
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main10709 {
	
	public static int[][] ans;
	public static int H,W;
	public static Queue<Pair> q;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken()); // 세로 H 
		W = Integer.parseInt(st.nextToken()); // 가로 W
		
		ans = new int[H][W];
		q=  new LinkedList<>();
		
		for(int i=0;i<H; i++) {
			String s = br.readLine();
			for(int j=0; j<W; j++) {
				 char c = s.charAt(j);
				 if(c == 'c') {
					 ans[i][j] = 0;
					 q.add(new Pair(i,j));
				 }else {
					 ans[i][j] = -1;
				 }
			}
		}

		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int y = p.y;
			int x = p.x;
			
			int cnt = 1;
			for(int i=x+1; i<W; i++) {
				if(ans[y][i] == 0) continue;
				ans[y][i] = cnt++; 
				
			}
		
		}
		
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static class Pair{
		int x,y;
		
		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	
	
	
	
	
	
}
