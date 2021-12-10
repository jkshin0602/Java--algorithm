package Cho.week_4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2491_1 {
	 
	public static int[] DI;
	public static int[] DD;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //수열의 길이	N 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		DI = new int[N];
		DI[0] = 1;
		DD = new int[N];
		DD[0] = 1;
	
		for(int i=1; i<N; i++) {
			if(A[i-1] <= A[i]) { //앞의 수열이 더 작다면 길이 1 증가 
				DI[i] = DI[i-1] + 1;
			}else { //앞의 수열이더 크다면 길이 1로 초기화(시작점)
				DI[i] = 1;
			}
			if(A[i-1] >= A[i]) {
				DD[i]= DD[i-1] + 1;
			}else {
				DD[i] = 1;
			}
		}
		
		int max1 = 0;
		for(int i=0; i<N; i++) {
			max1 = Math.max(DI[i], max1);
		}
		
		int max2 = 0;
		for(int i=0; i<N; i++) {
			max2 = Math.max(DD[i], max2);
		}

		System.out.println(Math.max(max1, max2));
		

	}
	
	
	
	

}
