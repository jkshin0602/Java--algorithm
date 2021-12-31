
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17615 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); 
		String ball = br.readLine();
		
		int red = 0;
		int blue = 0;
		// 1. 빨간 공과 파란 공의 개수를 세준다. 
		for(int i=0; i<N; i++) {
			if(ball.charAt(i) == 'R') {
				red++;
			}else{
				blue++;
			}
		}
		int min = Integer.MAX_VALUE;

		// 2. 경우의 수는 4가지가 있다.
		// 2-1. 빨강을 왼쪽, 오른쪽으로 다 넘기기 
		// 2-2. 파랑을 왼쪽, 오른쪽으로 다 넘기기 
		// 3. 넘겨야 하는 갯수는 어떤 색의 갯수에서 가장 끝에있는 갯수만 빼주면 된다.
		// 4. 가장 끝에 있는 갯수를 연속해서 세준다. 
		// 5. 모든 경우의 수에서 나온 가장 적은 이동횟수를 가진 것이 
		int a = 0;
		for(int i=0; i<N; i++) {
			if(ball.charAt(i) == 'R') {
				a++;
			}else {
				break;
			}
		}
		min = red - a;
		
		a = 0;
		for(int i=N-1; i>=0; i--) {
			if(ball.charAt(i) == 'R') {
				a++;
			}else {
				break;
			}
		}
		min = Math.min(min, red-a);
		
		a = 0;
		for(int i=0; i<N; i++) {
			if(ball.charAt(i) == 'B') {
				a++;
			}else {
				break;
			}
		}
		min = Math.min(min, blue-a);
		
		a = 0;
		for(int i=N-1; i>=0; i--) {
			if(ball.charAt(i) == 'B') {
				a++;
			}else {
				break;
			}
		}
		min = Math.min(min, blue-a);
		
		System.out.println(min);
	}
}
