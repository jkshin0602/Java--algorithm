import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main9012 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(bf.readLine());
		
		for(int i=0; i<T; i++){
			int cnt = 0;
			String str = bf.readLine();
			
			str.trim();
			for(int j=0; j<str.length();j++){
				if(cnt<0){
					break;
				}
				if(str.charAt(j) == '('){
					cnt++;
				}else if(str.charAt(j) == ')'){
					cnt--;
				}
			}
			
			if(cnt == 0){
				bw.write("YES"+"\n");
			}else{
				bw.write("NO"+"\n");
			}
		}
		bf.close();
		bw.flush();
		bw.close();
	}

}
