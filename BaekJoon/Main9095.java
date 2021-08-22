import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9095 {
	
	public static int[] D; //메모리 제이션
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T =	Integer.parseInt(br.readLine()); //테스트 케이스 개수
		D = new int[11];
		for(int i=0; i<T; i++){
			int n = Integer.parseInt(br.readLine());
			System.out.println(add(n));
		}
		
	}
	//Top-down 방식 -시간복잡도 O(N)
	public static int add(int n){
		//종료 조건선언 
		if(n == 0 || n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		//점화식 : D[n] = D[n-1] + D[n-2] + D[n-3]
		D[n] = add(n-1) + add(n-2) + add(n-3);
		
		return D[n];
	}
	//Bottom-up 방식
	public static int add1(int n){
		D[0] = 1;
		D[1] = 1;
		D[2] = 2;
		for(int i=3; i<=n; i++){
			//점화식 : D[n] = D[n-1] + D[n-2] + D[n-3]
			D[i] = D[i-1] + D[i-2] + D[i-3];
		}
		return D[n];
	}

}
