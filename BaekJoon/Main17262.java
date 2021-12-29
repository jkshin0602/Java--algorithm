
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17262 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 팬수 N 
		
		//전체 학생의 시간 중 제일 빠른 등교 시간 start, 제일 느린 하교 시간 finish를 구해서 빼준다.
		//start < finish일 경우 시간이 겹치므로 0시간 머무른다.
		
		int start = -1; 
		int finish = 100001;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if(s > start) {  // 팬의 시작 시간 갱신 
				start = s;
			}
			
			if(e < finish) { //팬의 끝나는 시간 갱신 
				finish = e;
			}
			
		}
		
		int answer = start - finish;
		
		if(answer < 0) { //음수일경우 학생들이 모두 시간이 겹친다 
			System.out.println(0);
		}else {
			System.out.println(answer);
		}
		
		
	}
}
