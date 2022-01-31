
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10988_1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();	
		StringBuffer sb = new StringBuffer(str);	
		String tmp = sb.reverse().toString();

		if(str.equals(tmp)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}
	
	
	
}
