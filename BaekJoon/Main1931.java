import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main1931 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //회의 수 N 
		int[][] time = new int[N][2];
		// time[][0] = 시작시간
		// time[][1] = 종료시간
		
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1] == o2[1]){ //종료시간이 같으면
					return o1[0] - o2[0]; //시작시간이 빠른순으로 정렬
				}
				return o1[1] - o2[1];
			}
		});
		
		int cnt = 0;
		int endTime = 0;
		
		for(int i=0; i<N; i++){
			
			//종료시간이 다음 회의 시작 시간보다 작거나 같으면 갱신
			if(endTime <= time[i][0]){
				endTime = time[i][1];
				cnt ++;
			}
		}
		System.out.println(cnt);
		
	}

}
