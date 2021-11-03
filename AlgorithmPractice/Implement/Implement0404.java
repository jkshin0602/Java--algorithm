package CodeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Implement0404 {
	
	public static int N, M, x, y, direction;
	//방문한 위치를 저장하기 위한 맵 
	public static int[][] d = new int[50][50];
	// 전체 맵 정보
	public static int[][] arr = new int[50][50];
	
	//북, 동, 남, 서 방향 정의
	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, 1, 0, -1};
	
	//왼쪽으로 회전
	public static void turn_left(){
		direction -= 1;
		if (direction == -1) direction = 3;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); // 맵의 세로 크기 N
		M = Integer.parseInt(st.nextToken()); // 맵의 가로 크기 M
		
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken()); //현재 캐릭터 좌표 x
		y = Integer.parseInt(st.nextToken()); //현재 캐릭터 좌표 y
		// 0 : 북 , 1 : 동, 2 : 남, 3: 서
		direction = Integer.parseInt(st.nextToken()); //캐릭터가 바라보고있는 방향
		d[x][y] = 1; //현재 좌표 방문처리
		
		//전체 맵 정보 입력
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
 			}
		}
		
		//시뮬레이션 시작
		int cnt = 1;
		int turn_time = 0;
		while(true){
			//왼쪽으로 회전
			turn_left();
			int nx = x + dx[direction];
			int ny = y + dx[direction];
			//회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
			if(d[nx][ny] == 0 && arr[nx][ny] == 0){
				d[nx][ny] = 1; //방문 확인
				x = nx;
				y = ny;
				cnt ++;
				turn_time = 0;
				continue;
			}
			//회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우 
			else turn_time ++;
			//네 방향 모두 가봤거나, 바다인 경우
			if(turn_time == 4){
				nx = x - dx[direction];
				ny = y - dy[direction];
				//뒤로 갈 수 있다면 이동
				if(arr[nx][ny] == 0){
					x = nx;
					y = ny;
				}
				//뒤가 바다인 경우
				else break;
				turn_time = 0;
			}
		}
		System.out.println(cnt);
	}

}
