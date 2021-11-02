package CodeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Implement0401 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //사각형의 크기 N x N
		StringTokenizer st = new StringTokenizer(br.readLine()); // 이동방향 입력
		// L : 왼쪽, R : 오른쪽, U : 위, D : 아래

		int x = 1;
		int y = 1;
		
		System.out.println(st.countTokens());
		
		String[] arr = new String[st.countTokens()];
		
		for(int i=0; i<arr.length; i++){
			arr[i] = st.nextToken();
		}
		
		for(int i=0; i<arr.length; i++){
			if(arr[i].equals("L")){
				if(y == 1){
					continue;
				}
				y--;
			}else if(arr[i].equals("R")){
				if(y == N){
					continue;
				}
				y++;
			}else if(arr[i].equals("U")){
				if(x == 1){
					continue;
				}
				x--;
			}else if(arr[i].equals("D")){
				if(x == N){
					continue;
				}
				x++;
			}
		}
		System.out.println(x + " " + y);
	}

}
