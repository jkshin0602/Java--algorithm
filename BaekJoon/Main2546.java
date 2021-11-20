import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main2546 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); 
		for(int i=0; i<T; i++){
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //C언어 수강생 수
			int M = Integer.parseInt(st.nextToken()); //경제학 수강생 수
			long[] cIQ = new long[N];
			
			long cSum = 0;
			long eSum = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				cIQ[j] = Integer.parseInt(st.nextToken());
				cSum += cIQ[j];
			}
			st = new StringTokenizer(br.readLine());
			for(int k=0; k<M; k++){
				eSum += Integer.parseInt(st.nextToken());
			}
			
			int answer = 0;
			
			for(int j=0; j<N; j++){
				if(cSum > cIQ[j]*N && eSum < cIQ[j]*M){ 
					//c언어 IQ 평균보다 낮은 사람들 (빼면 평균 상승)
					//경제학 IQ평균보다 높은 사람(c언어 드랍시 평균IQ올려줄수 있는 사람들 중)  
					// (넣으면 평균 상승)
					answer++;
				}
			}
			
			System.out.println(answer);	
		}

	}

}
