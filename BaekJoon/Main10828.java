import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main10828 {

	public static int[] stack;
	public static int size = 0;

	public static void push(int item) {
		stack[size] = item;
		size++;
	}

	public static int pop() {
		if (size == 0) {
			return -1;
		} else {
			int n = stack[size - 1];
			stack[size - 1] = 0;
			size--;
			return n;
		}
	}

	public static int top() {
		if (size == 0) {
			return -1;
		} else {
			int n = stack[size - 1];
			return n;
		}
	}

	public static int empty() {
		if (size == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int size() {
		return size;
	}

	public static void main(String[] args)  {
		Scanner bf = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = bf.nextInt();
		stack = new int[N];

		for (int i = 0; i < N; i++) {
			String str = bf.next();

			if (str.equals("push")) {
				push(bf.nextInt());
			} else if (str.equals("pop")) {
				sb.append(pop()).append('\n');
			} else if (str.equals("size")) {
				sb.append(size()).append('\n');
			} else if (str.equals("top")) {
				sb.append(top()).append('\n');
			} else if (str.equals("empty")) {
				sb.append(empty()).append('\n');
			} else if (str.equals("size")) {
				sb.append(size()).append('\n');
			}
		}
		System.out.println(sb);
	}

}
