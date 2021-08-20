import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main1463 {
	
	public static int[] d; //연산 횟수를 담을 메모리제이션

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		d = new int[N+1];
		System.out.println(go(N));
		br.close();
	}
	//Top-down 방식 (재귀)
	public static int go(int n){
		
		if(n == 1) return 0; //함수 종료 코드
		
		if(d[n] > 0) return d[n]; //0보다 크다면 값이 메모되어 있다는 의미이므로 그값을 리턴해줌
		
		d[n] = go(n-1) + 1; //n-1 의 횟수이다.
		
		if(n%2 == 0){ //2로 나누어 떨어지는 부분 의 횟수
			int temp = go(n/2) + 1;
			if(d[n] > temp) d[n] = temp; //기존의 d[n]값이 더 크면 새로구한 temp의 값이 최소이므로 넣어줌
		}
		
		if(n%3 == 0){ //3로 나누어 떨어지는 부분 의 횟수
			int temp = go(n/3) + 1;
			if(d[n] > temp) d[n] = temp; //기존의 d[n]값이 더 크면 새로구한 temp의 값이 최소이므로 넣어줌
		}
		return d[n];
	}
	
	//Bottom-up 방식 (반복문)
	public static int go1(int n){
		d[1] = 0;
		for(int i=2; i<=n; i++){
			d[i] = d[i-1] + 1;//n-1 의 횟수이다.
			if(i%2 == 0 && d[i] > d[i/2] + 1){ //2로 나누어 떨어지는 부분 의 횟수
				d[i] = d[i/2] + 1; //기존의 d[i]값이 더 크면 새로구한값을 넣어줌
			}
			if(i%3 == 0 && d[i] > d[i/3] + 1){//3로 나누어 떨어지는 부분 의 횟수
				d[i] = d[i/3] + 1;//기존의 d[i]값이 더 크면 새로구한값을 넣어줌
			}
		}
		return d[n];
	}
	

}
