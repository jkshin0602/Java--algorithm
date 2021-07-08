public class Main4673 {

	/* public static int d(int number){
	        int sum = number;

	        while(number != 0){
	            sum = sum + (number % 10); // 첫 째 자리수
	            number = number/10; // 10으로 나누어 첫 째 자리 삭제
	        }

	        return sum;
	    }*/
	
	public static void main(String[] args) {
		int result = 0;
		int[] notSelfNum = new int[10001];

		for (int n = 1; n <= 10000; n++) {
			if (n < 10) {
				result = n + n;
				notSelfNum[result] = n;
			} else if (n < 100) {
				result = n + (n / 10) + (n % 10);
				notSelfNum[result] = n;
			} else if (n < 1000) {
				result = n + (n / 100) + (n % 100 / 10) + (n % 100 % 10);
				notSelfNum[result] = n;
			} else if (n <= 10000) {
				result = n + (n / 1000) + (n % 1000 / 100)
						+ (n % 1000 % 100 / 10) + (n % 1000 % 100 % 10);
				if (result > 10000)
					continue;
				notSelfNum[result] = n;
			}
		}

		for (int n = 1; n <= 10000; n++) {
			if (notSelfNum[n] == 0) {
				System.out.println(n);
			}
		}

	}

}
