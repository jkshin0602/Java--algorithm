import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(int i=0; i<croatia.length; i++){
			s = s.replace(croatia[i], "c");
		}
		
		System.out.println(s.length());
		
	}

}