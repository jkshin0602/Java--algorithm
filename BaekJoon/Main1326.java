
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1326 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] rock = new int[N+1];
		boolean[] check = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			rock[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()); //출발 돌 
		int b = Integer.parseInt(st.nextToken()); //도착 돌
		
		Queue<Pair> q = new LinkedList<>(); //큐 선언 
		check[a] = true; 
		q.offer(new Pair(a,0));

		while(!q.isEmpty()) { //bfs시작 
			Pair pair = q.poll();
			int x = pair.x; //현재 위치 
			int cnt = pair.cnt; //점프한 횟수 
			
			if(x == b) { //현재위치가 도착돌에 도착했다면 종료 
				System.out.println(cnt);
				System.exit(0);
			}
			
			for(int i=1; x+(rock[x]*i) <= N; i++) {  //x의 양의 배수 검사 
				int next = x + rock[x] * i; //next = x의 배수 
				if(!check[next]) { //첫 방문이면 
					check[next] = true; //방문 체크 
					q.offer(new Pair(next, cnt +1)); //큐에 추가 
				}
			}
			for(int i=1; x-(rock[x]*i) >= 1; i++) { // x의 음의 배수 검사 
				int next = x - rock[x] * i;
				if(!check[next]) { // 첫 방문이면	
					check[next] = true;
					q.offer(new Pair(next, cnt + 1));
				}
			}
			
			
		}
		System.out.println(-1);		
		
	}
	
	static class Pair{
		int x;
		int cnt;
		
		public Pair(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
		
	}
}
