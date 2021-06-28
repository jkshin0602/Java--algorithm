import java.util.Scanner;


public class Main2739 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt();
		int[] result = new int[9];
		for(int i=1; i<=result.length; i++)
			System.out.println(N+" * "+i+" = "+N*i);
		
	}

}
