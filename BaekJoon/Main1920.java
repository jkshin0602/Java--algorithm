package Cho.week_4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main1920 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Long, Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			map.put(Long.parseLong(st.nextToken()), 0);
		}
		
		int M = Integer.parseInt(br.readLine());
		Long[] b = new Long[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++){
			b[i] = Long.parseLong(st.nextToken());
		}
		
		for(int i=0; i<M; i++){
			if(map.get(b[i]) != null ){
				System.out.println(1);
			}else{
				System.out.println(0);
			}
		}
		
		

	}

}
