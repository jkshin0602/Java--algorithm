import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2309 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 9;
		int[] A = new int[N];
		int sum = 0;
		for(int i=0; i<N; i++){
			A[i] = Integer.parseInt(br.readLine());
			sum += A[i]; //9명의 키의 합
		}
		Arrays.sort(A);

		for(int i=0; i<N; i++){
			for(int j=i+1; j<N; j++){
				if(sum - A[i] - A[j] == 100){
					for(int k=0; k<N; k++){
						if(j == k || i == k) continue;
						System.out.println(A[k]);
					}
				 return;
				}
			}
		}
	}

}
