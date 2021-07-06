import java.util.Scanner;

public class Main2577 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		int B = s.nextInt();
		int C = s.nextInt();

		int result = A * B * C;
		int[] cnt = new int[10];
		String answer = result + "";

		int num = 0;

		for (int i = 0; i < answer.length(); i++) {
			for (int j = 0; j < cnt.length; j++) {
				if (j == (answer.charAt(i) - '0')) {
					cnt[j]++;
				}
			}
		}
		for (int i = 0; i < cnt.length; i++)
			System.out.println(cnt[i]);

	}

}
