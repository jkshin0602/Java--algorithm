
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10988 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int len = str.length();
		int mid = 0;
		int state = 1;
		
		if(len%2 == 0) { //짝수 이면 
			mid = len/2;
			for(int i=0 ;i<mid ; i++) {
				for(int j=len-1; j>=mid; j--) {
					if(str.charAt(i) == str.charAt(j)) {
						i++;
					}else {
						state = 0;
						System.out.println(state);
						return;
					}
				}
			}
		}else { //홀수이면 
			mid = (len/2);  
			for(int i=0; i<mid; i++) {
				for(int j=len-1; j>mid; j--) {
					if(str.charAt(i) == str.charAt(j)) {
						i++;
					}else {
						state = 0;
						System.out.println(state);
						return;
					}
				}
			}
		}

		System.out.println(state);
		
		
		
		
	}
	
	
	
}
