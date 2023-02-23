package programmers;

public class 스킬트리 {

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;

		if (skill.length() == 1) {
			return skill_trees.length;
		}

		for (int i = 0; i < skill_trees.length; i++) {
			String tmp = skill_trees[i].replaceAll("[^" + skill + " ]", "");

			if (tmp.equals("")) { //선행 스킬 조건에 속해있지 않다면 문자열은 ""만 남아있다.
				answer++;
				continue;
			}

			for (int j = 1; j <= skill.length(); j++) {
				if (skill.substring(0, j).equals(tmp)) {
					answer++;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"}));
		System.out.println(solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA", "AQWER"}));
	}

}
