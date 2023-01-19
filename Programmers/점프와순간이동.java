package programmers;

public class 점프와순간이동 {

	//K칸을 앞으로 점프하거나
	//(현재까지온거리 x 2)에 해당하는 위치로 순간이동
	// 순간이동을 하면 건전지 사용 x
	// 점프하면 K 만큼 건전지 사용
	// N만큼 떨어진 거리로 이동

	// 홀수, 짝수 이용
	// 홀수 일때 1 추가
	// 5000 -> 2500 -> 1250 -> 625 = 624 + 1 ->
	// 312 -> 156 -> 78 -> 39 = 38 + 1 ->
	// 19 = 18 +1 -> 9 = 8+1 -> 4 -> 2 ->
	// 1 = 0+1 -> 0

	public static int solution(int n) {
		// return solution1(n);
		return Integer.bitCount(n);
	}

	private static int solution1(int n) {
		int ans = 0;
		while (n > 0) {
			if (n % 2 == 1) {
				ans++;
			}
			n /= 2;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(solution(5));
		System.out.println(solution(6));
		System.out.println(solution(5000));
		System.out.println(solution(1));

	}
}
