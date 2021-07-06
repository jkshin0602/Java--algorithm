import java.util.Scanner;

public class Main10818 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int[] arr = new int[T];
		
		for (int i = 0; i < arr.length; i++)
			arr[i] = s.nextInt();
		
		int max= arr[0];
		int min = arr[0];
		
		for (int i = 1; i < arr.length; i++){
			if(max<arr[i]){
				max= arr[i];
			}
			if(min>arr[i]){
				min = arr[i];
			}
		}
		System.out.println(min+" "+max);
			
	}

}
