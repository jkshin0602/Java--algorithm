import java.util.Scanner;

public class Main2562 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] arr = new int[9];
		
		for(int i=0; i<arr.length; i++){
			arr[i] = s.nextInt();
		}
		int max = arr[0];
		int index = 1;
		
		for(int i=1; i<arr.length; i++){
			if(arr[i] > max){
				max = arr[i];
				index = i+1;
			}
		}
		System.out.println(max);
		System.out.println(index);
		

	}

}
