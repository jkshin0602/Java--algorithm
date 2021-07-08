import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DFSSearch {
	// 깊이 우선 탐색(Depth-First Search)
	//
	// BFS와 DFS란?
	// 대표적인 그래프 탐색 알고리즘
	// 너비 우선 탐색(Breadth First Search) : 정점들과 같은 레벨에 있는 노드들(형제 노드들)을 먼저 탐색하는 방식
	// 깊이 우선 탐색(Depth First Search) : 정점의 자식들을 먼저 탐색하는 방식
	//
	// BFS 방식 : 한 단계씩 내려가면서, 해당 노드와 같은 레벨에 있는 노드들(형제 노드들)을 먼저 순회함
	// DFS 방식 : 한 노드의 자식을 타고 끝까지 순회한 후, 다시 돌아와서 다른 형제들의 자식을 타고 내려가며 순회함

	// DFS 구현
	// DFS는 BFS와 다르게 visted큐, needVisit 스택, 두개의 자료구조를 생성한다.
	// BFS 자료구조는 두 개의 큐를 활용하는데 반해, DFS는 스택과 큘를 활용한다는 차이가 있음을 인지해야 한다.
	// 큐와 스택의 구현도 간단히 ArrayList클래스를 활용한다.
	public ArrayList<String> dfsFunc(HashMap<String, ArrayList<String>> graph,
			String startNode) {
		ArrayList<String> visited = new ArrayList<String>();
		ArrayList<String> needVisit = new ArrayList<String>();

		needVisit.add(startNode);
		int count = 0;

		while (needVisit.size() > 0) {
			count += 1;
			String node = needVisit.remove(needVisit.size() - 1); // BFS와 이부분만
																	// 다르다.
			if (!visited.contains(node)) {
				visited.add(node);
				needVisit.addAll(graph.get(node));
			}
		}
		System.out.println(count);
		return visited;
	}

	public static void main(String[] args) {
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

		// 스택구현
		/*
		 * ArrayList<String> aList = new ArrayList<String>(); aList.add("A");
		 * aList.add("B"); String node= aList.remove(aList.size()-1);
		 * System.out.println(aList); System.out.println(node);
		 */

		DFSSearch dObject = new DFSSearch();
		System.out.println(dObject.dfsFunc(graph, "A"));

		// 시간복잡도
		// DFS 시간 복잡도
		// 노드 수 : V
		// 간선 수 : E
		// 위 코드에서 while needVisit은 V+E번 만큼 수행함
		// 시간 복잡도 : O(V+E)

	}

}
