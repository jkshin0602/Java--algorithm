import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2908 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");

		String A = st.nextToken();
		String B = st.nextToken();

		int A_Reverse = 0;
		int B_Reverse = 0;
		int i = 0;

		if (i == 0) {
			A_Reverse += A.charAt(i) - '0';
			B_Reverse += B.charAt(i) - '0';
			i++;
		}
		if (i == 1) {
			A_Reverse += ((A.charAt(i) - '0') * 10);
			B_Reverse += ((B.charAt(i) - '0') * 10);
			i++;
		}
		if (i == 2) {
			A_Reverse += ((A.charAt(i) - '0') * 100);
			B_Reverse += ((B.charAt(i) - '0') * 100);
		}

		System.out.println(Integer.max(A_Reverse, B_Reverse));

	}

}
