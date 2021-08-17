import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main9613 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine()); //테스트 케이스 입력

		for (int i = 0; i < t; i++) {  
			StringTokenizer st = new StringTokenizer(br.readLine()); //수의 개수, 수 입력 받아서 자름 
			int n = Integer.parseInt(st.nextToken()); //수의 개수
			int a = 0; //배열에 넣기 위한 변수
			int[] token = new int[n]; //수를 넣기 위해 배열 선언

			while (st.hasMoreTokens()) { // 얻은 수를 배열에 집어넣기
				token[a] = Integer.parseInt(st.nextToken()); //한개씩 집어넣음
				a++; 
			}

			long result = 0; //합 (합이 int형을 벗어날 수 있으므로 long으로 선언)
			for (int j = 0; j < n-1; j++) { // (0,1) (0,2) (0,3) 0//(1,2) (1,3) // (2,3) <- 이런식으로 gcd의 합을 구하기 위해 반복문 선언
				for (int k = j+1; k < a; k++) {
					result = result + gcd(token[j], token[k]); //GCD의 합을 result에 넣어준다.
				}
			}
			sb.append(result).append("\n"); 
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}

	public static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

}
