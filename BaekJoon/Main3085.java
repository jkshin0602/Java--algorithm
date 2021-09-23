import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main3085 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //N의 크기
		char [][] A = new char[N][N];
		for(int i=0; i<N; i++){
			String str = br.readLine();
			for(int j=0; j<N; j++ ){
				A[i][j] = str.charAt(j);
			}
		}
		
		int ans = 0;
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(j+1 < N) { //오른쪽과 교환
					//swap
					char tmp = A[i][j];
					A[i][j] = A[i][j+1];
					A[i][j+1] = tmp;
					//최대 길이 계산
					int temp = check(A);
					if(ans < temp) 
						ans = temp;
					//swap -- 인접한 한 칸만 바꾸므로 다시 계산해주기 위해 원래대로 돌려줌
					tmp = A[i][j];
					A[i][j] = A[i][j+1];
					A[i][j+1] = tmp;
				}
				if(i+1 < N){ //아래와 교환
					//swap
					char tmp = A[i][j];
					A[i][j] = A[i+1][j];
					A[i+1][j] = tmp;
					//최대 길이 계산
					int temp = check(A);
					if(ans < temp) 
						ans = temp;
					//swap
					tmp = A[i][j];
					A[i][j] = A[i+1][j];
					A[i+1][j] = tmp;
				}
			}
		}
		System.out.println(ans);
	}
	
	public static int check(char[][] A){
		int n = A.length;
		int ans = 1;
		for(int i=0; i<n; i++){
			int cnt = 1; //처음 길이는 1로 시작
			for(int j=1; j<n; j++){ // i행의 최대 길이 계산 (j=1 부터 시작)
				if(A[i][j] == A[i][j-1]){ //만약 사탕의 색이 같다면(연속이면)
					cnt += 1; //길이 1 증가
				}else{
					cnt = 1; //아니면 다시 길이 1부터 시작
				}
				if(ans < cnt) 
					ans = cnt; //만약 정답보다 크다면 제일 긴 길이므로 갱신
			}
			cnt = 1;
			for(int j=1; j<n; j++){ // i열의 최대 길이 계산 (j=1 부터 시작)
				if(A[j][i] == A[j-1][i]){ //만약 사탕의 색이 같다면(연속이면)
					cnt += 1; //길이 1 증가
				}else{
					cnt = 1; //아니면 다시 길이 1부터 시작
				}
				if(ans < cnt) 
					ans = cnt; //만약 정답보다 크다면 제일 긴 길이므로 갱신
			}
		}
		return ans;
	}

}
