
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17204 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //참여하는 사람의 수 N
		int K = Integer.parseInt(st.nextToken()); //보성이의 번호 K
		
		int[] arr = new int[N];
		boolean[] check = new boolean[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//무한루프를 돌지 않으면 된다.  
		//보성이의 번호가 포함되는 무한루프는 보성이의 번호에서 걸려서 종료된다.
		//보성이의 번호가 포함되지 않는 무한루프는 보성이 번호를 가지 못하기 때문에 무한반복 
		
		int next = 0, cnt=0;
		while(true) {
			if(arr[next] ==K) {
				cnt++;
				break;
			}
			if(check[arr[next]]) { //만약 이미 지목당한사람이 또 지목당하면 (무한루프) 
				System.out.println(-1);
				System.exit(0);
			}
			else {
				next = arr[next]; //다음 사람으로 이동 
				check[next] = true; //방문 저장
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
}
