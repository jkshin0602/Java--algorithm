import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1934 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스
		int[] LCD = new int[T];
		
		for(int i=0; i<T; i++){
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int g = GCD(a,b);	//최대공약수
			LCD[i] = g* (a/g) * (b/g);
		}
		
		for(int i=0; i<T; i++){
			System.out.println(LCD[i]);
		}
		
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
