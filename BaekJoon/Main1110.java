import java.util.Scanner;

public class Main1110 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int copy = N;
		int count = 0;
		
		while(true){
			N = ((N%10)*10) + (((N/10)+(N%10))%10);
			count++;
			
			if(copy == N){
				break;
			}
		}
		System.out.println(count);
	}

}
