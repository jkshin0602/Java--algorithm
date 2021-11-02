import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main5585 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //지불할 돈 N
		N = 1000 - N;
		
		int coinType[] = {500, 100, 50, 10 ,5, 1};
		int cnt = 0;
		
		for(int i=0; i<coinType.length; i++){
			cnt += N/coinType[i];
			N %= coinType[i];
		}
		System.out.println(cnt);
	}

}
