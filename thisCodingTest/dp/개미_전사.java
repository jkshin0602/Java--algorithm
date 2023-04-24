package book.nadongbin.dp;

import java.util.Arrays;

public class 개미_전사 {

	//D[i-2]를 털 경우 -> D[i]는 털 수 있다.
	//D[i-1]를 털 경우 -> D[i]는 털 수 없다.
	//D[i] = max(D[i-2] + A[i], D[i-1])

	public static int solution(int[] storage) {

		int[] D = new int[storage.length ];
		D[0] = storage[0];
		D[1] = storage[1];

		for (int i = 2; i < storage.length; i++) {
			D[i] = Math.max(D[i - 2] + storage[i], D[i - 1]);
		}

		return D[storage.length - 1];
	}


	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 3, 1, 5}));
	}
}
