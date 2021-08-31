import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14002 {
	public static StringBuilder sb = new StringBuilder();
	public static int[] V = new int[1001]; // 출력 수열
	public static int[] A = new int[1001]; // 입력 수열
	public static int[] D = new int[1001]; // 길이

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <=N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		// LIS(증가수열)
		for (int i = 1; i <=N; i++) {
			D[i] = 1;// D[i]의 초기 길이는 1이다.
			for (int j = 1; j <= i; j++) { // i번 수열까지 비교
				if (A[i] > A[j] && D[i] < D[j] + 1) { // j의 조건은 A[j] < A[i]이다.
					// 앞에있는 수가 더 작으면서, 길이가 더 길다면, 길이를 정보 D[i]를 새로 변경해준다.
					D[i] = D[j] + 1;
					V[i] = j; //값이 변하면 j 인덱스로 인해 변한것 이므로 j인덱스를 기록해준다.
				}
			}
		}
		
		int ans = -1;
		int index = 0;
		for(int i=1; i<=N; i++){
			if(ans < D[i]){
				ans = D[i];
				index = i; //D[i]의 인덱스 값을 저장
			}
		}
		sb.append(ans).append("\n");
		go(index);
		System.out.println(sb);

	}
	
	public static void go(int p){
		if(p == 0){ //p=0이면 첫번째 수이거나,  증가수열이 아닌것
			return;
		}
		go(V[p]); //a[p]의 앞에 수는 A[V[p]]로 구할 수 있다. A[p]의값은 A[V[P]]로 인해 생긴것이기 때문에.
		sb.append(A[p]).append(' ');
	}
}
