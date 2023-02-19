package programmers;

import java.util.Arrays;

public class 두개이하로다른비트 {

	// f(x) = x 보다 크고 x와 비트가 1~2개 다른 수 들 중에서 제일 작은수
	// 2 = 000...0010
	// 3 = 000...0011
	// 4 = 000...0100
	// 5 = 000...0101
	// 6 = 000...0110
	// 7 = 000...0111
	// 8 = 000...1000
	// 9 = 000...1001
	// 10 = 000...1010
	// 11 = 000...1011
	// 12 = 000...1100
	// 13 = 000...1101
	// 14 = 000...1110
	// 15 = 000...1111
	// 16 = 000..10000
	// 17 = 000..10001
	// 18 = 000..10010
	// 19 = 000..10011
	// 20 = 000..10100
	// 21 = 000..10101
	// 22 = 000..10110
	// 23 = 000..10111
	// 24 = 000..11000
	// 25 = 000..11001

	//1 <= numbers.length <= 100,000
	//0 <= numbers[i] <= 10^15 = 1,000,000,000,000,000 (천조)

	// 2, 4, 8, 16 , 32 -> 비트수가 한자리 늘어나는 구간
	// i % 4 ==3 -> i+1 이 아닌 곳
	// f(1) = 2
	// f(2) = 3
	// f(3) = 5 ---
	// f(4) = 5
	// f(5) = 7
	// f(6) = 7
	// f(7) = 11 ---
	// f(8) = 9
	// f(9) = 10
	// f(10) = 11
	// f(11) = 13 ---
	// f(12) = 13
	// f(13) = 14
	// f(14) = 15
	// f(15) = 23 ---
	// f(16) = 17
	// f(17) = 18
	// f(18) = 19
	// f(19) = 21 ---
	// f(20) = 21
	// f(21) = 22
	// f(22) = 23
	// f(23) = 27 ---

	public static long[] solution(long[] numbers) {

		long[] answer = new long[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 4 != 3) {
				answer[i] = numbers[i] + 1;
				continue;
			}

			String bit = Long.toBinaryString(numbers[i]);

			if (!bit.contains("0")) { // 0이 없으면
				bit = 0 + bit;
				bit = String.valueOf(bit.charAt(1)) + bit.charAt(0) + bit.substring(2);
			} else {
				int x = bit.lastIndexOf("0");
				bit = bit.substring(0, x) + "10" + bit.substring(x + 2);
			}
			answer[i] = toBinary(bit);
		}

		return answer;
	}

	private static long toBinary(String bit) {
		bit = new StringBuilder(bit).reverse().toString();
		long ans = 0;
		long x = 1L;
		for (int i = 0; i < bit.length(); i++) {
			if (bit.charAt(i) == '1') {
				ans += x;
			}
			x *= 2;
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new long[] {1_000_000_000_000_000L})));
		System.out.println(Arrays.toString(solution(new long[] {2, 7})));
		System.out.println(Arrays.toString(solution(new long[] {343, 779, 891})));//347,781, 893
	}
}
