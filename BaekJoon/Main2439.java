import java.util.Scanner;


public class Main2439 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		

		for(int i=1; i<=T;i++){
			for(int k=0; k<T-i; k++)
				System.out.print(" ");
			for(int j=0; j<i;j++){
				
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}

}
