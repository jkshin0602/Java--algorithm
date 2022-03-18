
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2979 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()); // 한대 주차시 1분에 A원
		int B = Integer.parseInt(st.nextToken()); // 두대 주차시 1분에 B원 
		int C = Integer.parseInt(st.nextToken()); // 세대 주차시 1분에 C원
		
		int[] time = new int[101];
		
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			for(int j=s; j<e; j++) {
				time[j]++;
			}
		}
		
		int sum = 0;
		for(int i=1; i<101; i++) {
			if(time[i] == 1) {
				sum += A;
			}else if(time[i] == 2) {
				sum += B*2;
			}else if(time[i] == 3) {
				sum += C*3;
			}
		}
		System.out.println(sum);


		
		
	}
	
	
	
}
