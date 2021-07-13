import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;


public class PrimPath {

//	프림 알고리즘 
//	시작 정점을 선택한 후, 정점에 인접한 간선중 최소 간선으로 연결된 정점을 선택하고 , 해당 정점에서 다시 최소 간선으로 연결된
//	정점을 선택하는 방식으로 최소 신장트리를 확장해 가는 방식
//	
//	크루스칼 알고리즘과 비교
//		둘 다 , 탐욕 알고리즘을 기초로 하고 있다.(당장의 눈 앞의 최소 비용을 선택해서, 결과적으로 최적의 솔루션을 찾음)
//		크루스칼 알고리즘은 가장 가중치가 작은 간선부터 선택하면서 MST를 구함
//		프림 알고리즘은 특정 정점에서 시작, 해당 정점에 연결된 가장 가중치가 작은 간선을 선택, 간선으로 연결된 정점들에 연결된 간선 중에서 가장 
//		가중치가 작은 간선을 택하는 방식으로 MST를 구함
	
//	크루스칼 알고리즘은 우선순위큐를 사용한다.
//	HashMap에 특정 키 존재여부 확인
//	containsKey() 메서드 사용
	
//	프림 알고리즘 구현
	public ArrayList<Edge3> primFunc(String startNode, ArrayList<Edge3> edges){
		Edge3 currentEdge, poppedEdge, adjacentEdgeNode;
		ArrayList<Edge3> currentEdgeList, candidateEdgeList, adjacentEdgeNodes;
		PriorityQueue<Edge3> priorityQueue;
		
		ArrayList<String> connectedNodes = new ArrayList<String>(); //연결된 노드의 집합
		ArrayList<Edge3> mst = new ArrayList<Edge3>(); //최소신장트리(MST)
		//모든 간선의 정보를 저장(adjacentEdges)
        HashMap<String, ArrayList<Edge3>> adjacentEdges = new HashMap<String, ArrayList<Edge3>>();
        
        for(int index=0; index <edges.size(); index++){
        	currentEdge = edges.get(index);
        	if(!adjacentEdges.containsKey(currentEdge.node1)){
        		adjacentEdges.put(currentEdge.node1, new ArrayList<Edge3>());
        	}
        	if(!adjacentEdges.containsKey(currentEdge.node2)){
        		adjacentEdges.put(currentEdge.node2, new ArrayList<Edge3>());
        	}	
        }
        
        for(int index =0; index<edges.size(); index++){
        	currentEdge = edges.get(index);
        	currentEdgeList =  adjacentEdges.get(currentEdge.node1);
        	currentEdgeList.add(new Edge3(currentEdge.weight, currentEdge.node1, currentEdge.node2));
        	  currentEdgeList = adjacentEdges.get(currentEdge.node2);
              currentEdgeList.add(new Edge3(currentEdge.weight, currentEdge.node2, currentEdge.node1));
          }
          
          connectedNodes.add(startNode);
          candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge3>());
          priorityQueue = new PriorityQueue<Edge3>();
          for (int index = 0; index < candidateEdgeList.size(); index++) {
              priorityQueue.add(candidateEdgeList.get(index));
          }
          
          while (priorityQueue.size() > 0) {
              poppedEdge = priorityQueue.poll();
              if (!connectedNodes.contains(poppedEdge.node2)) {
                  // 해당 edge 를 mst 에 추가
                  connectedNodes.add(poppedEdge.node2);
                  mst.add(new Edge3(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));
                  
                  adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<Edge3>());
                  for (int index = 0; index < adjacentEdgeNodes.size(); index++) {
                      adjacentEdgeNode = adjacentEdgeNodes.get(index);
                      if(!connectedNodes.contains(adjacentEdgeNode.node2)) {
                          priorityQueue.add(adjacentEdgeNode);
                      }
                  }
              }
          }
          return mst;
	}
	
	
	
	public static void main(String[] args) {
		/*PriorityQueue<Edge3> priorityQueue = new PriorityQueue<Edge3>();
		priorityQueue.add(new Edge3(2, "A", "B"));
		priorityQueue.add(new Edge3(5, "B", "D"));
		priorityQueue.add(new Edge3(3, "C", "A"));
		
		while(priorityQueue.size()>0){
			System.out.println(priorityQueue.poll());
		}
		HashMap<String, ArrayList<Edge3>> graph = new HashMap<String, ArrayList<Edge3>>();
		graph.put("A", new ArrayList<Edge3>());
		graph.put("B", new ArrayList<Edge3>());
		
		System.out.println(graph.containsKey("B"));
		
//		찾는 키에 대한 값이 존재하지 않을 때 디폴트 값 반환하기.
		System.out.println(graph.getOrDefault("C", new ArrayList<Edge3>()));*/
		ArrayList<Edge3> myedges = new ArrayList<Edge3>();
		myedges.add(new Edge3(7, "A", "B"));
		myedges.add(new Edge3(5, "A", "D"));
		myedges.add(new Edge3(8, "B", "C"));
		myedges.add(new Edge3(9, "B", "D"));
		myedges.add(new Edge3(7, "D", "E"));
		myedges.add(new Edge3(5, "C", "E"));
		myedges.add(new Edge3(7, "B", "E"));
		myedges.add(new Edge3(6, "D", "F"));
		myedges.add(new Edge3(8, "E", "F"));
		myedges.add(new Edge3(9, "E", "G"));
		myedges.add(new Edge3(11, "F", "G"));
		
		PrimPath pObject = new PrimPath();
		System.out.println(pObject.primFunc("A", myedges));

	
	}

}

class Edge3 implements Comparable<Edge3>{
	public int weight;
	public String node1;
	public String node2;
	
	public Edge3(int weight, String node1, String node2){
		this.weight = weight;
		this.node1 = node1;
		this.node2 = node2;
	}
	
	public String toString(){
		return "("+ this.weight+", "+this.node1+", "+this.node2+")";
	}
	
	public int compareTo(Edge3 edge){
		return this.weight - edge.weight;
	}
}
