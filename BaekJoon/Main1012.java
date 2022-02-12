
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1012 {
	
	public static int[] dy = {-1,0,1,0};
	public static int[] dx = {0,1,0,-1};
	public static int[][] map;
	public static boolean[][] check;
	public static int M, N;	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//인접한, 최소 갯수 -> DFS사용 
		int T = Integer.parseInt(br.readLine()); //테스트케이스 T
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine()); 
			M = Integer.parseInt(st.nextToken()); //가로의 길이 M
			N = Integer.parseInt(st.nextToken()); //세로의 길이 N
			int K = Integer.parseInt(st.nextToken()); //배추심은 갯수 K
			map = new int[N][M];
			check = new boolean[N][M];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine()); 
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;	
			}
			
			int ans = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1 && !check[i][j]) {
						dfs(i,j);
						ans++;
					}
				}
 			}
			
			System.out.println(ans);
		
		}
		
	}
	
	public static void dfs(int y, int x) {
		check[y][x] = true;
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || nx < 0 || ny>=N || nx>=M) continue;
			if(map[ny][nx] == 1 && !check[ny][nx]) {
				dfs(ny, nx);
			}
		}
		return;
	}
	
	
	
}
