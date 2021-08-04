import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();

		int max = Integer.parseInt(br.readLine());
		int m = 0;

		while (max-- > 0) {
			int num = Integer.parseInt(br.readLine()); 
			if (num > m) {
				while (num > m) {
					stack.push(++m);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			} else {
				boolean found = false;
				if (!stack.empty()) {
					int top = stack.peek();
					stack.pop();
					sb.append("-\n");
					if (num == top) {
						found = true;
					}
				}
				if (!found) {
					System.out.println("NO");
					return;
				}
			}

		}
		System.out.println(sb);

	}
}
