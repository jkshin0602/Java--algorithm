import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178 {
	
	public static int[] dy = {-1,0,1,0};
	public static int[] dx = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //세로 N 줄 
		int M = Integer.parseInt(st.nextToken()); //가로 M 칸
		int[][] map = new int[N][M];
		int[][] check = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		Pair start = new Pair(0,0);
		Pair end = new Pair(N-1,M-1);
		
		//최단거리 -> bfs 이용 
		Queue<Pair> q = new LinkedList<>();
		q.add(start);
		check[start.y][start.x] = 1;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int y = p.y;
			int x = p.x;
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || nx < 0 || ny>=N || nx>=M || map[ny][nx] == 0) continue;
				if(check[ny][nx] > 0) continue;
				check[ny][nx] = check[y][x] + 1;
				q.add(new Pair(ny,nx));
				
			}
		}
	
		System.out.println(check[end.y][end.x]);
		
	}
	
	public static class Pair{
		int y;
		int x;
		
		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
}
