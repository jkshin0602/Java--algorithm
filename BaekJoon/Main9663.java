
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//N-Queen
//https://www.acmicpc.net/problem/9663
public class Main9663 {

	static int N, ans;
	static int[] col; // col[i] : i번 행의 퀸은 col[i]번 열에 놓았다느 ㄴ기록

	//row번 ~ N번 행에 대해서 가능한 퀸을 놓는 경우의 수를 구하기
	static void rec_func(int row) {
		if (row == N + 1) { //각 행마다 하나씩 잘 놓았다.
			ans++;
		} else {
			for (int c = 1; c <= N; c++) {
				// row 행의 c열에 추가할 수 있다면
				boolean possible = true;
				for (int i = 1; i <= row - 1; i++) {
					// (i, col[i])
					if (attackable(row, c, i, col[i])) {
						possible = false;
						break;
					}
				}
				if (possible) {
					col[row] = c;
					rec_func(row + 1);
					col[row] = 0;
				}

			}
		}
	}

	private static boolean attackable(int r1, int c1, int r2, int c2) {
		if (c1 == c2)
			return true;
		if (r1 - c1 == r2 - c2) //왼쪽 대각선 확인
			return true;
		if (r1 + c1 == r2 + c2) //오른쪽 대각선 확인
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		input();
		rec_func(1);
		System.out.println(ans);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N + 1];
	}

}
