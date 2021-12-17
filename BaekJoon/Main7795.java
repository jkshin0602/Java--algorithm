
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main7795 {
	
	static int N, M;
	static int[] A, B;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //A원소의 개수 
			M = Integer.parseInt(st.nextToken()); //B원소의 개수 
			st = new StringTokenizer(br.readLine());
			A = new int[N];
			for(int i=0; i<N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			B = new int[M];
			for(int i=0; i<M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(B);
			
			int ans = 0;
			for(int i=0; i<N; i++) {
				ans += binary_search(A[i]);
			}
			System.out.println(ans);
		}
		
	}
	
	
	//A의 모든 원소에 대해서 모든 B원소를 비교해 각 A>B 의 관계의 쌍을 찾아낸다. 
	//Binary Search로 범위를 줄여나가면서 계산한다.
	public static int binary_search(int x) {
		int left = 0, right = M-1;
		int idx = -1;
		while(left <= right){
			int mid = (left + right) / 2;
			if(B[mid] < x) { //B[mid]가 A[i]보다 작으면 
				idx = mid; // 범위를 올린다.
				left = mid + 1;
			}else { //크면 범위가 맞지 않으니 줄인다.
				right = mid -1;
			}
		}
		return idx + 1;
		
	}

}

