package book.nadongbin.정렬;

import java.util.Arrays;
import java.util.Comparator;

public class 성적이_낮은_순서로_학생_출력하기 {

	public static String[] solution(String[] datas) {
		Arrays.sort(datas, Comparator.comparing(o -> o.split(" ")[1]));

		return Arrays.stream(datas)
			.map(s -> s.split(" ")[0]).toArray(String[]::new);
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {
			"홍길동 95",
			"이순신 77"
		})));
	}
}
