
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19539 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	

		//가능한 높이 수 
		// 한턴에 뿌려서 성장하는 나무의 높이는 3이다.
		// 원하는 높이들의 합이 3이 되어야 된다.
		
		int N = Integer.parseInt(br.readLine()); // 사과나무 개수 
		int sum = 0;
		int odd_check = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int tmp= Integer.parseInt(st.nextToken());
			sum += tmp;
			if(tmp %2 == 1) { // 홀수의 개수 = 2로 성장 시킬수 없는 횟수 
				odd_check++;
			}
		}
		
		// 물뿌리개 2개의 물을 뿌리는 횟수는 같다. 
		// 2물뿌리개로 성장시킬수 없는 횟수가 물을 최대 뿌릴수 있는 횟수를 초과하면 -> 실패 
		
		if(sum%3 == 0 && odd_check <= sum/3) {  //원하는 높이에 맞출 수 있다.
			System.out.println("YES");
		}else { //맞출수 없다.
			System.out.println("NO");
		}
		
		
		
		
	}
	
	
}
