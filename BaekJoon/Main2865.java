
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main2865 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //참가자 수 N
		int M = Integer.parseInt(st.nextToken()); //장르개수 M
		int K = Integer.parseInt(st.nextToken()); //본선 진출자 수 K
		
		//1. 한 사람이 여러 장르를 부를 수는 없지만, 여러 사람이 같은 장르를 부를 수는 있다.
		//-> 한 장르에서 한 명이상의 본선 진출자가 나온다 
		//2. 능력 점수로 정렬 
		//3. 본선 진출 참가자가 아니면 차례로 능력점수를 합한다. 
		
		ArrayList<Pair> p = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				float ability = Float.parseFloat(st.nextToken());
				p.add(new Pair(num, ability));
			}
		}
		
		// 오름차순 정렬 
		// 1 > 2 -> 양수 반환
		// 1 < 2 -> 음수 반환
		// 1 == 3 -> 0 리턴 
		
		//내림차순 정렬 
		// 2 > 1 -> 양수 반환
		// 2 < 1 -> 음수 반환 
		
		Collections.sort(p, new Comparator<Pair>() { // 능력점수 기준으로 리스트 정렬 
			@Override
			public int compare(Pair o1, Pair o2) {
				return Float.compare(o2.ability, o1.ability); //내림차순으로 정렬하기위해 앞뒤값을 반대로 바꿔줌 
			}
		});
		
		ArrayList<Integer> finallist = new ArrayList<>();
		float answer = 0.0f;
		for(Pair pair : p) {
			if(finallist.size() >= K) break;
			if(!finallist.contains(pair.num)) { //본선 참가자가 아니라면 
				answer += pair.ability; //답을 더해주고 
				finallist.add(pair.num); // 본선 참가자에 넣어준다.
			}else {
				continue;
			}
			
		}
		System.out.printf("%.1f\n", answer);

	}
	
	static class Pair{
		int num;
		float ability;
		
		public Pair(int num, float ability) {
			this.num = num;
			this.ability = ability;
		}
	}
	
}
