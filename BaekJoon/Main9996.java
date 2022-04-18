
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main9996 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //파일의 개수 N
		
		String[] s = new String[N];
		String p = br.readLine();

		Queue<Character> q;
		// x * x 
		 
		
		for(int i=0; i<N; i++) {
			s[i] = br.readLine();
			String prefix = "";
			String suffix = "";
			int state = 0;
			for(int j=0; j<p.length(); j++) {
				if(p.charAt(j) == '*') {
					state = 1;
				}else if(p.charAt(j) != '*' && state == 0) {
					prefix += p.charAt(j);
				}else if(p.charAt(j) != '*' && state == 1) {
					suffix += p.charAt(j);
				}
			}

			s[i] = s[i].replaceFirst(prefix, "*");		
			s[i] = s[i].replace(suffix, "*");
			if(s[i].charAt(0) == '*' && s[i].charAt(s[i].length()-1) == '*') {
				System.out.println("DA");
			}else{
				System.out.println("NE");
			}
		}
		
		
	}
	
	
	
}
