
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2468 {

	public static int[] dy = {-1,0,1,0};
	public static int[] dx = {0,1,0,-1};
	public static int N;
	public static int[][] map;
	public static boolean[][] check;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
	
		int min = 101;
		for(int i=0; i<N; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(map[i][j],min);
			}
		}
		
		int max = 1; //1~100 , 어떤지역도 물에 안잠길수도 있기 때문에 , 안전지대는 1로시작 
		for(int h=1; h<=100; h++) {
			check = new boolean[N][N];
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] > h && !check[i][j]){
						cnt++;
						dfs(i,j,h);
					}
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
		
	}
	
	public static void dfs(int y, int x, int h) {
		check[y][x] = true;
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || nx < 0 || ny >=N || nx >= N) continue;
			if(map[ny][nx] > h && !check[ny][nx]) {
				dfs(ny,nx,h);
			}
		}
	}
	
	
	
	
}
