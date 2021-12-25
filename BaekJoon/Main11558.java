
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11558 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			boolean[] check = new boolean[N+1];
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			
			int next = 1,K = 0, state = 0;
			//다음사람지목,불러야하는 정수, 무한루프 탐색 
			while(true) {
				if(arr[next] == N) { //무한루프가 걸린다고해도 그 안에 타겟이 있기때문에 상관 없다.
					K++;
					break;
				}
				if(check[arr[next]] == true) {  //만약 왔던곳에 또오면 무한루프가 걸리기 때문에, 타겟으로 못간다. 
					state = 1;
					break;
				}else { //만약 처음온 곳이라면 
					next = arr[next]; //다음사람 지목 
					check[next] = true; //방문 체크 
					K++;
				}
				
			}
			if(state == 1) System.out.println(0);
			else System.out.println(K);
		}
	}
}
