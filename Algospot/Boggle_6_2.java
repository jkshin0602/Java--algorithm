package algospot;

import java.io.*;


public class Boggle_6_2 {
	
	public static char[][] map;
	public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static boolean inRange(int y, int x) {
		if(y < 0 || x < 0 || y >=5 || x >=5) return false;
		return true;
	}
	
	public static boolean hasWord(int y, int x, String word) {
		// 기저사례1 : 시작 위치가 범위 밖이면 실패 
		if(!inRange(y,x)) return false;
		// 기저사례2 : 첫 글자가 일치하지 않으면 실패 
		if(map[y][x] != word.charAt(0)) return false;
		// 기저사례3 : 단어 길이가 1이면 성공 
		if(word.length() == 1) return true;
		for(int i=0; i<8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			//다음 칸이범위에 있는지, 첫글자는 일치하는지 확인 x 
			if(hasWord(ny, nx, word.substring(1))) return true;
		}
	
		return false;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); 
		while(T-- > 0) {
			map = new char[5][5];

			for(int i=0; i<5; i++) {
				String s = br.readLine();
				for(int j=0; j<5; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			int wordCnt = Integer.parseInt(br.readLine());
			for(int i=0; i<wordCnt; i++) {
				String word = br.readLine();
				boolean check = false;
				for(int y=0; y<5; y++) {
					for(int x=0; x<5; x++) {
						check = hasWord(y,x,word);
						if(check == true) break;
					}
					if(check == true) break;
				}
				System.out.println(word + " " + (check ? "YES" : "NO"));
			}
			
		}
		
	}

	

}
