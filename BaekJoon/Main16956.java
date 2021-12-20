
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main16956 {
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	//상하좌우 

	static int R;
	static int C;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken()); //R x C 크기의 목장 
		
		char[][] map = new char[501][501];
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'S') { //만약 늑대이면 
					//상하좌우에 양이 있는지 검사
					for(int k=0; k<4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						
						if(!valid(nx, ny)) continue;
						
						if(map[ny][nx] == 'W') { //늑대와 양이 인접하면 울타리 설치 불가 
							System.out.println(0);
							System.exit(0);
						}else if(map[ny][nx] == 'S' || map[ny][nx] == 'D') { //늑대 주변에 늑대,울타리면 스킵 
							continue;
						}else if(map[ny][nx] == '.') { //빈공간이면 울타리 설
							map[ny][nx] = 'D';
						}
						
					}//이 반복문이 종료되면 늑대 한마리의 검사가 끝난다.
				}
			}
		}
		
		System.out.println(1);
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		
		
	}
	
	static boolean valid(int x, int y) {
		if(x < 0 || y < 0 || x > C-1 || y > R-1) {
			return false;
		}
		return true;
	}
	
	
}

