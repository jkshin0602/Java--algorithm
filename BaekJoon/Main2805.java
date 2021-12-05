package Cho.week_4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main2805 {

	public static int N;
	public static int M;
	public static int[] tree;
	public static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //나무의 수 N
		M = Integer.parseInt(st.nextToken()); //가져가려 하는 나무의 길이 M
		
		tree = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			tree[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree);
		parametric_search();
		System.out.println(ans);
		
	}

	public static void parametric_search(){
		int left = 0;
		int right = 1_000_000_000;
		while(left <= right){
			int mid = (left + right) / 2;
			long sum = 0;
			for(int i=0; i<N; i++){
				if(tree[i] - mid > 0){ //나무 - mid 가 0보다 크면(자를 수 있는 것)
					sum += tree[i] - mid;
				}
			}
			if(sum >= M){ //sum >= M 이면, 높이를 올린다
				ans = Math.max(ans, mid);
				left = mid + 1;
			}else{ //sum < M 이면, 높이를 낮춘다. (잘리는 개수가 더 많아짐)
				right = mid - 1;
			}
		}
	}
	
	
}
