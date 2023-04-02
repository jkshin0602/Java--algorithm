package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 후보키 {

	static List<Set<Character>> candidateKeys;
	static String[][] table;

	public static int solution(String[][] relation) {
		String columns = init(relation);

		for (int i = 1; i < table[0].length + 1; i++) {
			go(columns, new HashSet<>(), i);
		}

		return candidateKeys.size();
	}

	private static void go(String columns, Set<Character> out, int r) {
		if (r == 0) {
			if (isUnique(out) && isMinimal(out)) {
				candidateKeys.add(out);
			}
			return;
		}

		for (int i = 0; i < columns.length(); i++) {
			Set<Character> newOut = new HashSet<>(out);
			newOut.add(columns.charAt(i));
			go(columns.substring(i + 1), newOut, r - 1);
		}
	}

	private static boolean isUnique(Set<Character> key) {
		Set<String> set = new HashSet<>();
		for (String[] row : table) {
			StringBuilder sb = new StringBuilder();
			for (char col : key) {
				sb.append(row[col - '0']);
			}
			if (set.contains(sb.toString())) {
				return false;
			}
			set.add(sb.toString());
		}

		return true;
	}

	private static boolean isMinimal(Set<Character> key) {
		for (Set<Character> candidateKey : candidateKeys) {
			if (key.containsAll(candidateKey)) {
				return false;
			}
		}

		return true;
	}

	private static String init(String[][] relation) {
		table = relation;
		candidateKeys = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < table[0].length; i++) {
			sb.append(i);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[][] {
			{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"},
			{"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"},
			{"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}}));
	}
}
