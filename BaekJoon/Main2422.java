package Cho.week_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main2422 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //아이스크림의 종류
		int M = Integer.parseInt(st.nextToken()); //섞어먹으면 안되는 조합의 개수
		
		boolean[][] notComb = new boolean[N+1][N+1];
		
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//조합을 boolean배열 양쪽에 저장해준다.
			notComb[a][b] = true;
			notComb[b][a] = true;
		}
		int answer = 0;
		//3종류의 아이스크림을 고르므로 3중 for문 사용
		for(int i=1; i<N-1; i++){
			for(int j=i+1; j<N; j++){
				for(int k=j+1; k<N+1; k++){
					//모든 경우를 검사 
					if(notComb[i][j] || notComb[i][k] || notComb[j][k] || notComb[j][i] || notComb[k][i] || notComb[k][j]){
						continue;
					}
					answer++;
				}
			}
		}
		System.out.println(answer);
		

	}

}
