
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main2910 {


	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()); 
		
		
		int N = Integer.parseInt(st.nextToken()); // 메시지의 길이 N 
		int C = Integer.parseInt(st.nextToken()); // 숫자의 범위 <= C
		
		// 1. X 등장 횟수 > Y 등장 횟수 ->  X , Y 순서 
		// 2. X 등장 횟수 == Y 등장횟수 -> 먼저나온 것 
		st = new StringTokenizer(br.readLine());
		HashMap<Integer, Node> m = new HashMap<Integer, Node>();
		
		int tmp = 0;
		for(int i=0; i<N; i++) {
			tmp = Integer.parseInt(st.nextToken());
			if(m.containsKey(tmp)) { //이미 값이 있다면 
				Node node = m.get(tmp);
				node.cnt++;
				m.put(tmp, node);
			}else {
				m.put(tmp, new Node(tmp, 1, i));
			}	
		}

		ArrayList<Node> list = new ArrayList<>();
		for(Integer s : m.keySet()) {
			list.add(m.get(s));
		}
		Collections.sort(list);
		for(Node node : list) {
			for(int i=0; i< node.cnt; i++) {
				System.out.print(node.num + " ");
			}
		}
		
		
	}
	
	// Comparable : 자기 자신과 매개변수 객체를 비교 
	// Comparator : 두 매개변수 객체를 비교
	
	
	static class Node implements Comparable<Node>{
		int num;
		int cnt;
		int idx;
		
		public Node(int num, int cnt, int idx) {
			this.num = num;
			this.cnt = cnt;
			this.idx = idx;
		}

		@Override
		public int compareTo(Node o) {
			if(o.cnt == this.cnt) { 
				// 음수이면 객체의 자리가 유지 
				return this.idx - o.idx; 
			}
			//양수이면 객체의 자리 변환 
			return o.cnt - this.cnt; //더 큰 cnt 반환 
		}
	}

}
