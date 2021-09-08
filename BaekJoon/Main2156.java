import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main2156 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //포도잔의 개수 N
		int[] D = new int[N+1];
		int[] A = new int[N+1];  //포도주의 양 
		
		for(int i=1; i<=N; i++){
			A[i] = Integer.parseInt(br.readLine()); // 포도주의 양 입력받음
		}
		
		//점화식
		//경우의 수  1. oox , 2. oxo , 3. xoo
		//1. D[i] = D[i-1]
		//2. D[i] = D[i-2] + A[i] 
		//3. D[i] = D[i-3] + A[i-1] + A[i]
		//D[i] = max(D[i-1], D[i-2] + A[i] , D[i-3] + A[i-1] + A[i])
		// i = 3부터 시작하기 떄문에 , N = 1, 2, 3 이 입력됬을 때의 조건 처리를 해준다.
		
		if(N >= 1){ //잔이 1개일 경우
			D[1] = A[1];
		}
		
		if(N >=2){ //잔이 2개일 경우
			D[2] = A[1] + A[2];
		}
		
		if(N>=3){ //잔이 3개일 경우
			D[3] = Math.max(D[2], Math.max(D[1] + A[2],  A[1] + A[2])); //D[i-3]은 존재하지않음(총 잔이 3잔밖에 없다)
		}
		
		for(int i=3; i<=N; i++){
			D[i] = Math.max(D[i-1], Math.max(D[i-2] + A[i], D[i-3] + A[i-1] + A[i]));
		}

		int ans = 0;
		for(int i=1; i<= N; i++){
			if(ans < D[i]){
				ans = D[i];
			}
		}
		System.out.println(ans);
		
	}

}
