package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 줄_서는_방법 {

	public static int[] solution(int n, long k) {
		List<Integer> list = new ArrayList<>();
		int[] answer = new int[n];
		long fn = 1;
		for (int i = 1; i <= n; i++) {
			fn *= i;
			list.add(i);
		}
		k--;

		int idx = 0;
		while (n > 0) {
			//숫자를 고정시킨다고 가정하고 나오는 경우의 수
			fn /= n;
			//들어갈 숫자 결정
			answer[idx++] = list.get((int)(k / fn));
			list.remove((int)(k / fn));
			k %= fn;
			n--;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3, 5)));
	}
}
