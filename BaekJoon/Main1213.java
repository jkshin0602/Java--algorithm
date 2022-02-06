
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

public class Main1213 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
	
		int[] cnt = new int[200];
		
		//홀수개가 2개 이상이면 펠린드롬 불가
	
		for(int i=0; i<s.length(); i++) {
			cnt[s.charAt(i)]++;
		}
		
		char mid = 0;
		int flag = 0;
		String ans = "";
		
		for(int i='Z'; i>='A'; i--) {
			if(cnt[i] > 0) {
				if(cnt[i]%2 == 1) { //홀수 
					mid = (char)i;
					flag++;
					cnt[i]--;
				}
				if(flag == 2)break;
				for(int j=0; j<cnt[i]/2; j++) {
					ans =  (char) i + ans;
				}
			}
		}
		
		StringBuffer sb = new StringBuffer(ans);
		String rev = sb.reverse().toString();
		
		if(mid > 0) {
			ans += (char) mid;
		}

		if(flag == 2) {
			System.out.println("I'm Sorry Hansoo");
		}else {
			System.out.println(ans+rev);
		}
		
	}
	
	
	
}
