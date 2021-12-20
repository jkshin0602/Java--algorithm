
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14562 {
	
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		//발차기A는 현재점수만큼 점수를 얻지만 , 상대 역시 3점을 득점 
		//발차기 B는 1점을 얻는다 
		while(C-- > 0) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken()); //태균의 점수 S 
			int T = Integer.parseInt(st.nextToken()); //상대의 점수 T 
			System.out.println(func(S,T,0));
		
		}
		
	}
	
	//1. S가 할 수 있는 경우의 수 2 개 -> (현재점수 만큼 얻고, 상대 3점주기), 1점얻기 
	//2. 1점씩 올려 어느 순간에 3점을 주고, 현재점수를 얻을 때 똑같아지면 답이된다.
	//3. 또는 현재점수를 얻고, 1점씩 올려도 답이된다. -> 여러 방법 존재 
	//4. 백트래킹을 해본다. 
	//5. 종료조건은 S가 T를 넘거나 (원하는 해가 아니므로, 다시 돌아감) or (S == T) 정답을 찾았을 때 
	
	
	public static int func(int S, int T, int cnt) {
		if(S > T) { //S가 T를 넘으면 잘못된 방법 
			return 100;
		}
		if(S == T) { //정답을 찾음 
			return cnt;
		}else { 
			int a = func(S*2, T+3, cnt+1);
			int b = func(S+1, T, cnt+1);
			//최솟값을 찾아야 하므로 
			return Math.min(a, b);
		}
		
		
	}
}
