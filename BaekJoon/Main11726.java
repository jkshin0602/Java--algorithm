import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11726 {
	public static int[] tile;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		tile = new int[n+1]; //메모리제이션
		tile[0] = 0;
		tile[1] = 1; //n의 길이가 1이라면 채울방법은 (2x1) 타일밖에 넣지 못한다.
		tile[2] = 2; //배열의 0, 1, 2를 초기화 해줌
	
		System.out.println(tiling(n));
		
	}
	//Top-down 방식 (재귀)
	public static int tiling(int n){
		
		if(tile[n] > 0) { //메모한 것이 존재하면 그 값 반환
			return tile[n];
		}
		
		//D[n] = D[n-1] + D[n-2]
		tile[n] = tiling(n-1) + tiling(n-2); 
		
		return tile[n]%10007;
	}
	
	//Bottom-up 방식 (반복문)
	public static int tiling2(int n){

		for(int i=3; i<=n; i++){ //최소값 
			//D[n] = D[n-1] + D[n-2]
			tile[i] = tile[i-1] + tile[i-2];
		}
		
		return tile[n]%10007;
	}
}
