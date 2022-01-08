
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main4055 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int c = -1;
		int day = 0;
		while(true) {
			day++;
			c = Integer.parseInt(br.readLine());
			if(c == 0) break;
			
			Pair[] party = new Pair[c];
			for(int i=0; i<c; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				party[i] = new Pair(s,e);
			}
			
			Arrays.sort(party); //시작시간과 종료시간이 빠른순으로 정렬 
			// 파티 시간 8 ~ 24시 -> 16시간 , 30분씩 있어야 한다. 16 x	2 = 32 
			
			int[] check = new int[25]; // 1~24까지 사용 (시간) 
			int ans = 0;
			
			for(int i=0; i<c; i++) {
				Pair pair = party[i];
				int s = pair.s;
				int e = pair.e;
					
				//시간 배열 0 = 파티참여안하는시간, 1 = 파티참여, 2= 파티참여 ,그이상 파티참여 안하는 시간 
				for(int j=s; j<e; j++) {
					if(check[j] == 0) { 
						check[j]++;
						ans++;
						break;
					}
					if(check[j] == 1) {
						check[j]++;
						ans++;
						break;
					}
				}
			}

			System.out.println("On day "+day+" Emma can attend as many as "+ans+" parties.");
			
		}
	}
	
	// 12 14 , 12 14, 12 14, 12 15, 13 14 
	// 12배열++, 12배열++, 13배열++, 13배열 ++ , 13배열이 꽉차서 파티 참여 불가  -> 시작시간을 정렬기준에서 제거 
	
	static class Pair implements Comparable<Pair>{
			
		public int s; //시작 시간
		public int e; //종료 시간
			
		public Pair(int s, int e) {
			this.s = s;
			this.e = e;
		}
			
		@Override
		public int compareTo(Pair p) {	//파티가 끝나는 시간이 빠른순으로 정렬 
//			if(this.s < p.s){
//				return -1;
//			}
//			else if(this.s > p.s) {
//				return 1;
//			}
//			else  
				if(this.e < p.e) {
				return -1;
			}
			else if(this.e > p.e) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
	}
		
	
}
