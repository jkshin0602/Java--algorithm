
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1068 {
	
	public static ArrayList<ArrayList<Integer>> graph;
	public static int N, remove, cnt, root;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1) root = i;
			else graph.get(parent).add(i); 
		}
		
		remove = Integer.parseInt(br.readLine()); 
		if(remove == root) {
			System.out.println("0");
			return;
		}
		
		System.out.println(dfs(root));
		
		
	}
	
	public static int dfs(int here) {
		int cnt = 0;
		int child = 0;

		for(int i=0; i<graph.get(here).size(); i++) {
			int there = graph.get(here).get(i);
			if(there == remove) continue;
			cnt += dfs(there);
			child++;
		}

		if(child == 0) return 1;
		return cnt;
	}
	
	
}
