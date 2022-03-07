import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2231 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=1_000_000; i++) {
			int sum = i;
			
			String s = i+"";
			for(int j=0; j<s.length(); j++) {
				sum += s.charAt(j) - '0';
			}
			
			if(sum == N) {
				System.out.println(i);
				System.exit(0);
			}
		}
		System.out.println(0);
		
		
	}

}
