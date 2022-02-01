
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11655 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		for(int i=0; i<S.length(); i++) {
			System.out.print(rot13(S.charAt(i)));
		}
		
	}
	
	public static char rot13(char c) {
		// A = 65, Z = 90 
		//만약 Z를 넘어가면 c - 'Z' + 'A' - 1
		if(c >= 65 && c<=90) {
			c +=13; 
			if(c > 90) {
				c -= 26;
			}	
		}else if(c>= 97 && c<=122) {
			c +=13; 
			if(c > 122) {
				c -= 26;
			}	
		}

		return c;
	}
	
	
}
