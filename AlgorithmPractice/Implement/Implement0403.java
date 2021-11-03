package CodeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Implement0403 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int row = str.charAt(1) - '0';
		int column = str.charAt(0) - 'a' + 1;
		
		//나이트가 이동할 수 있는 8가지 방향 
		int[] dx = {-2, -2, -1, 1, -1, 1, 2, 2};
		int[] dy = {-1, 1, -2, -2, 2, 2, 1, -1};
		
		//8가지 방향으로 이동 가능한지 확인
		int result = 0;
		for(int i=0; i<8; i++){
			int nextRow = row + dx[i];
			int nextColumn = column + dy[i];
			//해당 위치로 이동가능한지 체크
			if(nextRow >= 1 && nextRow <= 8 && nextColumn >=1 && nextColumn <=8){
				result ++;
			}
		}
		System.out.println(result);

	}

}
