

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main17198 {
	
	static int[] dx = {-1, 1, 0,0}; //상하좌우 
	static int[] dy = {0,0, -1, 1};
	static char[][] map;
	static boolean[][] check = new boolean[10][10];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[10][10];
		int bx=0, by=0; //불난곳의 좌표 
		for(int i=0; i<10; i++) {
			String str = br.readLine();
			for(int j=0; j<10; j++) {
				map[i][j] = str.charAt(j);
				if(str.charAt(j) == 'B') { //불난곳을 기록 해둠 
					bx = i; by = j;
				}
			}
		}

		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(bx,by, 0)); //큐에 시작좌표 삽입 
		check[bx][by] = true; //시작 좌표 방문 처리 
		
		
		//BFS
		while(!q.isEmpty()) {
			Pair pair = q.poll();  //큐에서 원소 한개를 뺀 후 
			
			int curX = pair.x;
			int curY = pair.y;
			int len = pair.len;

			if(map[curX][curY] == 'L') {
				System.out.println(len - 1);
				break;
			}
			
			for(int i=0; i<4; i++) { //4방향 탐색 
				int X = curX + dx[i];
				int Y = curY + dy[i];
				if(valid(X, Y)) {
					check[X][Y] = true; //방문 처리 후 
					q.add(new Pair(X, Y, len+1)); //큐에 추
				}
			}
		}
		
		
	}
	
	
	public static boolean valid(int x, int y) {
		if(0<=x && x<10 && 0<=y && y <10 && map[x][y] != 'R'&& !check[x][y]) {
			return true;
		}
		return false;
	}
	
	static class Pair{
		int x, y;
		int len;
		
		public Pair(int x, int y, int len) {
			this.x = x;
			this.y = y;
			this.len = len;
		}
	}
	
}


