package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main17829 {

	public static int N;
	public static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		pooling(map, N);

	}

	//1024 -> 512 -> 256 -> ... -> 2 -> 1 = 11번 호출
	//O(logN)

	public static void pooling(int[][] map, int size) {
		if (size == 2) {
			System.out.println(findSecond(map, 0, 0));
			return;
		}
		int nSize = size/2;
		int[][] newMap = new int[nSize][nSize];
		int ny = 0, nx = 0;

		for (int i = 0; i < size; i += 2) {
			for (int j = 0; j < size; j += 2) {
				newMap[ny][nx++] = findSecond(map, i, j);
			}
			nx = 0;
			ny++;
		}

		pooling(newMap, nSize);
		return;
	}

	public static int findSecond(int[][] map, int y, int x) {
		list = new ArrayList<>();
		list.add(map[y][x]);
		list.add(map[y][x + 1]);
		list.add(map[y + 1][x]);
		list.add(map[y + 1][x + 1]);
		list.sort(Comparator.reverseOrder());
		return list.get(1);
	}
}
