package Cho.week_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main3273 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //수열의 갯수
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		int X = Integer.parseInt(br.readLine()); //쌍의 합 
		
		int cnt = 0;
		//1 2 3 5 7 9 10 11 12
		for(int i=0; i<N-1; i++){
			int a = X - num[i]; // X - num[i]값을 구한 후
			for(int j=i+1; j<N; j++){
				if(a == num[j]){ //num[i] 이후의 수열을 탐색, a값과 같으면 num[i]와 쌍 성립
					cnt ++;
					break;
				}
			}
		}
		System.out.println(cnt);
		
	}

}
