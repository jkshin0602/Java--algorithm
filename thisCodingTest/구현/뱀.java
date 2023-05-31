package book.nadongbin.문제.구현;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀 {

	//NxN 정사각 보드 위에서 진행
	//뱀은 매 초마다 이동을 한다.
	//뱀은 몸 길이를 늘려 머리를 다음칸에 위치시킨다.
	//만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과는 없어지고 꼬리는 움직이지 않는다.
	//만약 이동한 칸에 사과가 없다면, 몸 길이를 줄여서 꼬리가 위치한 칸을 비워준다. 몸길이는 변하지 않는다.
	//게임은 몇초에 끝나는가?

	//{동,남,서,북}
	private static int[] dy = {0, 1, 0, -1};
	private static int[] dx = {1, 0, -1, 0};
	private static ArrayList<Node> info;
	private static int[][] map;

	public static int solution(int N, int[][] apples, String[] snakes) {

		init(N, apples, snakes);

		return simulation(N);
	}

	private static void init(int N, int[][] apples, String[] snakes) {
		map = new int[N + 1][N + 1];

		// 맵 정보(사과가 있는 곳은 1로 표시)
		for (int i = 0; i < apples.length; i++) {
			int y = apples[i][0];
			int x = apples[i][0];
			map[y][x] = 1;
		}

		info = new ArrayList<>();
		for (String snake : snakes) {
			StringTokenizer st = new StringTokenizer(snake);
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			info.add(new Node(x, c));
		}
	}

	private static int simulation(int N) {
		int x = 1, y = 1; //뱀의 머리 위치
		map[y][x] = 2; //뱀이 존재하는 위치

		int direction = 0; //동쪽을 본다.
		int time = 0; //시작한 뒤에 지난 '초' 시간
		int index = 0; //다음에 회전할 정보

		//뱀의 차지고하고 있는 위치 정보
		Queue<Position> q = new LinkedList<>();
		q.add(new Position(y, x));

		while (true) {
			int ny = y + dy[direction];
			int nx = x + dx[direction];

			if (1 <= nx && nx <= N && 1 <= ny && ny <= N && map[ny][nx] != 2) {
				//사과가 없다면 이동 후에 꼬리 제거
				if (map[ny][nx] == 0) {
					map[ny][nx] = 2;
					q.offer(new Position(ny, nx));
					map[q.peek().y][q.poll().x] = 0;
				}

				//사과가 있다면 이동 후에 꼬리 그대로 두기
				if (map[ny][nx] == 1) {
					map[ny][nx] = 2;
					q.add(new Position(ny, nx));
				}
			} else {
				time++;
				break;
			}

			y = ny;
			x = nx;
			time++;
			if (index < info.size() && time == info.get(index).time) {
				direction = turn(direction, info.get(index).direction);
				index++;
			}
		}

		return time;
	}

	private static int turn(int direction, char c) {
		if (c == 'L') {
			direction = (direction == 0) ? 3 : direction - 1;
		} else {
			direction = (direction + 1) % 4;
		}

		return direction;
	}

	private static class Position {
		int y, x;

		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	private static class Node {
		int time;
		char direction;

		public Node(int time, char direction) {
			this.time = time;
			this.direction = direction;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(6, new int[][] {{3, 4}, {2, 5}, {5, 3}}, new String[] {"3 D", "15 L", "17 D"}));
		System.out.println(
			solution(10, new int[][] {{1, 2}, {1, 3}, {1, 4}, {1, 5}}, new String[] {"8 D", "10 D", "11 D", "13 L"}));
		System.out.println(solution(10, new int[][] {{1, 5}, {1, 3}, {1, 2}, {1, 6}, {1, 7}},
			new String[] {"8 D", "10 D", "11 D", "13 L"}));
	}
}
