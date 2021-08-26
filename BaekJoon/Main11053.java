import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main11053 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //수열 A의 크기
		int[] A = new int[N];
		long[] D = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = 0;
		while(st.hasMoreTokens()){
			A[a] = Integer.parseInt(st.nextToken());
			a++;
		}
		//점화식
		//D[i] = max(D[j]+1, D[i])  -> D[i]랑 비교해서 현재길이 (1) 보다 크면 그 값을 대입 
	
		//10 20 10 30 20 50 이 입력되었을 때
		//1번 과정 : 10 (수열 최대길이 :1) i == 0
		//2번과정 : 20 (수열 최대길이 : 1) i == 1, 2번째 수열이 1번째 수열보다 크므로 if조건 성립 
		//D[i] = 1-> 1+1 로 수정 : (수열 최대길이 : 2)
		//3번과정 : 10 (수열 최대길이 : 1) , 전번째 값 20보다 작으므로 ,  if조건 성립 x (수열 길이 1 유지)
		//4번과정 : 30 (수열 길이 1), 전번째 값들중 D[1]에 저장되어있는 수열의 길이 2이다. 
		//30은 시퀀스A[1] 에있는 수열값보다 크고, 현재 수열길이(1)보다, D[1] 의 수열길이(2)가 더 크므로 
		//if조건 성립 : 1 -> 2+1로 수정 : (수열 최대길이 : 3)
		//... 수열 끝까지 반복한 후,
		//마지막 50 시퀀스에서 30이 저장되어있는 수열 4번째의 최대길이가 저장되어있는 곳, 즉(D[3])이 가장 길다.
		//D[5] = D[3] +1 = 3+1 = 4로 저장 (최대길이)
		//하지만 제일 큰값이 마지막 원소로 들어가있지 않을 수도 있기 때문에
		//for문을 돌려 D[i]값중 최대 길이를 정답으로 출력 
		
		//모든 수를 비교한다.
		for(int i=0; i<N; i++){
			D[i] = 1; //D[i]의 초기 길이는 1이다.
			for(int j=0; j<i; j++){ //i번 수열까지 비교
				if(A[j]< A[i] && D[i] < D[j]+1){ //j의 조건은 A[j] < A[i]이다.
					//앞에있는 수가 더 작으면서, 길이가 더 길다면, 길이를 정보 D[i]를 새로 변경해준다.
					D[i] = D[j] + 1; 
				}
			}
		}
		
		int max = -1;
		for(int i=0; i<N; i++){
			max = (int) Math.max(max, D[i]);
		}
		System.out.println(max);
		
	}

}
