package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class 두_큐_합_같게_만들기 {

	//길이가 같은 큐 두 개
	//하나의 큐를 골라 원소를 pop, 다른 큐에 push = 1회
	//두 큐의 원소 합이 같도록 만듦

	//가능한 경우의 수
	//1. q1 == q2
	//2. q1 -> q2(sum/2 < q1)
	//3. q2 -> q1(sum/2 > q2)

	public static int solution(int[] queue1, int[] queue2) {
		// 두 큐의 합을 구하기
		long queue1Sum = sumQueue(queue1);
		long queue2Sum = sumQueue(queue2);
		long sum = (queue1Sum + queue2Sum);

		// sum 이 홀수라면 답을 구할 수 없다.
		if (sum % 2 == 1) {
			return -1;
		}

		// 홀수가 아니면 /2
		sum /= 2;

		// 큐 선언
		Queue<Integer> q1 = Arrays.stream(queue1).boxed().collect(Collectors.toCollection(LinkedList::new));
		Queue<Integer> q2 = Arrays.stream(queue2).boxed().collect(Collectors.toCollection(LinkedList::new));

		int p1 = 0;
		int p2 = 0;
		int limit = queue1.length * 2;
		//p1과 p2가 모두 limit를 넘어가면 모든 탐색을 한 것
		while (p1 <= limit && p2 <= limit) {
			if (queue1Sum == sum) {
				return p1 + p2;
			}
			if (queue1Sum > sum) {
				queue1Sum -= q1.peek();
				queue2Sum += q1.peek();
				q2.add(q1.poll());
				p1++;
			} else {
				queue2Sum -= q2.peek();
				queue1Sum += q2.peek();
				q1.add(q2.poll());
				p2++;
			}
		}

		return -1;
	}

	private static long sumQueue(int[] queue) {
		return Arrays.stream(queue).sum();
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 2, 7, 2}, new int[] {4, 6, 5, 1}));
		System.out.println(solution(new int[] {1, 2, 1, 2}, new int[] {1, 10, 1, 2}));
		System.out.println(solution(new int[] {1, 1}, new int[] {1, 5}));
	}
}
