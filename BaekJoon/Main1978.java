import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main1978 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int cnt = 0; //소수 개수 
		
		for(int i=0; i<N; i++){
			if(prime(Integer.parseInt(st.nextToken())) == true){
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static boolean prime(int n){
		if(n < 2){
			return false;
		}
		for(int i=2; i*i<=n; i++){
			if(n%i == 0){
				return false;
			}
		}
		return true;
	}
}
