import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main10866 {
	
	public static ArrayList<Integer> deque = new ArrayList<Integer>();
	
	public static void push_front(int num){
		deque.add(0, num); // list의 첫번째에 추가
	}
	
	public static void push_back(int num){
		deque.add(num); // list의 마지막에 추가
	}
	
	public static int pop_front(){
		if(empty() == 1){ //list가 비어있다면 
			return -1;
		}else{
			return deque.remove(0); //list의 첫번째 제거
		}
	}
	
	public static int pop_back(){
		if(empty() == 1){ //list가 비어있다면 
			return -1;
		}else{
			return deque.remove(deque.size()-1); //list의 마지막 제거
		}
	}
	
	public static int size(){
		return deque.size(); 
	}
	
	public static int empty(){
		if(deque.size() == 0){
			return 1;
		}else{
			return 0;
		}
	}

	public static int front(){
		if(empty() == 1){ // list가 비어있다면
			return -1;
		}
		return deque.get(0);  // list의 첫번째 원소 반환 
	}
	
	public static int back(){
		if(empty() == 1){ // list가 비어있다면
			return -1;
		}
		return deque.get(deque.size()-1);  // list의 마지막 원소 반환
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 명령의 수 입력
		for(int i=0; i<N; i++){
			String input = br.readLine(); //명령어 입력 
			if(input.contains("push_front")){
				st = new StringTokenizer(input);
				st.nextToken(); // 명령어 제거
				push_front(Integer.parseInt(st.nextToken())); //숫자 입력
			}else if(input.contains("push_back")){
				st = new StringTokenizer(input);
				st.nextToken(); // 명령어 제거
				push_back(Integer.parseInt(st.nextToken())); //숫자 입력
			}else if(input.equals("pop_front")){
				sb.append(pop_front()).append("\n");
			}else if(input.equals("pop_back")){
				sb.append(pop_back()).append("\n");
			}else if(input.equals("size")){
				sb.append(size()).append("\n");
			}else if(input.equals("empty")){
				sb.append(empty()).append("\n");
			}else if(input.equals("front")){
				sb.append(front()).append("\n");
			}else if(input.equals("back")){
				sb.append(back()).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}

}
