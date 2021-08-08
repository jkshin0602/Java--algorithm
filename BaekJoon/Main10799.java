import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		Stack<Integer> stack = new Stack<Integer>();
		int answer = 0;

		for(int i=0; i<S.length(); i++){
			if(S.charAt(i) == ')'){ // 닫는 괄호 일 때
				if(stack.peek() == i-1){ //stack의 top과 인덱스 차이가 -1이면 레이저
					stack.pop(); //레이저 pop
					answer += stack.size(); //stack의 크기는 레이저가 자르는 쇠막대기 개수와 같음
				}else{ //쇠막대기 끝 이면
					stack.pop(); 
					answer += 1; //1개를 n번자르면 n+1의 조각으로 나누어지기때문
					//레이저가 자르는 횟수는 이미 정답에 더하였고, 쇠막대기의 끝에서 1을 더해야된다.
				}
			}else{ //여는 괄호일 때
				stack.push(i); //인덱스 넣음
			}
		}
		System.out.println(answer);
	}

}

