import java.util.Scanner;

public class Main4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		String[] ratio = new String[C];
		double[] aver = new double[C];
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < C; i++) {
			int N = sc.nextInt();
			int[] score = new int[N];
			for (int j = 0; j < N; j++) {
				score[j] = sc.nextInt();
				sum += score[j];
				if (j == N - 1) {
					aver[i] = (double) sum / N;
					sum = 0;
					for (int k = 0; k < N; k++) {
						if (score[k] > aver[i]) {
							cnt++;
						}
						ratio[i] = String.format("%.3f", (double) cnt / N
								* 100.0);
					}
					cnt = 0;
				}
			}
		}
		for (int i = 0; i < C; i++)
			System.out.println(ratio[i] + "%");
	}
}
