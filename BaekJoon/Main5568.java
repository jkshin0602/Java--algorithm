package Cho.week_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;


public class Main5568 {
		public static int N;
		public static int K;
		public static int cnt;
		public static String[] card;
		public static boolean[] check;
		public static int ans;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //카드 N장
		K = Integer.parseInt(br.readLine()); //선택할 카드 K장
		card = new String[N];
		for(int i=0; i<N; i++){
			card[i] = br.readLine();
		}
		check = new boolean[N];
		
		recursive("", 0);
		
		System.out.println(ans);
		
	}
	
	public static HashMap<String, Integer> map = new HashMap<String, Integer>();

	public static void recursive(String n, int cnt){
		
		if(cnt == K){ //선택할 카드 K 장 
			if(map.get(n) == null){
				map.put(n, 1);
				ans++;
			}
			return;
		}
		
		for(int i=0 ; i<N ; i++){
			if(check[i]) continue;
			check[i] = true;
			recursive(n+card[i], cnt+1);
			check[i] = false;
		}
		
	}
}
