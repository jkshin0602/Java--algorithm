import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


public class Main17413 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String S = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		boolean tag = false; // 태그 상태 변수
		
		for(int i=0; i<S.length(); i++){
			if(S.charAt(i) == '<'){ //1. 여는 태그일때는 닫는태그가 나올때까지 그대로 입력 
				//2. 중간 여는 태그일경우 스택에서 있던것들을 출력
				while(!stack.empty()){
					sb.append(stack.pop());
				}
				tag = true;
				sb.append(S.charAt(i)); // < 태그 추가
			}else if(S.charAt(i) == '>'){ // 닫는 태그이면 
				tag = false;
				sb.append(S.charAt(i)); // > 태그 추가	
			}else if(tag){ // 현재 태그안을 지나는중 그대로 입력
				sb.append(S.charAt(i));
			}else{ //뒤집을 단어들 
				if(S.charAt(i) == ' '){ //공백이면 stack에 있던 것들을 빼와서 출력
					while(!stack.empty()){
						sb.append(stack.pop());
					}
					sb.append(S.charAt(i)); //공백 추가
				}else{ //뒤집을 단어들이면 
					stack.push(S.charAt(i));
				}
			}
		}
		while(!stack.empty()){ //마지막에 있는 단어 출력 (공백이 등장하지 않기 때문에 pop을 못해줌)
			sb.append(stack.pop());
		}

		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}
