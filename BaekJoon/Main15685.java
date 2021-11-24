
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;
import java.util.StringTokenizer;


public class Main15685 {
	
	public static int[] dy = {0,-1,  0, 1}; //0, 1, 2, 3
	public static int[] dx = {1, 0, -1, 0}; //오,위,왼,아
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] check = new boolean[105][105];
		
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken()); //시작 좌표 x, y
			int d = Integer.parseInt(st.nextToken()); //시작 방향(0,1,2,3)
			int g = Integer.parseInt(st.nextToken()); //세대(0~10)
			
			List<Integer> list = new ArrayList<Integer>();
			
			list.add(d); //첫 시작방향 
			
			for(int j=1; j<=g; j++){
				int s = list.size();
				for(int k=s-1; k>=0; k--){ //이동 규칙
					list.add((list.get(k)+1)%4);
				}
			}		
			//list에 저장되어 있는 길이 만큼 반복문 
			//list의 마지막에 저장되어 있는 방향에서 반시계 방향으로 돌린다
			//g세대의 방향이 순서대로 입력된다

			check[y][x] = true;
			
			for(int j : list){ 
				x +=dx[j];
				y +=dy[j];
				check[y][x] = true;
			}

		}
		int result = 0;
		for(int i=0; i<100; i++){
			for(int j=0; j<100; j++){
				if(check[i][j] && check[i+1][j] && check[i][j+1] && check[i+1][j+1]){
					result ++;
				}
			}
		}
		System.out.println(result);
	}

}
