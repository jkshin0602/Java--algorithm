import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main10845 {
	
	public static int[] queue = new int[10000]; 
	public static int begin = 0;
	public static int end = 0;
	
	public static void push(int data){ 
		queue[end] = data;
		end++; 
	}
	
	public static int pop(){
		if(empty() == 1){
			return -1;
		}
		return queue[begin++];
	}
	
	public static int size(){
		return end - begin;
	}
	
	public static int empty(){
		if(begin == end){
			return 1;
		}else{
			return 0;
		}
	}
	
	public static int front(){
		if(empty() == 1){
			return -1;
		}
		return queue[begin];
	}
	
	public static int back(){
		if(empty() == 1){
			return -1;
		}
		return queue[end-1];
	}

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
		int N = Integer.parseInt(br.readLine()); //1. 명령 갯수 입력
		for(int i=0; i<N; i++){
			String input = br.readLine(); //2. 명령어 입력
			if(input.contains("push")){ //push $
				st = new StringTokenizer(input); 
				st.nextToken(); // "push"제거
				push(Integer.parseInt(st.nextToken()));			
			}else if(input.equals("pop")){
				sb.append(pop()).append("\n");
			}else if(input.equals("size")){
				sb.append(size()).append("\n");
			}else if(input.equals("empty")){
				sb.append(empty()).append("\n");
			}else if(input.equals("front")){
				sb.append(front()).append("\n");
			}else if(input.equals("back")){
				sb.append(back()).append("\n");
			}
		}// for문 종료
		
		
		//3. 명령어 결과 출력
		bw.write(sb.toString());
		//4. 버퍼 닫기
		bw.flush();
		bw.close();
		br.close();
	
		String str = " dd";
		str.split("d");
	}

}
