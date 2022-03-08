package programmers;

public class New_ID_recommendation {

	public String solution(String new_id) {

		String answer = step1(step1(new_id));
		return answer;
	}

	public static String step1(String id) { // 대문자 -> 소문자
		return step2(id.toLowerCase());
	}

	public static String step2(String id) {

		char[] str = id.toCharArray();
		for (int i = 0; i < str.length; i++) {
			if (str[i] >= 'a' && str[i] <= 'z')
				continue;
			if (str[i] >= '0' && str[i] <= '9')
				continue;
			if (str[i] == '-')
				continue;
			if (str[i] == '_')
				continue;
			if (str[i] == '.')
				continue;
			str[i] = ' ';
		}
		return step3(String.valueOf(str).replaceAll(" ", ""));
	}

	public static String step3(String id) {

		char[] str = id.toCharArray();
		for (int i = 0; i < str.length - 1; i++) {
			if (str[i] == '.') {
				int idx = i + 1;
				while (true) {
					if (idx == str.length)
						break;
					if (str[idx] == '.') {
						str[idx] = ' ';
						idx++;
					} else
						break;
				}
			}
		}
		return step4(String.valueOf(str).replaceAll(" ", ""));
	}

	public static String step4(String id) {

		char[] str = id.toCharArray();
		if (str[0] == '.')
			str[0] = ' ';
		if (str[str.length - 1] == '.')
			str[str.length - 1] = ' ';
		return step5(String.valueOf(str).trim());
	}

	public static String step5(String id) {
		id = step6((id.equals("") ? "a" : id));
		return id;
	}

	public static String step6(String id) {
		id = step7((id.length() >= 16 ? id.substring(0, 15) : id));
		return id;
	}

	public static String step7(String id) {

		char c = id.charAt(id.length() - 1);
		while (id.length() < 3) {
			if (id.length() <= 2) {
				id += c;
			}
		}
		return id;
	}

}
