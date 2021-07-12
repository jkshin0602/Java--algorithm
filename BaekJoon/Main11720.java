import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11720 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(bf.readLine());
		String num = bf.readLine();
		int number =0;
		int sum = 0;
		for(int i=0; i<N; i++){
			number = num.charAt(i)- '0';
			sum += number;
		}
		System.out.println(sum);
	}

}
