import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1712 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String S = bf.readLine();
		StringTokenizer st = new StringTokenizer(S, " ");

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		if (C <= B)
			System.out.println("-1");
		else
			System.out.println((A / (C - B)) + 1);

	}

}
