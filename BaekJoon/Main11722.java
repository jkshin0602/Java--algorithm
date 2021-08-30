
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main11722 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //수열 A의 크기
		int[] A = new int[N+1];
		int[] D = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = 0;
		while(st.hasMoreTokens()){
			A[a] = Integer.parseInt(st.nextToken());
			a++;
		}
		//점화식
		//D[i] = max(D[j]+1, D[i])  -> D[i]랑 비교해서 현재길이 (1) 보다 크면 그 값을 대입  (A[j] > A[i])
		//뒤로 갈수록 더 작아져야 한다.
	
		//10 30 10 20 20 10 이 입력되었을 때
		//1번과정 : 10	i == 0
		//2번과정 : 30  i == 1
		//3번과정 : 10  전번째 값 30보다 작으므로 조건성립 최대길이 1-> 2로 수정 i=2
		//4번과정 : 20  큰값 30이 있으므로 수열 길이 2로 수정 i=3
		//5번과정 : 20  큰값 30이 있으므로 수열 길이 2로 수정 i=4
		//6벉과정 : 10  큰값 30,20중에 최대길이를 가지는 20번째의 값 +1 , 30,20,10 순서로 되기 때문, 즉 최대길이 3
		//하지만 제일 큰값이 마지막 원소로 들어가있지 않을 수도 있기 때문에
		//for문을 돌려 D[i]값중 최대 길이를 정답으로 출력 
		
		//모든 수를 비교한다.
		for(int i=0; i<N; i++){
			D[i] = 1; //D[i]의 초기 길이는 1이다.
			for(int j=0; j<i; j++){ //i번 수열까지 비교
				if(A[j]> A[i] && D[i] < D[j]+1){ //j의 조건은 A[j] > A[i]이다. (뒤에수열이 더 작야아 한다.)
					//뒤에있는 수가 더 작으면서, 길이가 더 길다면, 길이를 정보 D[i]를 새로 변경해준다.
					D[i] = D[j] + 1; 
				}
			}
		}
		
		int max = D[0];
		for(int i=1; i<N; i++){
			max = (int) Math.max(max, D[i]);
		}
		System.out.println(max);
		
	}

}
