
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17086 {
	
	static int N, M;
	static int[] dx = {-1,-1,0,1,1,1,0,-1}; //위 -> 시계방향 
	static int[] dy = {0,1,1,1,0,-1,-1,-1}; 
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[][] cnts = new int[N][M]; //안전거리 배열 

		Queue<Pair> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q.offer(new Pair(i,j)); //상어의 위치를담아준다. 
				}
			}
		}

		int cnt = Integer.MIN_VALUE;
		
		while(!q.isEmpty()){
			Pair pair = q.poll();
			int x = pair.x;
			int y = pair.y;
			
			for(int i=0; i<8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(valid(nx, ny)) {
					if(cnts[nx][ny] == 0 && map[nx][ny] != 1) {	//안전거리가 저장안되어있거나, 상어의 위치가 아니면 
						cnts[nx][ny] = cnts[x][y]+1; //안전거리 1증가 
						cnt = Math.max(cnts[nx][ny], cnt);
						q.add(new Pair(nx, ny));
					}
				}
			}
		}
		
		System.out.println(cnt);
		
		
		
	}
	
	public static boolean valid(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) {
			return false;
		}
		return true;
	}

	static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
	}
}
