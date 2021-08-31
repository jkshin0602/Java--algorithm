
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main11054 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //수열 A의 크기
		int[] A = new int[N];
		int[] D = new int[N];
		int[] D2 = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = 0;
		while(st.hasMoreTokens()){
			A[a] = Integer.parseInt(st.nextToken());
			a++;
		}
		//점화식
		//D[i] = max(D[j]+1, D[i])  -> D[i]랑 비교해서 현재길이 (1) 보다 크면 그 값을 대입 
		//D2[i] = max(D[j]+1, D[i]) 
		//ans = D[i] + D2[i] - 1;  (기준점이 공통으로 들어가있기 때문에 길이 -1을 해준다.
		
		
		//LIS(증가수열)
		for(int i=0; i<N; i++){
			D[i] = 1; //D[i]의 초기 길이는 1이다.
			for(int j=0; j<i; j++){ //i번 수열까지 비교
				if(A[j]< A[i] && D[i] < D[j]+1){ //j의 조건은 A[j] < A[i]이다.
					//앞에있는 수가 더 작으면서, 길이가 더 길다면, 길이를 정보 D[i]를 새로 변경해준다.
					D[i] = D[j] + 1; 
				}
			}
		}
	
		//감소수열
		for(int i=N-1; i>=0; i--){ 
			D2[i] = 1; //D[i]의 초기 길이는 1이다.
			for(int j=i+1; j<N; j++){ //i번 수열 뒤값을 검사한다.
				if(A[j] < A[i] && D2[j]+1 > D2[i]){ //j의 조건은 A[j] < A[i]이다. 뒤에있는값(j)가 더 작아야한다.
					//앞에있는 수가 더 크면서, 길이가 더 길다면, 길이정보 갱신
					D2[i] = D2[j] + 1;
				}
			}
		}

		
		//합치기
		int ans = 0;
		for(int i=0; i<N; i++){
			if(ans < D[i] + D2[i]-1){
				ans = D[i] + D2[i]-1;
			}
		}
		System.out.println(ans);
		
	}

}
