import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11727 {
	public static int[] tile;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		tile = new int[n+1]; //메모리제이션
	
		System.out.println(tiling(n));
		
	}
	//Top-down 방식 (재귀)
	public static int tiling(int n){
		
		if (n == 0 || n == 1){ //n의 길이가 1이라면 채울방법은 (2x1) 타일밖에 넣지 못한다.
			return 1; 
		}
		
		if(n == 2){
			return 3;  //2x2가 추가되었으므로 방법이 한가지 추가된다.
		}
		
		if(tile[n] > 0) { //메모한 것이 존재하면 그 값 반환
			return tile[n];
		}
		
		//D[n] = D[n-1] + D[n-2]*2
		tile[n] = tiling(n-1) + (tiling(n-2) * 2) ; 
		
		return tile[n] %= 10007; //나머지 계산을 계속 해주지 않으면 이전의 tile[n] 값이 맞지 않는다.
	}
	
	//Bottom-up 방식 (반복문)
	public static int tiling2(int n){
		tile[0] = 1;
		
		if(n > 0){
			tile[1] = 1;
			tile[2] = 3; //2x2가 추가되었으므로 방법이 한가지 추가된다.
		}
		
		for(int i=3; i<=n; i++){ //최소값 
			//D[n] = D[n-1] + D[n-2]
			tile[i] = tile[i-1] + (tile[i-2]*2);
			tile[i] %= 10007; //나머지 계산을 계속 해주지 않으면 이전의 tile[n] 값이 맞지 않는다.
		}
		
		return tile[n];
	}
	
}
	
