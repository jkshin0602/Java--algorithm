package programmers;

import java.util.ArrayList;
import java.util.List;

public class 수식_최대화 {

	// 우선순위 경우의 수 6
	// * + -
	// * - +
	// + * -
	// + - *
	// - * +
	// - + *

	public static long solution(String expression) {

		List<Long> num = new ArrayList<>();
		List<String> operator = new ArrayList<>();
		init(expression, num, operator);

		long ans = 0;
		ans = max(new ArrayList<>(num), new ArrayList<>(operator), "*", "+", "-", ans);
		ans = max(new ArrayList<>(num), new ArrayList<>(operator), "*", "-", "+", ans);
		ans = max(new ArrayList<>(num), new ArrayList<>(operator), "+", "*", "-", ans);
		ans = max(new ArrayList<>(num), new ArrayList<>(operator), "+", "-", "*", ans);
		ans = max(new ArrayList<>(num), new ArrayList<>(operator), "-", "*", "+", ans);
		ans = max(new ArrayList<>(num), new ArrayList<>(operator), "-", "+", "*", ans);

		return ans;
	}

	private static long max(List<Long> num, List<String> operator, String operator1, String operator2, String operator3,
		long ans) {
		long result = 0;
		int idx = 0;

		while (!operator.isEmpty()) {
			if (operator.contains(operator1)) {
				idx = operator.indexOf(operator1);
			} else if (operator.contains(operator2)) {
				idx = operator.indexOf(operator2);
			} else {
				idx = operator.indexOf(operator3);
			}

			if (idx == -1) {
				break;
			}

			long f = num.remove(idx);
			long e = num.remove(idx);
			String c = operator.remove(idx);

			if (c.equals("*")) {
				result = f * e;
			} else if (c.equals("+")) {
				result = f + e;
			} else {
				result = f - e;
			}
			num.add(idx, result);
		}

		return Math.max(ans, Math.abs(result));
	}

	private static void init(String expression, List<Long> num, List<String> operator) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c >= '0' && c <= '9') {
				sb.append(c - '0');
			} else {
				num.add(Long.parseLong(sb.toString()));
				sb = new StringBuilder();
				operator.add(String.valueOf(c));
			}
		}
		num.add(Long.parseLong(sb.toString()));
	}

	public static void main(String[] args) {
		System.out.println(solution("100-200*300-500+20"));
		System.out.println(solution("50*6-3*2"));
	}

}
