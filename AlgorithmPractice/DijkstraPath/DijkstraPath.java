import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;


public class DijkstraPath {

//	최단 경로 문제란?
//	두 노드를 잇는 가장 짧은 경로를 찾는 문제
//	가중치 그래프(Weighted Graph)에서 간선(Edge)의 가중치 합이 최소가 되도록 하는 경로를 찾는 것이 목적
//	
//	최단 경로 문제
//	1. 단일 출발(single-source) 최단 경로 문제
//		그래프 내의 특정 노드 u에서 출발하여, 그래프 내의 모든 다른 노드에 도착하는 가장 짧은 경로를 찾는 문제
//	2. 단일 도착(single-destination) 최단 경로 문제
//		모든 노드들로부터 출발해서, 그래프 내의 특정 노드 u로 도착하는 가장 짧은 경로를 찾는 문제
//	3. 단일 쌍(single-pair) 최단 경로 문제
//		주어진 노드 u와 v간의 최단 경로를 찾는 문제
//	4. 전체 쌍(all-pair) 최단 경로 문제
//		그래프 내의 모든 노드 쌍(u,v) 사이에 대한 최단 경로를 찾는 문제
	
//	최단 경로 알고리즘 - 다익스트라 알고리즘
//	다익스트라 알고리즘은 위의 최단 경로 묹 종류 중 1번에 해당
//		하나의 정점에서 다른 모든 정점에 도착하는 가장 짧은 거리를 구하는 문제
		
//	다익스트라 알고리즘 로직
//	첫 정점을 기준으로 연결되어 있는 정점들을 추가해 가며, 최단 거리를 갱신하는 기법
//	다익스트라 알고리즘은 너비우선탐색(BFS)와 유사
//		첫 정점부터 각 노드간의 거리를 저장하는 배열을 만든 후, 첫 정점의 인접 노드 간의 거리부터 먼저 계산하면서,
//		첫 정점부터 해당 노드간의 짧은 거리를 해당 배열에 업데이트
//	
//	우선순위 큐를 활용한 다익스트라 알고리즘
//		우선순위 큐는 MinHeap 방식을 활용해서, 현재 가장 짧은 거리를 가진 노드 정보를 먼저 꺼내게 됨
//	1) 첫 정점을 기준으로 배열을 선언하여 첫 정점에서 각 정점까지의 거리를 저장
//		초기에는 첫 정점의 거리는 0, 나머지는 무한대로 저장함(inf 라고 표현)
//		우선순위 큐에 (첫 정점, 거리0)만 먼저 넣음
//	
//	2) 우선순위 큐에서 노드를 꺼냄
//		처음에는 첫 정점만 저장되어 있으므로, 첫 정점이 꺼내짐
//		첫 정점에 인접한 노드들 각각에 대해, 첫 정점에서 각 노드로 가는 거리와 현재 배열에 저장되어있는 첫 정점에서 
//			각 정점까지의 거리를 비교한다.
//		배열에 저장되어 있는 거리보다, 첫 정점에서 해당 노드로 가는 거리가 더 짧을 경우, 배열에 해당 노드의 거리를 업데이트 한다.
//		배열에 해당 노드의 거리가 업데이트된 경우, 우선순위 큐에 넣는다.
//			결과적으로 너비 우선 탐색 방식과 유사하게, 첫 정점에 인접한 노드들을 순차적으로 방문하게 된다.
//			만약 배열에 기록된 현재까지 발견된 가장 짧은 거리보다, 더 긴거리(루트)를 가진 (노드, 거리)의 경우에는 해당 노드와 
//				인접한 노드간의 거리 계산을 하지 않는다.
//	
//	3) 2번의 과정을 우선순위 큐에 꺼낼 노드가 없을 떄 까지 반복한다.
	
//	다익스트라 알고리즘 구현
	public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge1>>graph, String start){
		Edge1 edgeNode , adjacentNode; //edgeNode는  edge정보를 저장하기위한 변수(vertex, distance)
		ArrayList<Edge1> nodeList;
		int currentDistance, weight, distance; //currentDistacne : 쓸일이 많으므로 edge에서 distance값 저장
		String currentNode, adjacent;
		
		HashMap<String, Integer> distances = new HashMap<String, Integer>(); //거리 저장 배열 
		
		for(String key : graph.keySet()){ //그래프의 키값을 받아와서 거리 저장 배열에 키값을 저장 
			distances.put(key,Integer.MAX_VALUE);
		}
		distances.put(start,0); //거리 저장배열의 첫번째 인덱스는 (start, 0)이다.
		
		PriorityQueue<Edge1> priorityQueue = new PriorityQueue<Edge1>(); //우선순위큐 선언 
		//우선순위큐에 거리저장배열에서 strat(인덱스)의 값(0)과 start ="A"를 Edge로 선언해서 추가
		priorityQueue.add(new Edge1(distances.get(start), start)); //우선순위큐에 (A, 0)이 저장됨 
		
		//알고리즘 작성
		while(priorityQueue.size()>0){ //우선순위 큐가 없을때까지 반복
			//우선순위 큐에서 노드를 첫번째 노드를 꺼낸다. 처음에는 첫 정점만 저장되어 있다.
			edgeNode = priorityQueue.poll();  //해당 edge정보를 가져온다
			currentDistance = edgeNode.distance;  //edge의 distance값 저장
			currentNode = edgeNode.vertex;  //edge의 vertex값 저장
			
			//거리 저장배열에 저장된 거리가 , 현재 edge의 거리보다 크다면 비교할 필요가 없음
			if(distances.get(currentNode) < currentDistance){ //저장되어있는 거리값보다 크다면 스킵
				continue;
			}
			
			
			nodeList = graph.get(currentNode); //currentNode에 연결된 edge정보를 가져온다. (A는B,C,D)
			for(int index= 0; index<nodeList.size();index++){
				adjacentNode = nodeList.get(index); //연결된 edge를 가져옴 
				adjacent = adjacentNode.vertex; //가져온 edge의 vertex 저장
				weight = adjacentNode.distance; //가져온 edge의 distance 저장
				distance = currentDistance + weight; //연결된 정보를 저장한다. 
				//ex  A->C->B , 1 + 5 = 6
				  //  6       <     거리저장배열에 (vertex) 인덱스에 저장된 값이랑 비교 
				if(distance < distances.get(adjacent)){ //새로계산된 distance가 더 작으면 , 
					distances.put(adjacent, distance); //거리 저장배열에 (vertex, 새로운 값)을 넣는다.
					priorityQueue.add(new Edge1(distance, adjacent)); 
					//그리고 우선순위 큐에다가 그 값을 그대로 넣는다(거리, vertex)
				}
			}
		}
		
		return distances;
	}
	
	
	public static void main(String[] args) {
	/*	// PriorityQueue 선언 : (1) 데이터를 넣기(우선순위 큐 선언)
		PriorityQueue<Edge1> priorityQueue = new PriorityQueue<Edge1>();
		// PriorityQueue 데이터 추가(add()와 offer() 둘다 동일하게 데이터를 추가하는 기능을 제공함
		priorityQueue.add(new Edge1(2, "A"));
		priorityQueue.add(new Edge1(5, "B"));
		priorityQueue.offer(new Edge1(1, "C"));
		priorityQueue.offer(new Edge1(7, "D"));
		System.out.println(priorityQueue);
		System.out.println();
		//PrioirtyQueue의 최상단 값을 가져오기만 하기(해당 값이 삭제되지는 않음)
		System.out.println(priorityQueue.peek());
		System.out.println();
		//PriorityQueue의 데이터 읽기(PriorityQueue 는 우선순위가 높은 값을 읽기 위해 사용) : 우선순위에 따라 꺼내고, 데이터 삭제
		//내부적으로 두 번째 우선순위의 값이  최상단으로 이동함
		//poll()이외에 remove()메서드도 동일한 역할
		Edge1 edge1 = priorityQueue.poll();
		System.out.println(edge1);
		System.out.println(priorityQueue);
		//데이터 사이즈 확인하기
		System.out.println(priorityQueue.size());*/
		
//		다익스트라 알고리즘 
		HashMap<String, ArrayList<Edge1>> graph = new HashMap<String, ArrayList<Edge1>>();
		graph.put("A", new ArrayList<Edge1>(Arrays.asList(new Edge1(8,"B"), new Edge1(1,"C"),
					new Edge1(2,"D"))));
		graph.put("B", new ArrayList<Edge1>());
		graph.put("C", new ArrayList<Edge1>(Arrays.asList(new Edge1(5,"B"), new Edge1(2,"D"))));
		graph.put("D", new ArrayList<Edge1>(Arrays.asList(new Edge1(3,"E"), new Edge1(5,"F"))));
		graph.put("E", new ArrayList<Edge1>(Arrays.asList(new Edge1(1,"F"))));
		graph.put("F", new ArrayList<Edge1>(Arrays.asList(new Edge1(5,"A"))));
		
/*//		HashMap에 들어있는 모든 Key 가져오기
		for(String key : graph.keySet()){
			System.out.println(key);
			System.out.println(graph.get(key));
		}
		System.out.println();
//		HashMap에서 각 키에 해당하는 값 , ArrayList의 모든 Edge객체 추출하기
		ArrayList<Edge1> nodeList = graph.get("A");
		for(int index=0; index < nodeList.size(); index++){
			System.out.println(nodeList.get(index));
		}*/
		
		DijkstraPath dObject = new DijkstraPath();
		System.out.println(dObject.dijkstraFunc(graph, "A"));
		
//		시간 복잡도
//		다익스트라 알고리즘은 크게 다음 두 가지 과정을 거친다.
//		과정 1 : 각 노드마다 인접한 간선들을 모두 검사하는 과정
//		과정 2 : 우선순위 큐에 노드/거리 정보를 넣고 삭제(pop)하는 과정
//		
//		과정별 시간 복잡도
//		과정 1 : 각 노드는 최대 한번씩 방문하므로(첫 노드와 해당 노드간의 갈수 있는 루트가 있는 경우에만 해당), 그래프의 모든 간선은
//			최대 한번씩 검사
//				즉, 각 노드마다 인접한 간선들을 모두 검사하는 과정은 O(E) 시간이 걸림, E는 간선수
//		과정 2 : 우선순위 큐에 가장 많은 노드, 거리 정보가 들어가는 경우, 우선순위 큐에 노드/거리 정보를 넣고,
//			삭제하는 과정이 최악의 시간이 걸림
//				우선순위 큐에 가장 많은 노드, 거리 정보가 들어가는 시나리오는 그래프의 모든 간선이 검사될 때마다,
//				배열의 최단거리가 갱신되고, 우선순위 큐에 노드/거리가 추가되는 것임
//				이때 추가는 각 간선마다 최대 한 번 일아날 수 있으므로, 최대 O(E)의 시간이 걸리고, 
//				O(E)개의 노드/거리 정보에 대해 우선순위 큐를 유지하는 작업은 O(log E)가 걸림
//				따라서 해당 과정의 시간 복잡도는 O(E log E)
//			
//		총 시간 복잡도
//		과정 1 + 과정2 = O(E) + O(E log E) = O(E+ ElogE) = O(ElogE)
//		
	
	}

}

//PriorityQueue 와 정렬
class Edge1 implements Comparable<Edge1>{
	public int distance;
	public String vertex;
	
	public Edge1(int distance, String vertex){
		this.distance = distance;
		this.vertex = vertex;
	}
	
	public String toString(){
		return "vertex : "+this.vertex+", distance : "+this.distance;
	}
	
	public int compareTo(Edge1 edge1){
		return this.distance - edge1.distance;
	}
}