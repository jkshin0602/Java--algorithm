import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main1107 {
	
	public static boolean[] broken = new boolean[10]; //버튼이 고장나 있으면 true, 아니면 false
	
	public static int possible(int c){ //C에 포함되어 있는 숫자 중에서 고장난 버튼이 있는지 검사
		if(c == 0){ //예외처리 1 : 채널 0번
			if(broken[0]){ 
				return 0;
			}else{
				return 1;
			}
		}
		
		int len = 0; //숫자의 길이
		while(c > 0){
			if(broken[c%10]){ //마지막 자리가 고장났는지 확인 
				return 0; //고장났으면 0을 리턴 (누르기 불가)
			}
			len += 1; //길이를 늘려줌
			c /= 10; //10씩 나눠줌 
		}
		return len;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //이동할 채널 N 
		int M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수 M
		
		if(M != 0){
			StringTokenizer st = new StringTokenizer(br.readLine()); //고장난 버튼 입력
			
			for(int i=0; i<M; i++){
				int X = Integer.parseInt(st.nextToken());
				broken[X] = true; //고장난 버튼 세팅
			}
		}
		
		//예외처리 2 (숫자버튼 안누르고 +,- 버튼만 누를 경우)
		int ans = N - 100;  //숫자 버튼을 안누르는 경우 (초기값 세팅)
		if(ans < 0){
			ans = -ans;
		}
		
		for(int i=0; i<=1_000_000; i++){
			int C = i; //이동할 채널 C를 정함
			int len = possible(C);
			if(len > 0){ //고장난 버튼이 포함되어 있지 않다면 C-N 계산 (+나 -버튼을 몇번 눌러야 하는지 계산)
				int press = C - N; 
				if(press < 0){
					press = -press;
				}
				if(ans > len + press){
					ans = len + press;
				}
			}
		}
		System.out.println(ans);
	}

}
