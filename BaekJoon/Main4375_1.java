
import java.util.Scanner;

public class Main4375_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			int num = 0;
			int ans = 1;
			while(true) {
				num = ((num * 10) + 1)%N; //오버플로우 방지 
				if(num == 0) {
					System.out.println(ans);
					break;
				}
				ans++;
			}
		}
	}
	
	
	
}
