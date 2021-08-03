import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main10953 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));	
		int T = Integer.parseInt(bf.readLine());
		String[] str = new String[T];
	
		
		for(int i=0; i<T; i++){
			str[i] = bf.readLine();
		}
		
		for(int i=0; i<T; i++){
			StringTokenizer st = new StringTokenizer(str[i],",",false);
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			System.out.println(A+B);
		}
		
	}

}
