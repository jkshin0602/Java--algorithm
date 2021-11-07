package CodeTest;

import java.util.ArrayList;

public class BFS_DFS0507 {
	
	//행 (Row)이 3개인 인접 리스트로 표현
	public static ArrayList<ArrayList<Node1>> graph = new  ArrayList<ArrayList<Node1>>();
	
	public static void main(String[] args) {
		
		//그래프 초기화
		for(int i=0; i<3; i++){
			graph.add(new ArrayList<Node1>());
		}
		
		//노드 0에 연결된 노드 정보 저장 (노드, 거리)
		graph.get(0).add(new Node1(1, 7));
		graph.get(0).add(new Node1(2, 5));
		
		//노드 1에 연결된 노드 정보 저장 (노드, 거리)
		graph.get(1).add(new Node1(0, 7));
		
		//노드 2에 연결된 노드 정보 저장 (노드, 거리)
		graph.get(2).add(new Node1(0, 5));
		
		//그래프 출력
		for(int i=0; i<3; i++){
			for(int j=0; j<graph.get(i).size(); j++){
				graph.get(i).get(j).show();
			}
			System.out.println();
		}
	}

}

class Node1 {

    private int index;
    private int distance;

    public Node1(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public void show() {
        System.out.print("(" + this.index + "," + this.distance + ") ");
    }
}



