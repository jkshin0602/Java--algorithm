
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main2583 {

	public static int[][] map;
	public static boolean[][] check;
	public static int M, N, T;
	public static int[] dy = {-1,0,1,0};
	public static int[] dx = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //세로 M 
		N = Integer.parseInt(st.nextToken()); //가로 N 
		int K = Integer.parseInt(st.nextToken()); //직사각형 갯수 K
		
		map = new int[M][N];
		check = new boolean[M][N];
		
		while(K-- > 0) {
			st = new StringTokenizer(br.readLine()); 
			int lx = Integer.parseInt(st.nextToken()); 
			int ly = Integer.parseInt(st.nextToken()); 
			int rx = Integer.parseInt(st.nextToken()); 
			int ry = Integer.parseInt(st.nextToken());
					
			for(int i=M-ry; i<M-ly; i++) {
				for(int j=lx; j<rx; j++) {
					map[i][j]++;
				}
			}		
		}
		
		int cnt = 0;
		int a = 0;
		int[] ans = new int[100];
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0 && !check[i][j]) {
					dfs(i,j);
					cnt++;
					ans[a++] = T;
					T = 0;
				}
			}
		}
		
		Arrays.sort(ans);
		System.out.println(cnt);
		
		for(int i=0; i<ans.length; i++) {
			if(ans[i] == 0) continue;;
			System.out.print(ans[i] + " ");
		}
			
	}
	
	public static void dfs(int y, int x) {
		check[y][x] = true;
		T++;
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny<0 || nx<0 || ny>= M || nx>=N) continue;
			if(map[ny][nx] == 0 && !check[ny][nx]) {
				dfs(ny, nx);
			}
		}
		return;
	}
	
	
	
	
	
	
}
