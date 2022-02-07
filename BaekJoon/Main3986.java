
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main3986 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //단어의 수 N 
		
		//선이 겹치지 않는 조건 
		// 1. 같은 글자끼리 붙어있을 때 
		// 2. 한 글자는 붙어있고 양 옆에 다른 글자가 있을 때 
		
		int cnt = 0;
		Stack<Character> s;
		while(N-->0) {
			
			s = new Stack<Character>();
			String str = br.readLine();
		
			for(int i=0; i<str.length(); i++) {
				char a = str.charAt(i);
				if(s.size() != 0 && s.peek() == a) { //stack size가 0이 아니고, 스택의 top이 a랑 같다면 빼내줌 
					s.pop();
				}else {
					s.push(a);
				}
			}
			if(s.isEmpty()) { //짝이 맞다면 결국 스택이 비워짐 
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	
	
	
}
