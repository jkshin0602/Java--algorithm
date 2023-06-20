package book.nadongbin.문제.정렬;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 국영수 {

	public static String[] solution(int N, String[] info) {
		Student[] result = Student.from(info);

		Arrays.sort(result);

		return Student.from(result);
	}

	private static class Student implements Comparable<Student> {
		String name;
		int korean, english, math;

		private Student(String info) {
			StringTokenizer st = new StringTokenizer(info);
			this.name = st.nextToken();
			this.korean = Integer.parseInt(st.nextToken());
			this.english = Integer.parseInt(st.nextToken());
			this.math = Integer.parseInt(st.nextToken());
		}

		public static Student[] from(String[] info) {
			Student[] result = new Student[info.length];

			for (int i = 0; i < result.length; i++) {
				result[i] = new Student(info[i]);
			}

			return result;
		}

		public static String[] from(Student[] info) {
			String[] result = new String[info.length];

			for (int i = 0; i < info.length; i++) {
				result[i] = info[i].name;
			}

			return result;
		}

		@Override
		public int compareTo(Student o) {
			if (this.korean == o.korean && this.english == o.english && this.math == o.math) {
				return this.name.compareTo(o.name);
			}

			if (this.korean == o.korean && this.english == o.english) {
				return o.math - this.math;
			}

			if (this.korean == o.korean) {
				return this.english - o.english;
			}

			return o.korean - this.korean;
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(12, new String[] {"Junkyu 50 60 100"
			, "Sangkeun 80 60 50", "Sungyoung 80 70 100", "Soong 50 60 90", "Haebin 50 60 100",
			"Kangsoo 60 80 100", "Donghyuk 80 60 100", "Sei 70 70 70", "Wonseob 70 70 90",
			"Sanghyun 70 70 80", "nsj 80 80 80", "Taewhan 50 60 90"})));
	}
}
