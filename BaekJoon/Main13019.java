
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main13019 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();
		
		int l = A.length();
		int cnt = 0;
		int b = l-1;
		
		for(int i=l-1; i>=0 ;i--) { //문자열을 뒤에서부터 검사  (한글자를 골라서 앞으로 보내기 때문) 
			if(A.charAt(i) != B.charAt(b)) { //두 문자가 다르면 cnt증가 
				cnt++;
			}else { //A의 문자를 한개 앞으로 보냈다고 가정 -> i 와 b는 다를 수 있다 (결국 맞춰진다)
				b--;
			}
		}
		
		//두 문자열 중 한원소라도 다르면 -1을 출력 
		char[] sA = A.toCharArray(); // 문자 배열로 만든후 
		char[] sB = B.toCharArray();
		
		Arrays.sort(sA); //정렬 
		Arrays.sort(sB);
		
		A = String.valueOf(sA);
		B = String.valueOf(sB);
		
		if(A.equals(B)) { //문자열이 동일하면 cnt 출력 
			System.out.println(cnt);
		}else {
			System.out.println(-1);
		}
		
		
		
	}
	
	
}
