import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int GCD = GCD(a, b);	//최대공약수
		
		//최대공약수를 이용해서 최소 공배수를 구할 수 있다.
		int LCD = (a/GCD)*(b/GCD)*GCD;  //최소공배수
		
		System.out.println(GCD);
		System.out.println(LCD);
		
	}
	
	//유클리드 호제법 사용 (재귀)
	public static int GCD(int a, int b){
		if(b == 0){
			return a;
		}else{
			return GCD(b, a%b);
		}
	}

}
