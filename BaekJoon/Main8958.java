import java.util.Scanner;

public class Main8958 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		String[] result = new String[T];
		int[] score = new int[T];
		s.nextLine();

		for (int i = 0; i < T; i++)
			result[i] = s.nextLine();

		for (int i = 0; i < T; i++) {
			int continuesScore = 0;
			for (int j = 0; j < result[i].length(); j++) {
				if (result[i].charAt(j) == 'O') {
					continuesScore++;
					score[i] += continuesScore;
				} else {
					continuesScore = 0;
					score[i] += continuesScore;
				}
			}
		}

		for (int i = 0; i < T; i++)
			System.out.println(score[i]);
	}

}
