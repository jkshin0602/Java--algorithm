import java.util.Scanner;

public class Main1065 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		System.out.println(hansu(N));
	}

	public static int hansu(int N) {
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (i < 100) {
				count++;
			} else {
				int n1 = (i / 100);
				int n2 = (i % 100 / 10);
				int n3 = (i % 100 % 10);
				if (n1 - n2 == n2 - n3) {
					count++;
				}
			}
		}
		return count;
	}
}
