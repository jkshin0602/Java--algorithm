import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main15651 {
	
	public static int N, M;
	public static int[] selected; 
	public static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 1~N 까지4
		M = Integer.parseInt(st.nextToken()); // M개를 고른 수열 
		selected = new int[M+1]; //결과 수열
		rec_func(1);
		System.out.println(sb.toString());
		
		
	}
	
	public static void rec_func(int k){
		if(k == M + 1){ //다 골랐을때
			//selected[1...M] 배열이 새롭게 탐색된 결과
			for(int i=1;i <=M; i++) {
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
		}else{
			// 1~N 까지를 k번 원소로 한번씩 정하고
			// 매번 k+1 번부터 M번 원소로 재귀호출 해주기
			for(int cand = 1; cand <= N; cand++){
				selected[k] = cand;
				//k+1 번 ~ M번을 모두 탐색하는 일을 해야하는 상황
				rec_func(k+1);
				selected[k] = 0; 
			}
		}
	}
	
	

}
