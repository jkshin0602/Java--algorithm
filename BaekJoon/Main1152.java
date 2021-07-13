import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main1152 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine().trim();
		int cnt = 0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == ' ')
				cnt++;
		}
		
		if(s.isEmpty()){
			System.out.println("0");
		}else{
		System.out.println(cnt+1);
		}
	}

}
