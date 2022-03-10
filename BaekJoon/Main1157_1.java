import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1157_1 {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     
		 String s = br.readLine().toUpperCase();
		 int[] cnt = new int[26];
		 
		 int max = 0;
		 char maxAlpha = '?';
		 
		 for(int i=0; i<s.length(); i++) {
			 cnt[s.charAt(i)-'A']++;
			 if(max < cnt[s.charAt(i)-'A']) {
				 max = cnt[s.charAt(i)-'A'];
				 maxAlpha = s.charAt(i);
			 }else if(max == cnt[s.charAt(i)-'A']) maxAlpha='?';
		 }

		 System.out.println(maxAlpha);
	}

	
}
