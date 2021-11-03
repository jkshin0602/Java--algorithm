import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main2798 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 카드의 개수
		int M = Integer.parseInt(st.nextToken()); // 카드의 합 
		
		st = new StringTokenizer(br.readLine());  // 카드 숫자 입력
		int[] card = new int[N];
		
		for(int i=0; i<N; i++){
			card[i] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		first:for(int i=0; i<N-2; i++){
			for(int j=i+1; j<N-1; j++){
				for(int k =j+1; k<N; k++){
					int temp = card[i] + card[j] + card[k];
					if(temp == M){
						result = temp;
						break first;
					}
					if(result < temp && temp < M){
						result = temp;
					}
				}
			}
		}
		System.out.println(result);

	}

}
