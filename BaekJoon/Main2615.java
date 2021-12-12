import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2615 {
	
	static int[][] a; 
	static int cnt = 0, row=1, col = 1, dd = 1, ud = 1;
	//                   가로   세로      아래대각   위대각 
	
	 //위오, 오, 아오, 아 ->가장 왼쪽 바둑알을 찾는다.,세로는 가장 
	//6개 알이 연속적인 경우 그대로 진행
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = new int[20][20];
		
		for(int i=1; i<20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<20; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<20; i++) {
			for(int j=1; j<20; j++) {
				if(a[i][j] == 1) { //검은돌일경우 
					search(i, j, 1);
				}else if(a[i][j] == 2) {
					search(i, j, 2);
				}
			}
		}
		//만약 위에서 종료가안되었으면 정답은 0
		System.out.println(0);
		

	}


	public static boolean check(int x, int y, int num) { //같은 돌인지 확인하는 함수
		if (valid(x, y)) { //만약 유효한 좌표이고
			if (a[x][y] != num) { // 돌이 같지 않다면 
				return false; // 같은 돌 X
			}
		} else {//만약 유효한 좌표가 아니라면 
			return false; 
		}
		//여기까지 정상적으로 왔으면 유효한 좌표이며, 같은 색의 돌이다.
		return true;
	}

	public static boolean valid(int x, int y) { //유효한 좌표인지 확인 
		if (x < 1 || x > 19 || y < 1 || y > 19) {
			return false;
		}
		return true;
	}

	public static void search(int i, int j, int num) { 
		
		// 가로 확인
		for (int k = 1; k < 5; k++) {
			if (!check(i, j + k, num)) { // 좌표를 가로로 늘리면서 검사
				break;
			}else { //맞으면 가로 길이 증가
				row++;
			}
		}

		// 세로 확인
		for (int k = 1; k < 5; k++) {
			if (!check(i + k, j, num)) { //좌표를 세로로 늘리면서 검사
				break;
			}
			else { //맞으면 세로 길이 증가
				col++;
			}
		}

		// 아래 대각선(오른쪽) down diagonal  확인
		for (int k = 1; k < 5; k++) {
			if (!check(i + k, j + k, num)) { //좌표를 대각선으로 늘리면서 검사
				break;
			}
			else { //맞으면 대각선 길이 증가
				dd++;
			}
		}

		// 위 대각선 (오른쪽) up diagonal 확인
		for (int k = 1; k < 5; k++) { 
			if (!check(i - k, j + k, num)) { //좌표를 대각선으로 늘리면서 검사
				break;
			}else {
				ud++;
			}
		}
		
		// 1. 돌이 한 방향으로 5개이면 
		// 2. 먼저 유효한 좌표 체크 
		// 2-1. 유효한 좌표이면 
		// 2-1-1. 같은 돌인지 검사 
		// 2-1-2. 반대쪽 돌도 유효한 좌표와, 같은 돌인지 검사
		// 2-2. 유효한 좌표가 아니라면
		// 2-2-1. 정답 출력

		// 양쪽 끝에 돌이 더있는지 확인 (6개 이상이면 인정이 안된다) 
		if (row == 5) { //돌이 5개 이면  
			if (valid(i, j - 1)) { //유효한 좌표인지 체크
				if (a[i][j - 1] != num) { //같은 돌이 아니라면 
					if (valid(i, j + 5)) { //반대쪽도 검사
						if (a[i][j + 5] != num) { //반대쪽도 같은 돌이 아니라면 
							print(i, j, num); //정답 출력 
						}
					} else { //반대쪽의 좌표가 유효한 좌표가 아니라면 
						print(i, j, num); //정답 출력
					}
				}
			} else { //유효한 좌표가 아니라면 
				if (valid(i, j + 5)) { //반대쪽 좌표도 체크 
					if (a[i][j + 5] != num) { //반대쪽 좌표가 같은 돌이 아니라면 
						print(i, j, num); //정답 
					}
				} else { //반대쪽 좌표가 유효한 좌표가 아니라면 
					print(i, j, num); //정답 
				}
			}

		}
		if (col == 5) {
			if (valid(i - 1, j)) {
				if (a[i - 1][j] != num) {
					if (valid(i + 5, j)) {
						if (a[i + 5][j] != num) {
							print(i, j, num);
						}
					} else {
						print(i, j, num);
					}
				}
			} else {
				if (valid(i + 5, j)) {
					if (a[i + 5][j] != num) {
						print(i, j, num);
					}
				} else {
					print(i, j, num);
				}
			}
		}
		if (dd == 5) {
			if (valid(i - 1, j - 1)) {
				if (a[i - 1][j - 1] != num) {
					if (valid(i + 5, j + 5)) {
						if (a[i + 5][j + 5] != num) {
							print(i, j, num);
						}
					} else {
						print(i, j, num);
					}	
				}
			} else {
				if (valid(i + 5, j + 5)) {
					if (a[i + 5][j + 5] != num) {
						print(i, j, num);
					}
				} else {
					print(i, j, num);
				}
			}
		}
		if (ud == 5) {
			if (valid(i + 1, j - 1)) {
				if (a[i + 1][j - 1] != num) {
					if (valid(i - 5, j + 5)) {
						if (a[i - 5][j + 5] != num) {
							print(i, j, num);
						}
					} else {
						print(i, j, num);
					}
				}
			} else {
				if (valid(i - 5, j + 5)) {
					if (a[i - 5][j + 5] != num) {
						print(i, j, num);
					}
				} else {
					print(i, j, num);
				}
			}
		}

		//위에서 정답을 찾지 못했으면 다시 1로 초기화해서 다시 찾는다.
		row = 1;
		col = 1;
		dd = 1;
		ud = 1;
	}

	public static void print(int i, int j, int num) {
		System.out.println(num);
		System.out.println(i + " " + j);
		System.exit(0); //찾으면 프로그램을 종료한다.
	}
}