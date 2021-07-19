import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1193 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int cnt = 0;
		int line = 0;

		while (cnt < N) {
			line++;
			cnt = line * (line + 1) / 2; // n(n+1)/2 수열
		}

		if (line % 2 != 0) {
			int son = 1 + (cnt - N);
			int parent = line - (cnt - N);
			System.out.println(son + "/" + parent);
		} else {
			int son = line - (cnt - N);
			int parent = 1 + (cnt - N);
			System.out.println(son + "/" + parent);
		}

	}

}
