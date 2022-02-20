
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2870 {

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		ArrayList<BigInteger> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine()); //종이의 줄의 개수 N 
		for(int i=0; i<N; i++) {
			String s= br.readLine();
			st = new StringTokenizer(check(s));
			while(st.hasMoreTokens()) {
				String tmp = st.nextToken();
				int a = 0;
				int j;
				if(tmp.charAt(0) == '0') {
					for(j=1; j<tmp.length(); j++) {
						if(tmp.charAt(j) == '0') {
							a = j;
						}else {
							break;
						}
					}
					tmp = tmp.substring(a);
				}
				list.add(new BigInteger(tmp));
			}
		}
		
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static String check(String s) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
				sb.append(s.charAt(i));
			}else {
				sb.append(" ");
			}
		}
		
		return sb.toString();
	}
	
	
	
	
}
