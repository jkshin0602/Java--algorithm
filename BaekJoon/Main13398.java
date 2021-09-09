import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main13398 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //수열의 길이 N
		int[] A = new int[N]; //수열 A 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] DL = new int[N]; //i번째 수에서 끝나는 수열의 최대 연속합
		int[] DR = new int[N]; //i번째 수에서 시작하는 수열의 최대 연속합
		
		for(int i=0; i<N; i++){ //i번째 수에서 끝나는 수열의 최대 연속합 구하기
			DL[i] = A[i]; //연속하지 않은 경우(자기 자신이 최대값)
			if(i == 0) continue; 
			if(DL[i] < DL[i-1] + A[i]){ // 뒤의 값이랑 연속하면서, 합이 더 큰경우
				DL[i] = DL[i-1] + A[i]; //자신의 값보다 이전까지의 최대합이 더 큰경우 갱신
			}
		}
		for(int i=N-1; i>=0; i--){ //i번째 수에서 시작하는 수열의 최대 연속합 구하기
			DR[i] = A[i];   //연속하지 않은 경우(자기 자신이 최대값)
			if(i == N-1) continue;
			if(DR[i] < DR[i+1] + A[i]){ //앞의 값이랑 연속하면서, 합이 더 큰경우
				DR[i] = DR[i+1] + A[i]; //자신의 값보다 앞의 수열과의 최대합이 더 큰경우 갱신
			}
		}
		
		int ans = DL[0];
		for(int i=1; i<N; i++){
			if(ans <DL[i]){
				ans  = DL[i];
			}
		}
		for(int i=1; i<N-1; i++){ //어떤 수를 제거하고 구한 수열이 더 클 수도 있기 떄문에
			if(ans < DL[i-1] + DR[i+1]){
				ans = DL[i-1] + DR[i+1];
			}
		}
		System.out.println(ans);
		
			
	}

}
