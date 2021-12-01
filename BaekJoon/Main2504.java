package Cho.week_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main2504 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> s = new Stack<Character>();
		
		String str = br.readLine();
		int answer = 0;
		int tmp = 1;
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			if(c == '('){
				s.push(c);
				tmp *= 2;
				
			}else if(c == '['){
				s.push(c);
				tmp *=3;
				
			}else if(c == ')'){ // 2
				if(s.isEmpty() ||s.peek() != '('){ //스택이 비어있거나 (가 아니면 잘못된 괄호
					answer = 0;
					break;
				}
				
				if(str.charAt(i-1) == '('){ //바로 이전값이 짝이 맞으면 
					answer += tmp; // answer에 tmp를 더해준다.
				}
				s.pop();  
				tmp /= 2;  //괄호를 닫았으므로 다시 나눠준다.
				 
			}else if(c == ']'){ // 3	
				if(s.isEmpty() ||s.peek() != '['){ //스택이 비어있거나 (가 아니면 잘못된 괄호
					answer = 0;
					break;
				}
				
				if(str.charAt(i-1) == '['){
					answer += tmp;
				}
				s.pop();
				tmp /= 3;
				
			}
			
		}
		if(!s.empty()){ //다 끝나고 스택이 비어있지 않다면 잘못된 괄호
			System.out.println(0);
		}else{
			System.out.println(answer);
		}
		

	}

}
