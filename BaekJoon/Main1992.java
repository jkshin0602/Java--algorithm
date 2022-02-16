
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1992 {

	public static int[][] map;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 가로세로 N
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		sb = new StringBuilder();
		
		quard(0,0,N);
		System.out.println(sb.toString());
		
	}
	
	public static void quard(int y, int x, int size) {
		//기저사례
		if(check(y,x,size)) { //4개 영역이 다 똑같으면 그대로 넣어준다.
			sb.append(map[y][x]);
			return;
		}
		
		int nsize = size / 2; //압축이 블가능할경우 사이즈 줄임 
		
		sb.append("("); //레벨이 증가할 때마다 여는 괄호로 시작 
		
		quard(y, x, nsize); //왼쪽위
		quard(y, x+nsize, nsize); //오른쪽 위
		quard(y+nsize, x, nsize); //왼쪽 아래
		quard(y+nsize, x+nsize, nsize); //오른쪽 아래 
		
		sb.append(")"); //레벨이 끝나면 괄호를 닫아준다.
		return;
	}
	
	public static boolean check(int y, int x, int size) {
		//사이즈만큼 4가지 영역 탐색 
		int value = map[y][x];
		
		for(int i=y; i<y+size; i++) { 
			for(int j=x; j<x+size; j++) {
				if(value != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	
	
	
	
	
}
