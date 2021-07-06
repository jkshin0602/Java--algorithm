import java.util.Scanner;


public class Main3052 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] num = new int[10];
		int[] result = new int[42];
		int cnt =0;
		for(int i=0; i<num.length;i++){
			num[i] = s.nextInt();
			result[num[i]%42]++;
		}
		for(int i=0; i<result.length; i++){
			if(result[i] != 0){
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}
