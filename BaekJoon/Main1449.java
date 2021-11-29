package Cho.week_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main1449 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물 새는 곳의 개수 N
		int L = Integer.parseInt(st.nextToken()); // 테이프의 길이 L
		int[] water = new int[N]; //물 새는 위치
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			water[i] = Integer.parseInt(st.nextToken()); //물이 새는 위치
		}
		Arrays.sort(water);
		
		// 테이프를 붙일 때 좌우 0.5씩 최소 1cm를 붙이고, 테이프는 겹칠수 있다.
		//1. 물이 새는 두 곳의 길이 + 1이 테이프 길이보다 작을 때 ->다음 구멍까지 검사
		//2. 물이 새는 두 곳의 길이 + 1이 테이프 길이보다 클 때 -> 그 구멍까지 검사 
		int cnt = 0; 
		
		for(int i=0; i<N; i++){
			if(i == N-1){ //마지막 원소
				cnt++;
				break; 
			}
			
			int idx = water[i++];
			while(N > i){
				if(water[i] - idx +1 <= L){ //1번 경우
					i++; //다음 구멍까지 커버되는지 검사
				}else{ //2번 경우
					break;
				}
			}  //여기 반복문을 빠져 나온것은 테이프길이가 부족한것이다.
			cnt++;
			i--;  //이전것과의 차이를 검사하기 위해 i를 1줄여준다.
			
			
		}
		System.out.println(cnt);
		
		
	}

}
