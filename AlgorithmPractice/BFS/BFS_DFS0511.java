package CodeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_DFS0511 {
	
	public static int N, M;
	public static int[][] graph = new int[201][201];
	
	//이동할 네 가지 방향 정의 (상, 하, 좌, 우)
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static int bfs(int x, int y){
		//큐구현을 위해서 Queue 라이브러리 사용
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(x, y));
		//큐가 빌 때까지 반복하기
		while(!q.isEmpty()){
			Node node = q.poll();
			x = node.getX();
			y = node.getY();
			//현재 위치에서 4가지 방향으로의 확인
			for(int i=0; i<4; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				//미로 찾기 공간을 벗어난 경우 무시
				if(nx < 0 || nx >= N || ny < 0 || ny >=M) continue;
				//벽인 경우 무시
				if(graph[nx][ny] == 0) continue;
				//해당 노드를 처음 방문하는 경우에만 최단 거리 기록
				if(graph[nx][ny] == 1){
					graph[nx][ny] = graph[x][y] + 1;
					q.offer(new Node(nx,ny));
				}
			}
		}
		//가장 오른쪽 아래까지의 최단 거리 반환
		return graph[N - 1][M - 1];
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //세로 길이  N
		M = Integer.parseInt(st.nextToken()); // 가로 길이 M 
		
		//맵 정보 입력 받기
		for(int i=0; i<N; i++){
			String str = br.readLine();
			for(int j=0; j<M; j++){
				graph[i][j] = str.charAt(j)-'0';
			}
		}
		
		//출력 결과
		System.out.println(bfs(0,0));
		
	}

}

class Node{
	private int x;
	private int y;
	
	public Node(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
}

