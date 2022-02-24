
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1436 {


	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i=666;;i++) {
			String s = i+"";
			if(s.contains("666")) {
				N--;
			}
			if(N == 0) {
				System.out.println(i);
				break;
			}
		}
		
	}
	
	
	

	
	
}
