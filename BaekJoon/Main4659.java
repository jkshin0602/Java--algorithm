
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4659 {


	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s = br.readLine();
			if(s.equals("end")) {
				break;
			}
			
			if(check1(s) && check2(s) && check3(s)) {
				System.out.println("<" + s + "> is acceptable." );
			}else {
				System.out.println("<" + s + "> is not acceptable." );
			}
		
		}
	}
	
	//65, 70, 74, 80, 86
	public static boolean check1(String s) {
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == 'a' || s.charAt(i) == 'e'|| s.charAt(i) == 'i'|| s.charAt(i) == 'o'|| s.charAt(i) == 'u') {
				return true;
			}
		}
		return false;
	}
	
	public static boolean check2(String s) {
		
		int state1 = 0;
		int state2 = 0;
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == 'a' || s.charAt(i) == 'e'|| s.charAt(i) == 'i'|| s.charAt(i) == 'o'|| s.charAt(i) == 'u') {
				state1++;
				state2 = 0;
			}else {
				state2++;
				state1 = 0;
			}
			if(state1 == 3 || state2 == 3) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean check3(String s) {
		
		char c = s.charAt(0);
		int state = 0;
		for(int i=1; i<s.length(); i++) {
			if(c == s.charAt(i)) {
				if(s.charAt(i) == 'e' || s.charAt(i) == 'o') {
					if(state == 1) {
						return false;
					}
					state++;
					continue;
				}
				return false;
			}
			state = 0;
			c = s.charAt(i);
		}
		return true;
	}
	
	
}
