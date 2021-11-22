
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1032 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //파일의 개수
		String[] file = new String[N];
		
		for(int i=0; i<N; i++){
			file[i] =  br.readLine();
		}
		
		int len = file[0].length();
		boolean[] chk = new boolean[len];
		for(int i=0; i<len; i++){
			chk[i] = true;
		}

		for(int i=0; i<len; i++){ //모두 비교
			
			char c = 0;
			for(int j=0; j<N; j++){
				char a = file[j].charAt(i);
				
				if(j == 0){
					c = a;
					continue;
				}
				if(!chk[i] && j > 0){ //true = 
					break; 
				}
				if(a == c){
					chk[i] = true;
				}else{
					chk[i] = false;
				}
				c = a;
			}
		}
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<len; i++){
			if(chk[i]){
				sb.append(file[0].charAt(i));
			}else{
				sb.append("?");
			}
		}
		System.out.println(sb);
		
		
	}
	
	
}
