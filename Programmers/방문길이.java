package programmers;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class 방문길이 {

	private static char[] dir = new char[] {'U', 'D', 'R', 'L'};
	private static int[] dy = new int[] {-1, 1, 0, 0};
	private static int[] dx = new int[] {0, 0, 1, -1};
	private static Set<Point> set;

	public static int solution(String dirs) {
		set = new HashSet<>();

		Point lastPoint = init(dirs.charAt(0));

		for (int i = 1; i < dirs.length(); i++) {
			char nextCommand = dirs.charAt(i);
			for (int j = 0; j < 4; j++) {
				if (nextCommand == dir[j]) {
					int ny = dy[j] + lastPoint.toY;
					int nx = dx[j] + lastPoint.toX;
					if (ny < -5 || nx < -5 || ny > 5 || nx > 5) {
						break;
					}
					lastPoint = put(lastPoint.toY, lastPoint.toX, ny, nx);
					break;
				}
			}
		}

		return set.size();
	}

	private static Point init(char c) {
		Point lastPoint;

		if (c == 'U') {
			lastPoint = put(0, 0, -1, 0);
		} else if (c == 'D') {
			lastPoint = put(0, 0, 1, 0);
		} else if (c == 'R') {
			lastPoint = put(0, 0, 0, 1);
		} else {
			lastPoint = put(0, 0, 0, -1);
		}

		return lastPoint;
	}

	private static Point put(int fromY, int fromX, int toY, int toX) {
		Point point = new Point(fromY, fromX, toY, toX);
		set.add(point);
		return point;
	}

	private static class Point {
		int fromY, fromX;
		int toY, toX;

		public Point(int fromY, int fromX, int toY, int toX) {
			this.fromY = fromY;
			this.fromX = fromX;
			this.toY = toY;
			this.toX = toX;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof Point))
				return false;
			Point point = (Point)o;
			return (fromY == point.fromY && fromX == point.fromX && toY == point.toY && toX == point.toX)
				|| (fromY == point.toY && fromX == point.toX && toY == point.fromY && toX == point.fromX);
		}

		@Override
		public int hashCode() {
			return Objects.hash(toY, toX, fromY, fromX) + Objects.hash(fromY, fromX, toY, toX);
		}

	}

	public static void main(String[] args) {
		System.out.println(solution("ULURRDLLU"));
		System.out.println(solution("LULLLLLLU"));
		System.out.println(solution("UDDUUD"));
	}

}
