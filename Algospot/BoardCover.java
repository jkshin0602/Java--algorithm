package algospot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BoardCover {

	public static char[][] board = new char[21][21];
	public static int H,W, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		while (C-- > 0) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 21; i++) {
				Arrays.fill(board[i], '#');
			}
			ans = 0;
			int cnt = 0;
			for (int i = 1; i <=H; i++) {
				String tmp = br.readLine();
				for (int j = 1; j <=W; j++) {
					board[i][j] = tmp.charAt(j-1);
					if(board[i][j] == '.') cnt++;
				}
			}
			if (cnt % 3 != 0) {
				System.out.println(0);
				continue;
			}
			boardCover();
			System.out.println(ans);

		}

	}

	public static void boardCover() {
		int x = 1, y = 1;
		label : for (y = 1; y <= H; y++) {
			for (x = 1; x <= W; x++) {
				if (board[y][x] == '.') {
					break label;
				}
			}
		}

		if (y == H + 1 && x == W + 1) {
			ans++;
			return;
		}

		if (board[y + 1][x] == '.' && board[y + 1][x + 1] == '.') {
			board[y][x] = board[y + 1][x] = board[y + 1][x + 1] = '*';
			boardCover();
			board[y][x] = board[y + 1][x] = board[y + 1][x + 1] = '.';
		}

		if (board[y + 1][x-1] == '.' && board[y + 1][x] == '.') {
			board[y][x] = board[y + 1][x-1] = board[y + 1][x] = '*';
			boardCover();
			board[y][x] = board[y + 1][x-1] = board[y + 1][x] = '.';
		}

		if (board[y][x+1] == '.' && board[y + 1][x + 1] == '.') {
			board[y][x] = board[y][x+1] = board[y + 1][x + 1] = '*';
			boardCover();
			board[y][x] = board[y][x+1] = board[y + 1][x + 1] = '.';
		}
		if (board[y + 1][x] == '.' && board[y][x + 1] == '.') {
			board[y][x] = board[y + 1][x] = board[y][x + 1] = '*';
			boardCover();
			board[y][x] = board[y + 1][x] = board[y][x + 1] = '.';
		}
	}


}
