
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6186 {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0,0, -1, 1};

	static int R, C;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		boolean[][] check = new boolean[R][C];
		int cnt = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(!check[i][j] && map[i][j] == '#') {
					check[i][j] = true;
					for(int k=0; k<4; k++) {  //유효한 좌표이면서 , 풀이면서,체크한 풀이 아니라면 
						if( valid(i+dx[k], j+dy[k]) && map[i+dx[k]][j+dy[k]] == '#' &&!check[i+dx[k]][j+dy[k]] ) {  
							check[i+dx[k]][j+dy[k]] = true; //붙어있는 것으로 간
						}
					}
					cnt++;
				}		
			}
		}
		
		System.out.println(cnt);
		
		
	}

	static boolean valid(int x, int y) {
		if(x < 0 || x > R-1 || y < 0 || y > C-1) {
			return false;
		}
		return true;
	}
}
