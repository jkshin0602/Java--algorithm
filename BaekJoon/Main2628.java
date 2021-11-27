package Cho.week_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main2628 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken()); 
		int height = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(br.readLine()); //잘라야 하는 갯수
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(a == 0){ 
				B.add(b); //가로로 자르는 점선 
			}else{
				A.add(b); //세로로 자르는 점선
			}
		}
		
		//자르는 부위 정렬
		Collections.sort(A);  //세로로 자르는 점선
		Collections.sort(B); //가로로 자르는 점선 
		 
		int w = 0; //가장 긴 세로줄 -> 가로로 자르는 점선 (가로)
		int start = 0;  //세로줄의 시작점
		for(int i=0; i<A.size(); i++){
			 //마지막 자른 위치와 간격비교
			if(A.get(i)-start>w){ //자른위치 - 마지막으로 자른 위치 > 세로길이 보다 크다면
				w = A.get(i)-start; //w 길이 갱신
			}
			start = A.get(i); //시작점 갱신 
		}
		if(width-start > w){ //만약 종이의 세로 줄 - 마지막으로 자른 시작점이 w보다 크다면 
			w = width-start; //w값 갱신
		}
		
		int h = 0; //가장 긴 가로줄 -> 세로로 자르는 점선 (세로)
		start = 0; //가로줄의 시작점
		for(int i=0; i<B.size(); i++){
			//마지막 자른 위치와 간격 비교
			if(B.get(i) - start > h){  //자른위치 - 마지막으로자른 위치보다 가로길이 보다 크다면
				h = B.get(i) - start; //h 길이 갱신
			}
			start = B.get(i); //시작점 갱신
		}
		if(height-start > h){ //종이의 가로 줄 - 마지막 시작점 보다 h가 크다면 
			h = height-start; //h값 갱신
		}
		
		System.out.println(w * h);
		
		

	}

}
