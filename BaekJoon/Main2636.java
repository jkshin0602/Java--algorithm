
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2636 {

	public static int[] dy = {-1,0,1,0};
	public static int[] dx = {0,1,0,-1};
	public static int[][] c;
	public static boolean[][] check;
	public static int N,M, ans,cheese;

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//겉 부분을 탐색 
		//겉 부분의 조건 상하좌우 중 0이 한개라도 있으면 x 
		// 구멍 예외 처리 ( bfs -> 0,0 부터 처리, 치즈의 갯수 세주면서 bfs)
		
		
		c = new int[N][M];
		
		cheese = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				c[i][j] = Integer.parseInt(st.nextToken());
				if(c[i][j] == 1) cheese++;
			}
		}
		
		int cheeseCnt = 0; //녹기전 마지막 치즈 
		int time = 0; // 녹는 시간 
		while(cheese != 0) {
			cheeseCnt = cheese;
			time++;
			check = new boolean[N][M];
			bfs();
		}
		System.out.println(time + "\n" + cheeseCnt);
		
	}
	
	public static void bfs() {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0,0));
		check[0][0] = true;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int y = p.y;
			int x = p.x;
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || check[ny][nx])  continue;
				check[ny][nx] = true;
				if(c[ny][nx] == 0) {
					q.add(new Pair(ny,nx));
				}else {
					cheese--;
					c[ny][nx] = 0;
				}
 			}
		}
	}
	
	public static class Pair{
		int y,x;
		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	
}
