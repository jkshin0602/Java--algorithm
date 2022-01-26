
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2309_1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] height = new int[9];
		
		int sum = 0;
		for(int i=0; i<9; i++) {
			height[i] = Integer.parseInt(br.readLine());
			sum += height[i];
		}
		Arrays.sort(height);

		for(int i=0; i<9; i++) {
			for(int j=i+1; j<9; j++) {
				if(sum - height[i] - height[j] == 100) {
					for(int k=0; k<9; k++) {
						if(k == i || k == j) continue;
						System.out.println(height[k]);
					}
					return;
				}
			}
		}

	}

	
	
}
