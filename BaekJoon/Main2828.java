
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2828 {


	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1. 바구니 안에 떨어짐
		// 2. target ~~~~ 바구니 인상태 
		// 3. 바구니 ~~~~ target 인상태 
		
		int N = Integer.parseInt(st.nextToken()); //스크린 N 칸 
		int M = Integer.parseInt(st.nextToken()); //스크린을 차지하는 바구니의 크기 M칸 
		int J = Integer.parseInt(br.readLine()); //사과가 떨어지는 개수 J개
		
		int cur = 1; //현재 위치 
		int r = 0; //바구니 범위
		int tmp = 0;
		int ans = 0;
		for(int i=0; i<J; i++) {
			r = cur + M - 1; 
			tmp = Integer.parseInt(br.readLine()); //사과의 위치 
			if(tmp >= cur && tmp <=r) continue; //사과가 떨어지는 위치가 이동을 안해도 바구니에 들어갈 시 
			else {
				if(tmp < cur) { // 바구니의 위치가 tmp보다 앞에 있으면  (tmp,....,바구니)
					ans += (cur - tmp); //현재위치 ->사과의 위치 까지 이동 
					cur = tmp; //사과를 받은 위치가 현재위치가 된다.
				}else { //바구니의 위치가 tmp보다 뒤에 있으면 (바구니,....,tmp) 
					cur += (tmp - r); // 사과의위치 - 바구니범위 = 사과를 받으러 이동하는 거리
					ans += (tmp - r);
				}
			}
		}
		System.out.println(ans);
		
		
	}
	
	
	
	
	
}
