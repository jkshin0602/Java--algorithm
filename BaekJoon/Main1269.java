
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main1269 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> Aset = new HashSet<Integer>();
		HashSet<Integer> Bset = new HashSet<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<A; i++) {
			Aset.add(Integer.parseInt(st.nextToken()));
		}
		
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<B; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(Aset.contains(a)) {
				cnt++;
			}else {
				Bset.add(a);
			}
		}
		
		// A원소개수 + B원소개수 - (중복값 * 2)<- 양쪽의 갯
		bw.write(String.valueOf(A+B - (cnt * 2)));
		bw.flush();
		bw.close();
		br.close();
		
	}

}
