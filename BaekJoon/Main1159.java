
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1159 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); //선수 수 N
		String [] p = new String[N];
		int[] a = new int[26];
		
		
		for(int i=0; i<N; i++) {
			p[i] = br.readLine();
			a[p[i].charAt(0)-'a']++;
		}
		
		int state = 0;
		
		for(int i=0; i<26; i++) {
			if(a[i] >= 5) {
				state = 1;
				char c = (char) (i+'a');
				System.out.print(c);
			}
		}
		if(state == 0) {
			System.out.println("PREDAJA");
		}
		
		
	}
	
	
	
}
