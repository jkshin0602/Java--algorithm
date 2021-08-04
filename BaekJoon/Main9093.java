import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main9093 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(bf.readLine());

		for(int i=0; i<T; i++){
			Stack<Character> stack = new Stack<Character>();
			StringBuilder sb = new StringBuilder();
			sb.append(bf.readLine());
			for(int j=0; j<sb.length(); j++){
				if(sb.charAt(j) == ' '){ 
					while(!stack.empty()){ 
						bw.write(stack.pop());
					}
					bw.write(" ");
				}else{
					stack.add(sb.charAt(j));
				}
			}
			while(!stack.empty()){ 
				bw.write(stack.pop());
			}
			bw.write("\n");
		}
		bf.close();
		bw.flush();
		bw.close();

	}
}
