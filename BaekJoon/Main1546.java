import java.util.Scanner;

public class Main1546 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int N = s.nextInt();

		double[] score = new double[N];
		double sum = 0;
		double aver = 0;
		int highscore = 0;

		for (int i = 0; i < N; i++) {
			score[i] = (double) s.nextInt();
			if (highscore < score[i]) {
				highscore = (int) score[i];
			}
		}

		for (int i = 0; i < N; i++) {
			score[i] = (double) score[i] / highscore * 100;
			sum += score[i];
		}
		aver = sum / N;
		System.out.println(aver);
	}

}
