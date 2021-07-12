import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class KruskalPath {

//	신장 트리란?
//	Spanning Tree, 또는 신장 트리라고 불림
//	원래의 그래프의 모든 노드가 연결되어 있으며 트리의 속성을 만족하는 그래프
//	신장 트리의 조건 
//		본래의 그래프의 모든 노드를 포함해야 함
//		모든 노드가 서로 연결
//		트리의 속성을 만족 시킴(사이클이 존재하지 않음)
	
//	최소 신장 트리 
//	Minimum Spanning Tree , MST라고 불름
//	가능한 Spanning Tree 중에서, 간선의 가중치 합이 최소인 Spanning Tree를 지칭함
	
//	최소 신장 트리 알고리즘
//	그래프에서 최소 신장 트리를 찾을 수 있는 알고리즘이 존재한다.
//	대표적으로 최소 신장 트리 알고리즘
//	Kruskal's algorithm(크루스칼 알고리즘), Prim's algorithm(프림 알고리즘)
	
//	크루스칼 알고리즘(Kruskal's algoritm)
//	1. 모든 정점을 독립적인 집합으로 만든다.
//	2. 모든 간선을 비용을 기준으로 정렬하고, 비용이 작은 간선부터 양 끝의 두 정점을 비교한다.
//	3. 두 정점의 최상위 정점을 확인하고, 서로 다를 경우 두 정점을 연결한다(최소 신장 트리는 사이클이 없으므로, 사이클이 생기지 않도록 하는 것)
//	-> 탐욕 알고리즘을 기초로 하고 있다.(당장 눈 앞의 최소 비용을 선택해서, 결과적으로 최적의 솔루션을 찾음)
	
//	Union-Find 알고리즘 
//	Disjoint Set을 표현할 때 사용하는 알고리즘으로 트리 구조를 활용하는 알고리즘
//	간단하게, 노드들 중에 연결된 노드를 찾거나, 노드들을 서로 연결할 때 (합칠 떄) 사용
//	Disjoint Set이란
//		서로 중복되지 않는 부분 집합들로 나눠진 원소들에 대한 정보를 저장하고 조작하는 자료 구조
//		공통 원소가 없는 (서로소) 상호 베타적인 부분 집합들로 나눠진 원소들에 대한 자료구조
//		Disjoint Set =  서로소 집합 자료구조
		
//	1. 초기화
//	n개의 원소가 개별 집합으로 이뤄지도록 초기화
//	
//	2. Union
//	두 개별 집합을 하나의 집합으로 합침, 두 트리를 하나의 트리로 만듬
//	
//	3. Find
//	여러 노드가 존재할 때, 두 개의 노드를 선택해서, 현재 두 노드가 서로 같은 그래프에 속하는지 판별하기 위해, 
//	각 그룹의 최상단 원소(즉 ,루트 노드)를 확인
//	
//	Union - Find 알고리즘의 고려할 점
//	Union 순서에 따라서 최악의 경우 링크드 리스트와 같은 형태가 될 수 있음
//	이 때는 Find/Union 시 계산량이 O(n)이 될 수 있으므로, 해당 문제를 해결하기 위해 , 
//	union-by-rank, path, compression 기법을 사용한다.
//	
//	union-by-rank
//	각 트리에 대해 높이(rank)를 기억해 두고
//	Union시 두 트리의 높이(rank)가 다르면, 높이가 작은 트리를 높이가 큰 트리에 붙임 
//	(즉 , 높이가 큰 트리의 루트노드가 합친 집합의 루트노드가 되게 함)
//	
//	높이가 h-1인(동일한) 두 개의 트리를 합칠 때는 한쪽의 트리 높이를 1 증가시켜주고, 다른 쪽의 트리를 해당 트리에 붙여줌
//	
//	초기화시 , 모든 원소는 높이(rank)가 0인 개별 집합인 상태에서, 하나씩 원소를 합칠 때, union-by-rank 기법을 사용한다면
//		높이가 h인 트리가 만들어 지려면 , 높이가 h-1인 두 개의 트리가 합쳐져야 함
//		높이가 h-1인 트리를 만들기 위해 최소 n개의 원소가 필요하다면, 높이가 h인 트리가 만들어지기 위해서는 최소 2n개의 원소가 필요
//		따라서 union-by-rank 기법을 사용하면, union/find 연산의 시간복잡도는 O(n)이 아닌 O(log n)으로 낮출 수 있음
	
//	path compression
//	Find를 실행한 노드에서 거쳐간 노드를 루트에 다이렉트로 연결하는 기법
//	Find를 실행한 노드는 이후부터는 루트 노드를 한번에 알 수 있다.
//	
//	union-by-rank와 path compression 기법 사용시 시간 복잡도는
//	O(M log* N)
//	거의 O(1) 상수값에 가깝다.
	
	//Union-Find 
	//Union-Find 
	HashMap<String, String> parent = new HashMap<String, String>();
	HashMap<String, Integer> rank = new HashMap<String, Integer>();
	
	public String find(String node){
		//path compression 기법
		if(this.parent.get(node) != node){
			this.parent.put(node, this.find(this.parent.get(node)));
		}
		return this.parent.get(node);
	}
	
	public void union(String nodeV, String nodeU){
		String root1 = this.find(nodeV);
		String root2 = this.find(nodeU);
		
		//union-by-rank 기법
		if(this.rank.get(root1) > this.rank.get(root2)){
			this.parent.put(root2, root1);
		}else{
			this.parent.put(root1, root2);
			if(this.rank.get(root1) == this.rank.get(root2)){
				this.rank.put(root2, this.rank.get(root2)+1);
			}
		}
	}
	
	public void makeSet(String node){
		this.parent.put(node, node);
		this.rank.put(node, 0);
	}
	
//	크루스칼 알고리즘(Kruskal's algorithm) 작성
	public ArrayList<Edge2> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge2> edges){
		ArrayList<Edge2> mst = new ArrayList<Edge2>();
		Edge2 currentEdge;
		
		//1. 초기화
		for(int index=0; index < vertices.size(); index++){
			makeSet(vertices.get(index));
		}
		
		//2. 간선 weight 기반, sorting
		Collections.sort(edges);
		
		for(int index=0; index < edges.size(); index++){
			currentEdge = edges.get(index);
			if(this.find(currentEdge.nodeV) != this.find(currentEdge.nodeU)){
				this.union(currentEdge.nodeV, currentEdge.nodeU);
				mst.add(currentEdge);
			}
		}
		return mst;
	}
	

	public static void main(String[] args) {
		ArrayList<String> vertices = new ArrayList<String>(Arrays.asList("A","B","C","D","E","F","G"));
		ArrayList<Edge2> edges = new ArrayList<Edge2>();
		edges.add(new Edge2(7, "A","B"));
		edges.add(new Edge2(5, "A","D"));
		edges.add(new Edge2(7, "B","A"));
		edges.add(new Edge2(9, "B","D"));
		edges.add(new Edge2(8, "B","C"));
		edges.add(new Edge2(7, "B","E"));
		edges.add(new Edge2(8, "C","B"));
		edges.add(new Edge2(5, "C","E"));
		edges.add(new Edge2(5, "D","A"));
		edges.add(new Edge2(7, "D","E"));
		edges.add(new Edge2(6, "D","F"));
		edges.add(new Edge2(7, "E","B"));
		edges.add(new Edge2(5, "E","C"));
		edges.add(new Edge2(7, "E","D"));
		edges.add(new Edge2(8, "E","F"));
		edges.add(new Edge2(9, "E","G"));
		edges.add(new Edge2(6, "F","D"));
		edges.add(new Edge2(8, "F","E"));
		edges.add(new Edge2(9, "G","E"));
		edges.add(new Edge2(11, "G","F"));
		
//		System.out.println(vertices);
//		System.out.println(edges);
		
		KruskalPath kObject = new KruskalPath();
		System.out.println(kObject.kruskalFunc(vertices, edges));
		
//		시간복잡도
//		크루스컬 알고리즘의 시간 복잡도는 O(E log E)
		
		
	}

}

//Edge클래스 정의
class Edge2 implements Comparable<Edge2>{
	public int weight;
	public String nodeV;
	public String nodeU;
	
	public Edge2(int weight, String nodeV, String nodeU){
		this.weight = weight;
		this.nodeV=  nodeV;
		this.nodeU = nodeU;
	}
	
	public String toString(){
		return "("+ this.weight+", "+this.nodeV+", "+this.nodeU +")";
	}
	
	public int compareTo(Edge2 edge){
		return this.weight - edge.weight;
	}
}	
