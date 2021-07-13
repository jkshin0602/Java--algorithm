import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String arr = bf.readLine();
		int[] history = new int[26];

		int max = 0;
		int cnt = 0;
		char result = 0;
		
		for (int i = 0; i < arr.length(); i++) {
			if (isUpper(arr.charAt(i))) { // 대문자이면
				history[arr.charAt(i) - 65]++;
			} else {
				history[arr.charAt(i) - 97]++;
			}
		}

		for (int i = 0; i < history.length; i++) {
			if (max < history[i]) {
				max = history[i];
				result = (char) (i + 65);
			}
		}
		for (int i = 0; i < history.length; i++) {
			if (max == history[i]) {
				cnt++;
			}
		}
		if (cnt == 1) {
			System.out.println(result);
		} else {
			System.out.println("?");
		}

	}

	public static boolean isUpper(char c) {
		return (c >= 'A' && c <= 'Z');
	}

}
