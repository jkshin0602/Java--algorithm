import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main1260 {
	
	public static ArrayList<Integer>[] graph;
	public static int N;
	public static boolean[] visited; //방문

	//dfs
	public static void dfs(int V){
		//현재 노드를 방문 처리
		visited[V] = true;
		System.out.print(V+" ");
		//현재 노드와 연결된 다른 노드를 재귀적으로 방문
		for(int y : graph[V]){
			if(!visited[y]) 
				dfs(y);
 		}
	}
	
	//bfs 
	public static void bfs(int V){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(V);
		//현재 노드를 방문 처리
		visited[V] = true;
		//큐가 빌때까지 반복
		while(!q.isEmpty()){
			//큐에서 하나의 원소를 뽑아 출력
			int x = q.poll();
			System.out.print(x + " ");
			//해당 원소와 연결된, 아직 방문하지 않는 원소들을 큐에 삽입
			for(int y : graph[x]){
				if(!visited[y]){
					visited[y] = true;
					q.add(y);
				}
			}
		}

	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 시작할 노드 번호
		
		graph = new ArrayList[N+1];
		
		//그래프 초기화
		for(int i=1; i<N+1; i++){
			graph[i] = new ArrayList<Integer>();
		}
		//연결 그래프 생성
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x].add(y);
			graph[y].add(x);
		}
		
		for(int i=1; i<N+1; i++){
			Collections.sort(graph[i]);
		}
		
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		
		visited = new boolean[N+1];
		bfs(V);
		
		br.close();
		
	}

}
