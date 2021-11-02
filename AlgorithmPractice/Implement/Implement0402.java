package CodeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Implement0402 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //시간 입력 N
		
		int cnt = 0;
		
		for(int h=0; h<=N; h++){
			for(int m = 0; m<60; m++){	
				for(int s = 0; s<60; s++){
					if(check(h,m,s)){
						cnt ++;
					}
				}
			}
		}
		System.out.println(cnt);
		
	}
	
	public static boolean check(int h, int m, int s){
		if(h%10 == 3 || m/10 == 3 || m%10 == 3 || s/10 ==3 || s%10 == 3){
			return true;
		}
		return false;
	}

}
