package Cho.week_4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main13335 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //트럭의 개수 N
		int W = Integer.parseInt(st.nextToken()); //다리의 길이 W 
		int L = Integer.parseInt(st.nextToken()); //다리의 최대 하중 L
		
		Queue<Integer> truck = new LinkedList<Integer>(); //트럭의 무게
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N; i++){
			truck.offer(Integer.parseInt(st.nextToken())); 
		}

		int time = 0;
		int curWeight = 0;
		
		Queue<Integer> bridge = new LinkedList<Integer>();
		for(int i=0; i<W; i++){
			bridge.add(0); //다리를 빠져나가는데 W초만큼 걸리기 때문에 처음에 W만큼 넣어줌
		}
		
		while(!bridge.isEmpty()){
			time++; //1초후 트럭이 올라간다.
			curWeight -= bridge.poll(); //트럭이 다리밖으로 나가면 무게를 빼준다. (안나가면 0이 빠짐)
			if(!truck.isEmpty()){ //트럭이 남아 있다면 
				 if(truck.peek() + curWeight <= L){ // 다리에 더 올라갈 수 있다면
					 curWeight += truck.peek(); //다음 트럭을 추가한다.
					 bridge.offer(truck.poll()); //트럭을 다리에 추가한다.
				 }else{
					 bridge.offer(0); //못들어가면 0을 넣어줌 
				 }
			}
		}
		
		
		System.out.println(time);

	}

}
