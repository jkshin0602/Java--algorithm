
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main1620 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //포켓몬 개수 
		int M = Integer.parseInt(st.nextToken()); // 문제의 개수 
		
		HashMap<Integer, String> m1 = new HashMap<Integer, String>();
		HashMap<String, Integer> m2 = new HashMap<String, Integer>();
		
		for(int i=1; i<=N; i++) {	
			String a = br.readLine();
			m1.put(i,a);
			m2.put(a, i);
		}
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			if(str.charAt(0)>='0' && str.charAt(0)<='9'){ //숫자라면 
				System.out.println(m1.get(Integer.parseInt(str)));
			}else {
				System.out.println(m2.get(str));
			}
		}
		
		
	}
	
	
	
}
