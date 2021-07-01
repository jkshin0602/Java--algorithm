import java.util.Scanner;


public class Main11021 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] A = new int[T];
		int[] B = new int[T];
		
		for(int i=0;i<T;i++){
			A[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}
		for(int i=0; i<T;i++){
			System.out.println("Case #"+(i+1)+": "+(A[i]+B[i]));
		}

	}

}
