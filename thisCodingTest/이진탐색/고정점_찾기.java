package book.nadongbin.문제.이진탐색;

public class 고정점_찾기 {

	//고정점 : 수열의 원소 중 그 값이 인덱스와 동일한 원소
	//고정점은 1개만 존재, 고정점이 없다면 -1 출력

	public static int solution(int N, int[] A) {
		return go(A, 0, N - 1);
	}

	private static int go(int[] A, int left, int right) {
		if (left > right) {
			return -1;
		}

		int mid = (left + right) / 2;

		if (A[mid] == mid) {
			return mid;
		}

		if (A[mid] > mid) {
			return go(A, left, mid - 1);
		} else {
			return go(A, mid + 1, right);
		}

	}

	public static void main(String[] args) {
		System.out.println(solution(5, new int[] {-15, -6, 1, 3, 7}));
		System.out.println(solution(7, new int[] {-15, -4, 2, 8, 9, 13, 15}));
		System.out.println(solution(7, new int[] {-15, -4, 3, 8, 9, 13, 15}));
	}
}
