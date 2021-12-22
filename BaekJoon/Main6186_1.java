package Cho.week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6186_1 {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0,0, -1, 1};
	static char[][] map;
	static boolean[][] check;

	static int R, C;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		check = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int cnt = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == '#' && !check[i][j]) {
					dfs(new Pair(i,j));
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		

	}
	
	static void dfs(Pair pair) {
		
		int x = pair.x;
		int y = pair.y;
		
		check[x][y] = true;
				
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(valid(nx, ny) && map[nx][ny] == '#') {
				dfs(new Pair(nx,ny));
			}
		}

	}
	
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

	static boolean valid(int x, int y) {
		if(x < 0 || x > R-1 || y < 0 || y > C-1 || check[x][y]) {
			return false;
		}
		return true;
	}
}
