import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1189 {

	public static int[][] check;
	public static char[][] map;
	public static int R,C,K;
	
	public static int[] dy = {-1,0,1,0};
	public static int[] dx = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		check = new int[R][C];
		
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		check[R-1][0] = 1;
		System.out.println(go(R-1, 0));
	}
	
	public static int go(int y, int x) {
		if(y == 0 && x== C-1) { //집의 좌표일시 
			if(K == check[y][x]) return 1;
			return 0;
		}
		int ret = 0;
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny<0 || nx < 0 || ny >=R || nx >= C ||check[ny][nx] > 0|| map[ny][nx] == 'T') continue;
			check[ny][nx] = check[y][x] + 1;
			ret += go(ny,nx);
			check[ny][nx] = 0;
			
		}
		return ret;
	}

}
