
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9012_1 {


	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Stack<Character> s;
		while(T-- > 0) {
			boolean state = true;
			s = new Stack<Character>();
			String str = br.readLine();
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == '(') {
					s.push(str.charAt(i));
				}else {
					if(s.size() != 0) s.pop();
					else {
						state = false;
					}
				}
			}
			
			if(s.size() == 0 && state) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
	
	
	
	
	
	
}
