package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 튜플 {

	//중복된 원소 허용
	//원소의 순서가 다르면 서로 다른 튜플
	//원소의 개수는 유한

	public static int[] solution(String s) {
		List<List<Integer>> list = initList(s);
		List<Integer> answer = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			List<Integer> integers = list.get(i);
			Integer a = integers.get(0);
			answer.add(a);
			for (int j = i; j < list.size(); j++) {
				List<Integer> integers1 = list.get(j);
				integers1.remove(a);
				list.set(j, integers1);
			}
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}

	private static List<List<Integer>> initList(String s) {
		StringTokenizer st = new StringTokenizer(s.substring(1, s.length() - 1), "}");
		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < st.countTokens(); i++) {
			list.add(new ArrayList<>());
		}

		int idx = 0;
		String tmp = st.nextToken().substring(1);
		StringTokenizer st1 = new StringTokenizer(tmp, ",");
		while (st1.hasMoreTokens()) {
			list.get(idx).add(Integer.parseInt(st1.nextToken()));
		}
		idx++;

		while (st.hasMoreTokens()) {
			tmp = st.nextToken().substring(2);
			st1 = new StringTokenizer(tmp, ",");
			while (st1.hasMoreTokens()) {
				list.get(idx).add(Integer.parseInt(st1.nextToken()));
			}
			idx++;
		}

		list.sort(Comparator.comparingInt(List::size));

		return list;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
		System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
		System.out.println(Arrays.toString(solution("{{20,111},{111}}")));
		System.out.println(Arrays.toString(solution("{{123}}")));
		System.out.println(Arrays.toString(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
	}
}
