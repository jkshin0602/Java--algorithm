
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main18238 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String zoac = br.readLine();
		
		int time = 0;
		char s = 'A'; 
		// 1. 아스키코드를 사용해 풀이 
		// 2. 오른쪽으로 돌리는 횟수 = abs(가야되는 위치 - 현재위치)
		// 3. 왼쪽으로 돌리는 횟수 = 26 - 오른쪽으로 돌리는 횟수 
		// 4. 둘의 값을 비교해 최솟값을 더해주면 된다. 

		for(int i=0; i<zoac.length(); i++) {
			char tmp = zoac.charAt(i);
			int a = Math.abs(tmp - s); //오른쪽으로 돌리는 횟수 
			time += Math.min(a, 26 - a); // 오른쪽으로 돌리는 횟수 vs 왼쪽으로 돌리는 횟수 
			s = tmp;
		}
		System.out.println(time);
		
	}
	
	
}
