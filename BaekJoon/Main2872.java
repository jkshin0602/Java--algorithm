
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2872 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		Integer[] book = new Integer[N];
		for(int i=0; i<N; i++) {
			book[i] = Integer.parseInt(br.readLine());
		}
		
		int max = N;
		
		int cnt = 0;
		for(int i=N-1; i>=0; i--) {
			if(book[i] == max) { //가장 큰 번호이면 이동할 필요가 없다. (가장 큰 번호가 걸린 경우 제대로 끝에 정렬되어있다)
				max--;
			}else { //만약 정렬이 안되어있으면 옮겨줘야 한다. 
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
	
	
}
