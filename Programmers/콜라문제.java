package programmers;

public class 콜라문제 {

	public static int solution(int a, int b, int n) {
		int cola = 0;
		while (n >= a) {
			cola += (n / a) * b;
			n = (n / a) * b + (n % a);
		}

		return cola;
	}

	public static void main(String[] args) {
		System.out.println(solution(2, 1, 20));
		System.out.println(solution(3, 1, 20));
		System.out.println(solution(3,2,20));
	}

}
