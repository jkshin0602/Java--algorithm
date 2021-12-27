
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main5545 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //토핑의 종류수 N
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()); // 도우의 가격 A
		int B = Integer.parseInt(st.nextToken()); // 토핑의 가격 B
		int C = Integer.parseInt(br.readLine()); // 도우의 열량 C 
		Integer[] D = new Integer[N]; //토핑의 열량 
		for(int i=0; i<N; i++) {
			D[i] = Integer.parseInt(br.readLine());
		}
		
		//최고의 피자 = 열량이 가장 높은 피자 
		//A + D(선택한갯수) * B = 합친돈 
		//C + D = 열량 
		// 열량 / 합친돈 이 가장 큰 것 
		// 열량은 높고 , 선택한 갯수가 낮아야 한다.
		
		Arrays.sort(D, Collections.reverseOrder()); //칼로리가 높은순으로 정렬 
		
		//토핑이 0개일 시, 칼로리당 가격 
		int ans = C/A; 
		
		int price = A;
		int kcal = C; 
		for(int i=0; i<N; i++) {
			price += B; //토핑의 가격을 더함 
			kcal += D[i];  //토핑의 칼로리를 더함 
			int tmp = kcal/price;
			if(ans > tmp) { //칼로리당가격이 낮아지면 종료 ans가 답 )
				break;
			}else {
				ans = tmp;
			}
		}
		
		System.out.println(ans);
		
	}
}
