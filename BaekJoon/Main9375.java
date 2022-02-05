
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main9375 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 갯수 
		StringTokenizer st;
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine()); // 옷 개수 
			
			HashMap<String, Integer> map = new HashMap<>();
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String s = st.nextToken();
				if(map.containsKey(s)) { //이미 있다면 
					map.put(s, map.get(s)+1);
				}else { //첫 종류라면 
					map.put(s, 1);
				}
			}
			
			//a1 a2 b 2가지 종류, 3개 
			// 한번씩 입는 법 : a1 a2 b -> 3가지 
			// 조합해서 입는법 : a1b a2b -> 2가지 
			// 가상의 경우의수를 추가한다. (안입는 경우의수 ) 
			// 한번씩 입는 방법은 안입는 경우랑 매칭한 것이다.
			// 즉 (a1,a2) -> 	2가지++ -> 3가지
			// (b) -> 1가지++ -> 2가지 
			//3x2 =6 - (아예안입는 경우의수) = 6-1 = 5
			
			long answer = 1;
			for(String a : map.keySet()) {
				answer *= (map.get(a)+1);
			}
			answer--;
			System.out.println(answer);
		}
		
	}
	
	
	
}
