
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1629 {
	
	static long A,B,C;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		System.out.println(squared(A, B));
		
	}
	
	public static long squared(long A, long B){
		if(B == 1) return A % C;
		
		long tmp = squared(A, B/2); //반으로 나눠 연산 
		
		tmp = (tmp * tmp) % C; //반으로 나눈 값을 두번 곱하면 된다.
		// a^8 = a^4 * a^4
		if(B % 2 == 1) { //만약 B가 홀수이면 
			// a^9 = a^4 * a^4 * a^1
			tmp = (tmp * A) % C;
		}
		return tmp;
	}

}
