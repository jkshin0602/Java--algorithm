package book.nadongbin.문제.이진탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 가사_검색 {

	public static List<ArrayList<String>> arr = new ArrayList<>();
	public static List<ArrayList<String>> reversedArr = new ArrayList<>();

	public static int[] solution(String[] words, String[] queries) {
		ArrayList<Integer> ans = new ArrayList<>();

		init(words);

		for (int i = 0; i < queries.length; i++) {
			String q = queries[i];
			int res = 0;
			if (q.charAt(0) != '?') { // 접미사
				res = countByRange(
					arr.get(q.length()),
					q.replaceAll("\\?", "a"),
					q.replaceAll("\\?", "z")
				);
			} else { // 접두사
				q = (new StringBuffer(q)).reverse().toString();
				res = countByRange(
					reversedArr.get(q.length()),
					q.replaceAll("\\?", "a"),
					q.replaceAll("\\?", "z")
				);
			}
			ans.add(res);
		}

		int[] answer = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			answer[i] = ans.get(i);
		}
		return answer;
	}

	private static void init(String[] words) {
		for (int i = 0; i < 10001; i++) {
			arr.add(new ArrayList<>());
			reversedArr.add(new ArrayList<>());
		}

		for (String word : words) {
			arr.get(word.length()).add(word);
			reversedArr.get(word.length()).add((new StringBuffer(word)).reverse().toString());
		}

		for (int i = 0; i < 10001; i++) {
			Collections.sort(arr.get(i));
			Collections.sort(reversedArr.get(i));
		}
	}

	public static int countByRange(ArrayList<String> arr, String leftValue, String rightValue) {
		int rightIndex = upperBound(arr, rightValue, 0, arr.size());
		int leftIndex = lowerBound(arr, leftValue, 0, arr.size());
		return rightIndex - leftIndex;
	}

	private static int lowerBound(ArrayList<String> arr, String target, int start, int end) {
		while (start < end) {
			int mid = (start + end) / 2;
			if (arr.get(mid).compareTo(target) >= 0)
				end = mid;
			else
				start = mid + 1;
		}
		return end;
	}

	private static int upperBound(ArrayList<String> arr, String target, int start, int end) {
		while (start < end) {
			int mid = (start + end) / 2;
			if (arr.get(mid).compareTo(target) > 0)
				end = mid;
			else
				start = mid + 1;
		}
		return end;
	}

	public static void main(String[] args) {
		System.out.println(
			Arrays.toString(solution(new String[] {"frodo", "front", "frost", "frozen", "frame", "kakao"},
				new String[] {"fro??", "????o", "fr???", "fro???", "rpo?"})));
	}

}
