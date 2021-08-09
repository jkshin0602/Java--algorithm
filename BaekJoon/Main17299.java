import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main17299 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		
		//N개의 수 입력 받음 
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N];
		int[] ans = new int[N];
		int[] freq = new int[1000001];

		//수열 입력 받음 
		String str = br.readLine(); 
		st = new StringTokenizer(str); //공백을 기준으로 숫자를 잘라줌 
		
		for(int i=0; i<N; i++){
			num[i] = Integer.parseInt(st.nextToken());
			freq[num[i]]++; //등장횟수 증가
		}
		
		for(int i=0; i<N; i++){
			if(stack.empty()){ //스택이 비어있다면 push
				stack.push(i);
			}
			while(!stack.empty() && freq[num[stack.peek()]] < freq[num[i]]){ //스택 top의 등장횟수보다 현재 원소의 등장횟수가 더 크면
				ans[stack.pop()] = num[i]; //다 넣어준다 (top이 더 크면 중지 ) 
			}
			stack.push(i); //다하면 인덱스값 넣어줌 
		}
		while(!stack.empty()){ //위의 과정이 끝나고 스택에 남아있는 수들은 오등큰수를 찾지 못한 수이다.
			ans[stack.pop()] = -1;
		}
		for(int i=0; i<N; i++){
			if(i == N-1){
				sb.append(ans[i]);
				break;
			}
			sb.append(ans[i]).append(" ");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}

}
