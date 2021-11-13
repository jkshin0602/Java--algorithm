import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main1268 {
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //학생 수
		
		int[][] leader = new int[N][5];
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++){
				leader[i][j] = Integer.parseInt(st.nextToken());
			}
 		}
		

		boolean[][] check = new boolean[N][N]; //중복 체크를 방지하기위한 boolean
		
		for(int i=0; i<5; i++){
			for(int j=0; j<N; j++){
				for(int k=0; k<N; k++){
					if(j == k) continue;
					if(leader[j][i] == leader[k][i]){
						check[j][k] = true;
					}
				}
			}
		}
	
		int[] count = new int[N];
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(check[j][i]){ //true의 개수를 세어줌 
					count[i]++;
				}
			}
		}
		
		int s = 0;
		int max = 0;
		for(int i=0; i<count.length; i++){
			max = Math.max(max, count[i]); //제일 많이 겹치는 학생 찾기
		}
		
		for(; s<count.length; s++){
			if(max == count[s]){ //중복일 경우 제일 작은 번호의 학생이 반장
				break;
			}
		}
		System.out.println(s+1);
		
	}

}
