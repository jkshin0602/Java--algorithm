package Cho.week_4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main1920_1 {

	public static int[] a;
	public static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		a = new int[N];
		for(int i=0; i<N; i++){
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a); //이진탐색은 정렬된 상태
		
		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++){
			int x = Integer.parseInt(st.nextToken());
			System.out.println(binary_search(x));
		}

	}
	
	public static int binary_search(int x){
		int start = 0;
		int end = N-1;
		
		while(start <= end){
			int mid = (start + end) / 2;
			if(a[mid] > x){ //mid값이 x보다 크다면 end = mid-1로 갱신
				end = mid - 1;
			}else if(a[mid] < x){ //mid값이 x보다 작다면 start = mid+1로 갱신
				start = mid+1;
			}else{ //mid값이 x랑 같을 경우 찾음
				return 1;
			}
		}
		return 0; //값을 못찾음 
		
	}
	
	

}
