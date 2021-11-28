package Cho.week_3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main18258 {
	
	public static int[] queue = new int[2_000_000];
	
	public static int start = 0;
	public static int end = 0;
	
	public static void push(int x){
		queue[end] = x;
		end++;
	}
	public static int pop(){
		if(start == end){ //큐에 원소가 없다
			return -1;
		}
		int x = queue[start];
		start++;
		return x;
	}
	public static int size(){
		return end-start;
	}
	public static int empty(){
		if(start != end){ //같지 않으면 원소가 존재한다.
			return 0;
		}
		return 1;
	}
	public static int front(){
		if(start == end){
			return -1;
		}
		return queue[start];
	}
	public static int back(){
		if(start == end){
			return -1;
		}
		return queue[end-1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); //명령의 개수
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("push")){
				int a = Integer.parseInt(st.nextToken());
				push(a);
			}else if(str.equals("pop")){
				sb.append(pop()+"\n");
			}else if(str.equals("size")){
				sb.append(size()+"\n");
			}else if(str.equals("empty")){
				sb.append(empty()+"\n");
			}else if(str.equals("front")){
				sb.append(front()+"\n");
			}else if(str.equals("back")){
				sb.append(back()+"\n");
			}
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	
	}

}
