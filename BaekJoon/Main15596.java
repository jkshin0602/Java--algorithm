import java.util.Scanner;


public class Main15596 {

	public static long sum(int[] a){
		long ans = 0;
		for(int i=0; i<a.length; i++){
			ans += a[i];
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] a = {1,2,3,4,5};
		System.out.println(sum(a));
	}

}
