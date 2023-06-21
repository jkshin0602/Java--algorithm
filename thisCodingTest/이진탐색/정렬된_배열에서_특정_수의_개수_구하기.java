package book.nadongbin.문제.이진탐색;

public class 정렬된_배열에서_특정_수의_개수_구하기 {

	public static int solution(int N, int x, int[] nums) {

		int firstIdx = findFirstX(nums, x, 0, N - 1);

		if (firstIdx == 0) {
			return -1;
		}

		int lastIdx = findLastX(nums, x, 0, N - 1);

		return lastIdx - firstIdx + 1;
	}

	private static int findLastX(int[] nums, int x, int left, int right) {
		if (left > right) {
			return 0;
		}

		int mid = (left + right) / 2;

		if ((mid == nums.length - 1 || x < nums[mid + 1]) && nums[mid] == x) {
			return mid;
		} else if (nums[mid] > x) {
			return findLastX(nums, x, left, mid - 1);
		} else {
			return findLastX(nums, x, mid + 1, right);
		}
	}

	private static int findFirstX(int[] nums, int x, int left, int right) {
		if (left > right) {
			return 0;
		}

		int mid = (left + right) / 2;

		if ((mid == 0 || x > nums[mid - 1]) && nums[mid] == x) {
			return mid;
		} else if (nums[mid] >= x) {
			return findFirstX(nums, x, left, mid - 1);
		} else {
			return findFirstX(nums, x, mid + 1, right);
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(7, 2, new int[] {1, 1, 2, 2, 2, 2, 3}));
		System.out.println(solution(7, 4, new int[] {1, 1, 2, 2, 2, 2, 3}));
	}
}
