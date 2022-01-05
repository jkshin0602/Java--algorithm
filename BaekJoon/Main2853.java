
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2853 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //신나는 날의 개수  N
		int[] day = new int[N];
		for(int i=0; i<N; i++) {
			day[i] = Integer.parseInt(br.readLine());
		}
		
		
		boolean check;
		int answer = 0;
		
		//1. 간격을 구해서 for문으로 배열 탐색 
		//2. 배열%간격 == 1 -> 같은배이다(간격이 같으므로)
		//3. 같은배들은 0으로 값을 변경해준다. (다시 안세도된다.)
	
		for(int i=1; i<N; i++) {
			if(day[i] == 0)  //이미 샌 배이므로 건너 뛴다. 
				continue;
			
			int inter = day[i] - day[0]; // 간격을 구한다. 
			check = false; //간격에 들어가는 것들을 체크하기 위한 변수 
			
			for(int j=1; j<N; j++) {
				if(day[j] == 0)  //이미 샌 배는 건너뛴다. 
					continue;
				
				if(day[j]%inter == 1) { // 간격으로 나눠 나머지가 1이 되면, 같은 배이다.
					check = true; // 간격에 들어가므로 체크값 변경 
					day[j] = 0; //이미 샌 것 체크 
				}
			}
			if(check)  // 한바퀴를 돌면 반드시 true이다. 
				answer++;
			
		}
		System.out.println(answer);
		
		
		
	}
	
	
}
