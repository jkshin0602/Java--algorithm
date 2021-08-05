import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main1406 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<Character> leftStack = new Stack<Character>();
		Stack<Character> rightStack = new Stack<Character>();
		StringTokenizer st;
		
		String str = br.readLine(); // 1. 문자입력받음
		
		for(int i=0; i<str.length(); i++){ // 2. 시작할때 커서는 맨뒤에 위치하므로, 왼쪽 스택에 모두 넣음 
			leftStack.push(str.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine()); // 3. 명령어 갯수 입력 받음
		for(int i=0; i<M; i++){
			String input = br.readLine(); // 4. 명령어 입력받음
			if(input.equals("L")){ // 커서를 왼쪽으로 한 칸 옮김 
				if(leftStack.empty()){ //(커서가 문장의 맨 앞이면 무시됨)
					continue;
				}
				rightStack.push(leftStack.pop());
			}else if(input.equals("D")){ //	커서를 오른쪽으로 한 칸 옮김 
				if(rightStack.empty()){ // (커서가 문장의 맨 뒤이면 무시됨)
					continue;
				}
				leftStack.push(rightStack.pop());
			}else if(input.equals("B")){ //커서 왼쪽에 있는 문자를 삭제함
				if(leftStack.empty()){ //(커서가 문장의 맨 앞이면 무시됨)
					continue;
				}
				leftStack.pop();
			}else if(input.charAt(0) == 'P'){ //	$라는 문자를 커서 왼쪽에 추가함
				st = new StringTokenizer(input);
				st.nextToken(); // P제거
				leftStack.push(st.nextToken().charAt(0)); // $ 입력받음 
			}		
		} //for문끝
		
		// 5. 합치기
		while(!leftStack.empty()){ //스택이 비어있으면 false , 아니면 true  (! 적용)
			rightStack.push(leftStack.pop());
		}
		while(!rightStack.empty()){
			sb.append(rightStack.pop());
		}
		bw.write(sb.toString()); // 6. 출력
		bw.flush();
		br.close();
		bw.close();
		
	}

}
