import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main17298_1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		
		Stack<Integer> s = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine()); //수열의 크기 N 
		int[] num = new int[N];
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int[] ans = new int[N];
		for(int i=0; i<N; i++) {
			ans[i] = -1;
		}
		
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			while(!s.empty() && num[s.peek()] < num[i]) {
				ans[s.pop()] = num[i];
			}
			s.push(i);
		}
		
		for(int i=0; i<N; i++) {
			if(i == N-1) {
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
