import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main1333 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //노래 곡수
		int L = Integer.parseInt(st.nextToken()); //노래 초 
		int D = Integer.parseInt(st.nextToken()); //전화벨 D초에 1번씩 울림, 1초동안 울림

		int[] time = new int[5000];
		int sec = 0 ;
		for(int i=0; i<N; i++){
			
			for(int j=0; j<L; j++){
				time[sec++] = 1;
			}	
			sec += 5;
		}
		sec = 0;
		while(true){
			
			if(time[sec] == 0){
				System.out.println(sec);
				break;
			}
			sec += D;
		}
		
	}

}
