package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main10825 {

	static List<Student> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Student(st.nextToken(),
				Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		list.sort(null);
		list.stream()
			.forEach(student -> System.out.println(student.name));
	}

	private static class Student implements Comparable<Student> {

		String name;
		int korea, english, math;

		public Student(String name, int korea, int english, int math) {
			this.name = name;
			this.korea = korea;
			this.english = english;
			this.math = math;
		}

		@Override
		public int compareTo(Student o) {
			if (korea != o.korea)
				return o.korea - this.korea;
			if (english != o.english)
				return this.english - o.english;
			if (math != o.math)
				return o.math - this.math;
			return name.compareTo(o.name);
		}
	}

}
