package programmers;

public class 점_찍기 {

	public static long solution(int k, int d) {
		long answer = 0;

		for (int x = 0; x <= d; x += k) {
			long nx = (long)Math.pow(x, 2);
			long nd = (long)Math.pow(d, 2);
			int result = (int)Math.sqrt(nd - nx);
			answer += (result / k) + 1;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(2, 4));
		System.out.println(solution(1, 5));
	}
}
