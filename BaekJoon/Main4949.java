package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main4949 {


	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> s;
		
		while(true) {
			String str = br.readLine();
			if(str.equals(".")){
				break;
			}
			s = new Stack<Character>();
			boolean state = true;

			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == '(') {
					s.push(str.charAt(i));
				}else if(str.charAt(i) == '[') {
					s.push(str.charAt(i));
				}else if(str.charAt(i) == ')') {
					if(s.size() != 0 && s.peek()== '(') s.pop();
					else state = false;
				}else if(str.charAt(i) == ']') {
					if(s.size() != 0 && s.peek() == '[') s.pop();
					else state = false;
				}
			}
			
			if(state && s.size() == 0) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
		
	}
	
	
	
	
	
	
}
