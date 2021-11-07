package CodeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BFS_DFS0510 {
	
	public static int N, M;
	public static int[][] graph = new int[1000][1000];
	
	//DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
	public static boolean dfs(int x, int y){
		//주어진 범위를 벗어나는 경우에는 즉시 종료
		if(x <= -1 || x >=N || y <= -1 || y >= M){
			return false;
		}
		//현재 노드를 아직 방문하지 않았다면
		if(graph[x][y] == 0){
			//해당 노드 방문 처리
			graph[x][y] = 1;
			//상,하,좌,우의 위치들도 모두 재귀적으로 호출
			dfs(x-1, y);
			dfs(x, y-1);
			dfs(x+1, y);
			dfs(x, y+1);
			return true;
		}
		return false;
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
		
		
		//모든 노드에 대하여 음료수 채우기
		int result = 0;
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				//현재 위치에서 DFS 수행
				if(dfs(i,j)){
					result ++;
				}
			}
		}
		System.out.println(result);
	
	}
	
}

