import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String S = bf.readLine();
		int[] alpha = new int[26];

		for (int i = 0; i < alpha.length; i++) {
			alpha[i] = -1;
		}

		for (int i = 0; i < S.length(); i++) {
			if (alpha[S.charAt(i) - 97] == -1) {
				alpha[S.charAt(i) - 97] = i;
			}
		}
		for (int i = 0; i < alpha.length; i++) {
			System.out.print(alpha[i] + " ");
		}

	}

}
