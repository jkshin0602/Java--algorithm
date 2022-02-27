package CodeTestPractice.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14502 {
	
	public static int[] dy = {-1, 0 , 1, 0};
	public static int[] dx = {0,1,0,-1};
	public static int[][] map, arr;
	public static int N, M, answer;
	public static boolean[][] check;

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M]; //벽을 넣으면서 바꾸는 맵 
		arr = new int[N][M]; //변하지 않는 고유의 맵 
		// 64 C 3
		// bfs + dfs 문제 
		// 1. 벽을 세움 (DFS)
		// 2. 바이러스를 퍼트림 (BFS)
		// 3. 안전영역의 갯수 세기

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0) { //만약 빈공간이라면 
					map[i][j] = 1; //벽을 세워줌 
					dfs(1); 
					map[i][j] = 0; //다시 벽을 없앰 
				}
			}
		}
		
		
		System.out.println(answer);
	}
	
	public static void dfs(int cnt) { //벽을 3개 세우기위한 dfs 
		if(cnt == 3) { //만약 벽이 3개라면 
			bfs(); //바이러스를 퍼트리고 개수를 세줌 
			return;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) { //만약 빈공간이면 
					map[i][j] = 1; //벽을 세워줌 
					dfs(cnt+1); 
					map[i][j] = 0; //벽을 없앰 
				}
 			}
		}
	}
	
	public static void bfs() { //바이러스를 세주기위한 bfs 
		int[][] virus = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				virus[i][j] = map[i][j];
			}
		}
		
		Queue<Pair> q = new LinkedList<>(); //큐에 바이러스 좌표를 넣음 
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(virus[i][j] == 2) {
					q.add(new Pair(i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
				if(virus[ny][nx] == 0) { //바이러스옆이면 감염 
					virus[ny][nx] = 2;
					q.add(new Pair(ny, nx)); //새로운 바이러스를 큐에 넣어줌 
				}
			}
		}
		
		cntAnswer(virus); // 바이러스로 다 채웠다면 안전영역을 세줌 
	}
	
	public static void cntAnswer(int[][] virus) { //안전 영역을 세주는 함수 
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(virus[i][j] == 0) {
					++cnt;
				}
			}
		}
		answer = Math.max(cnt,answer);
	}

	public static class Pair{
		int y,x;
		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	
	
	
	
	
}
