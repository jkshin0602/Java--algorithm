package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 거리두기_확인하기 {

	//대기실은 5개이며 각 대기실은 5x5 크기
	//응시자 끼리는 맨헤튼 거리가 2이하로 앉지 못한다.
	//응시자가 앉아있는 자리가 사이가 파티션으로 막혀있을 경우는 허용
	//P : 응시자, O : 빈테이블, X : 파티션

	//맨해튼 거리 2
	//      X
	//    X X X
	//	X X P X X
	// 	  X X X
	//		X

	//응시자 기준으로 맨해튼거리 주변 모두 탐색

	//(p.y,p.x)와 (ny,nx) 사이에 파티션이 있는지 탐색
	//파티션 조건
	//1. 자리 사이에 파티션이 존재(찾은 P와 직선상 거리에 위치할 경우)
	//2. 대각으로 파티션이 존재

	//가능한 대각 경우의 수는 4가지 존재
	// 1 x 2
	// x P x
	// 3 x 4

	public static int[] solution(String[][] places) {
		int[] answer = new int[5];

		for (int i = 0; i < 5; i++) {
			char[][] map = init(places, i);
			answer[i] = go(map);
		}

		return answer;
	}

	private static int go(char[][] map) {
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == 'P') {
					list.add(new Pair(i, j));
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			Pair p1 = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				Pair p2 = list.get(j);
				int manhattan = getManhattan(p1, p2);
				if (manhattan < 2) {
					return 0;
				}
				if (manhattan == 2) {
					if (p1.y == p2.y) {
						if (map[p1.y][(p1.x + p2.x) / 2] == 'O') {
							return 0;
						}
					} else if (p1.x == p2.x) {
						if (map[(p1.y + p2.y) / 2][p1.x] == 'O') {
							return 0;
						}
					} else if (Math.abs(p1.y - p2.y) == 1 && Math.abs(p1.x - p2.x) == 1) {
						if (map[p1.y][p2.x] != 'X' || map[p2.y][p1.x] != 'X') {
							return 0;
						}
					}
				}
			}
		}

		return 1;
	}

	private static int getManhattan(Pair p1, Pair p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

	private static char[][] init(String[][] places, int idx) {
		char[][] map = new char[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = places[idx][i].charAt(j);
			}
		}

		return map;
	}

	private static class Pair {
		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[][] {
			{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
			{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
			{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
			{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
			{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
		})));
	}
}
