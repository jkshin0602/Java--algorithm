package book.nadongbin.문제.구현;

public class 자물쇠와_열쇠 {

	//잠겨있는 자물쇠는 격자 한 칸의 크기가 1x1 인 NxN 크기의 정사각 격자 형태
	//특이한 모양의 열쇠는 M * M 크기인 정사각 격자 형태

	//열쇠는 회전과 이동이 가능하며, 열쇠의 돌기 부분을 자물쇠의 홈 부분에 딱 맞게 채우면 자물쇠가 열린다.
	//자물쇠 영역을 벗어난 부분에 있는 열쇠의 홈과 돌기는 자물쇠를 여는데 영향을 주지 않지만
	//자물쇠 영역 내에서는 열쇠의 돌기 부분과 자물쇠의 홈 부분이 정확히 일치해야 하며
	//열쇠의 돌기와 자물쇠의 돌기가 만나서는 안된다.
	//자물쇠의 모든 홈을 채워 비워있는 곳이 없어야 자물쇠를 열 수 있다.
	//0은 홈부분, 1은 돌기부분

	public static boolean solution(int[][] key, int[][] lock) {
		int n = lock.length;
		int m = key.length;

		int[][] newLock = init(lock, n);

		//4가지 방향에 대해서 확인
		for (int rotation = 0; rotation < 4; rotation++) {
			key = rotateMatrixBy90Degree(key);
			for (int x = 0; x < n * 2; x++) {
				for (int y = 0; y < n * 2; y++) {
					//자물쇠에 열쇠를 끼워 넣기
					keyInteractionLock(key, m, newLock, x, y, false);

					//새로운 자물쇠에 열쇠가 정확히 들어맞는지 검사
					if (check(newLock)) {
						return true;
					}

					//자물쇠에서 열쇠를 다시 빼기
					keyInteractionLock(key, m, newLock, x, y, true);
				}
			}
		}

		return false;
	}

	private static int[][] init(int[][] lock, int n) {
		//자물쇠의 크기를 기존의 3배로 변환
		int[][] newLock = new int[n * 3][n * 3];

		//새로운 자물쇠의 중앙 부분에 기존의 자물쇠 넣기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				newLock[i + n][j + n] = lock[i][j];
			}
		}

		return newLock;
	}

	private static void keyInteractionLock(int[][] key, int m, int[][] newLock, int x, int y, boolean flag) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if (!flag) {
					newLock[x + i][y + j] += key[i][j];
				} else {
					newLock[x + i][y + j] -= key[i][j];
				}

			}
		}
	}

	private static boolean check(int[][] newLock) {
		int lockLength = newLock.length / 3;

		for (int i = lockLength; i < lockLength * 2; i++) {
			for (int j = lockLength; j < lockLength * 2; j++) {
				if (newLock[i][j] != 1) {
					return false;
				}
			}
		}

		return true;
	}

	private static int[][] rotateMatrixBy90Degree(int[][] key) {
		int n = key.length;
		int m = key[0].length;

		int[][] result = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[j][n - i - 1] = key[i][j];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}},
			new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
	}
}
