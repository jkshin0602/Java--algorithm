package book.nadongbin.문제.그리디;

import java.util.Arrays;

public class 모험가_길드 {

	//N명의 모험가를 대상으로 '공포도' 측정
	//공포도 X인 모험가는 반드시 X명 이상으로 구성한 모험가 그룹에 참여해야함
	//최대 몇 개의 모험가 그룹을 만들 수 있는지?

	public static int solution(int[] characters) {

		int ans = 0;
		int count = 0;

		Arrays.sort(characters);

		for (int character : characters) {
			count++;

			if (count >= character) {
				ans++;
				count = 0;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 3, 1, 2, 2}));
	}
}
