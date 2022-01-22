
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main16500 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine(); 
		int N = Integer.parseInt(br.readLine()); // 문자열의 개수 
	
		Set<String> A = new HashSet<String>();
		
		for(int i=0; i<N; i++) {
			A.add(br.readLine());
		}
		
		int[] D = new int[101];
		//D[i]= S의 i부터 끝까지의 A문자열로 이뤄져 있으면 1
		
		for(int i=S.length()-1; i>=0; i--) {
			for(int j=i+1; j<S.length(); j++) {
				if(D[j] == 1) {
					if(A.contains(S.substring(i,j))) { 
						D[i] = 1;
					}
				}
			}
			if(A.contains(S.substring(i))) { 
				D[i] = 1;
			}
		}
		System.out.println(D[0]);

	}
	
	
	
}
