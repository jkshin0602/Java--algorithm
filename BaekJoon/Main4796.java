import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main4796 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 1;
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken()); //L일동안
			int P = Integer.parseInt(st.nextToken()); //캠핑장 P일중
			int V = Integer.parseInt(st.nextToken()); // V일 짜리 휴가
			
			if(L == 0 && P == 0 && V == 0) break;
			int result = ((V/P)*L) + Math.min(V%P, L); // L일 동안 사용하는 것이 더 작을수도 있다.
			System.out.println("Case "+cnt+": "+result);
			cnt++;
		}

	}

}
