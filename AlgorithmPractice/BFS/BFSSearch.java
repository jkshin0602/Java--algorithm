import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BFSSearch {
	// 너비 우선 탐색(Breadth-First Search)
	//
	// BFS와 DFS란?
	// 대표적인 그래프 탐색 알고리즘
	// 너비 우선 탐색(Breadth First Search) : 정점들과 같은 레벨에 있는 노드들(형제 노드들)을 먼저 탐색하는 방식
	// 깊이 우선 탐색(Depth First Search) : 정점의 자식들을 먼저 탐색하는 방식
	//
	// BFS 방식 : 한 단계씩 내려가면서, 해당 노드와 같은 레벨에 있는 노드들(형제 노드들)을 먼저 순회함
	// DFS 방식 : 한 노드의 자식을 타고 끝까지 순회한 후, 다시 돌아와서 다른 형제들의 자식을 타고 내려가며 순회함

	// 두 개의 큐가 필요하다
	// 방문을 한 노드가 들어가는 큐, 탐색이 필요한 노드가 들어가는 큐

	// Java로 그래프를 표현하는 방법
	// Java Collection Framework에서 제공하는 HashMap과 ArrayList를 활용해서 그래프를 표현할 수 있음

	// HashMap은 키와 값을 저장하는 자료구조로 내부에서 해쉬 함수를 통해, 키에 대한 값을 빠르게 검색할 수 있음
	// 기본 선언 HashMap<키타입, 값타입> 변수 = new HashMap<키타입, 값타임>();
	// HashMap<String , Integer> mapData1 = new HashMap<String, Integer>();
	// HashMap<String ,Integer> mapData2 = new HashMap<String, Integer>(10);
	// //길이 생성
	// 키나 값 안에 ArrayList를 선언이 가능
	// HashMap<String , Integer> mapData3= new HashMap<String,
	// ArrayList<String>>();

	// BFS 구현
	// BFS에서는 큐 자료구조를 사용한다.
	public ArrayList<String> bfsFunc(HashMap<String, ArrayList<String>> graph,
			String startNode) {
		ArrayList<String> visited = new ArrayList<String>();
		ArrayList<String> needVisit = new ArrayList<String>();

		needVisit.add(startNode);
		int count = 0;

		while (needVisit.size() > 0) {
			count += 1;
			String node = needVisit.remove(0);

			if (!visited.contains(node)) {
				visited.add(node);
				needVisit.addAll(graph.get(node));
			}
		}
		System.out.println(count);
		return visited;
	}

	public static void main(String[] args) {
		// //HashMap 데이터 추가
		// HashMap<String, Integer> mapData1 = new HashMap<String, Integer>();
		// mapData1.put("A", 1);
		// mapData1.put("B", 2);
		// //HashMap 데이터 읽기
		// System.out.println(mapData1);
		// System.out.println(mapData1.get("A"));
		// //HashMap 데이터 수정
		// mapData1.put("B", 3);
		// System.out.println(mapData1);
		// //HashMap 데이터 삭제
		// mapData1.remove("A");
		// System.out.println(mapData1);

		// HashMap으로 그래프 표현
		HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

		graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
		graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
		graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
		graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
		graph.put("E", new ArrayList<String>(Arrays.asList("D")));
		graph.put("F", new ArrayList<String>(Arrays.asList("D")));
		graph.put("G", new ArrayList<String>(Arrays.asList("C")));
		graph.put("H", new ArrayList<String>(Arrays.asList("C")));
		graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
		graph.put("J", new ArrayList<String>(Arrays.asList("I")));
		// System.out.println(graph);

		// 큐의 구현
		/*
		 * ArrayList<String> aList =new ArrayList<String>(); aList.add("A");
		 * aList.add("B"); String node = aList.remove(0);
		 * System.out.println(aList); System.out.println(node);
		 * System.out.println(aList.contains("A"));
		 * System.out.println("#############################");
		 * 
		 * //그래프에 있는 value(값) 순서 유지해서 한번에 큐에 넣기 ArrayList<String> aList2 =new
		 * ArrayList<String>();
		 * 
		 * aList2.add("C"); aList2.addAll(graph.get("A")); //ArrayList에
		 * Collection값을 한번에 넣을 수 있음 System.out.println(aList2);
		 */

		// BFS 테스트
		BFSSearch bObject = new BFSSearch();
		System.out.println(bObject.bfsFunc(graph, "A"));

		// Count : 19 = V(10) + E(9)

		// 시간복잡도
		// 일반적인 BFS 시간 복잡도
		// 노드 수 : V
		// 간선 수 : E
		// 위 코드에서 while needVisit은 V+E번 만큼 수행함
		// 시간복잡도 : O(V+E)

	}

}
