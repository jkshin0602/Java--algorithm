
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10808 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		int[] alpha = new int[26];
		
		for(int i=0; i<S.length(); i++) {
			alpha[S.charAt(i)-'a']++;
		}
		
		for(int i=0; i<26; i++) {
			System.out.print(alpha[i]+" ");
		}
	

		
		
	}
	
	
	
}
