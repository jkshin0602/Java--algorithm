import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1003 {

	public static int[] zero = new int[41];
	public static int[] one = new int[41];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		zero[0] = 1;
		one[1] = 1;
		// O(N)
		for (int i = 2; i < 41; i++) {
			zero[i] = zero[i - 1] + zero[i - 2];
			one[i] = one[i - 1] + one[i - 2];
		}

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(zero[n] + " " + one[n]);
		}
	}

}
