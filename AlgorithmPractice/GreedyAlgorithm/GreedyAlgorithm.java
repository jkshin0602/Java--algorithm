import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithm {

	// 탐욕 알고리즘(Greedy Algorithm)
	// 최적의 해에 가까운 값을 구하기 위해 사용된다.
	// 여러 경우 중 하나를 결정할 때마다, 매순간 최적이라고 생각되는 경우를 선택하는 방식으로 진행해서, 최종적인 값을 구하는 방식

	// 탐욕 알고리즘 예시
	// 문제 1 : 동전 문제
	// 지불해야 하는 값이 4720원 일 때 1원 50원 100원, 500원 동전으로 동전의 수가 가장 적게 지불하는 방법
	// 가장 큰 동전부터 최대한 지불해야 하는 값을 채우는 방식으로 구현 가능
	// 탐욕 알고리즘으로 매순간 최적이라고 생각되는 경우를 선택하면 된다.
	public void coinFunc(Integer price, ArrayList<Integer> coinList) {
		Integer totalCoinCount = 0;
		Integer coinNum = 0;
		ArrayList<Integer> detailsArrayList = new ArrayList<Integer>();

		for (int index = 0; index < coinList.size(); index++) {
			coinNum = price / coinList.get(index);
			totalCoinCount += coinNum;
			price -= coinNum * coinList.get(index);
			detailsArrayList.add(coinNum);
			System.out.println(coinList.get(index) + "원 :" + coinNum + "개");
		}
		System.out.println("총 동전 갯수 : " + totalCoinCount);
	}

	// 부분 배낭 문제(Fractional Knapsack Problem)
	// 무게 제한이 k인 배낭에 최대 가치를 가지도록 물건을 넣는 문제
	// 각 물건은 무게(w)와 가치(v)로 표현될 수 있음
	// 물건은 쪼갤 수 있으므로 물건의 일부분이 배낭에 넣어질 수 있음, 그래서 Fractional Knapsak Problem으로 부름
	// 위와 반대로 물건을 쪼개서 넣을 수 없는 배낭 문제도 존재(0/1 Knapsack Problem)
	public void knapsackFunc(Integer[][] objectList, double capacity) {
		double totalValue = 0.0;
		double fraction = 0.0;

		Arrays.sort(objectList, new Comparator<Integer[]>() {
			public int compare(Integer[] objectItem1, Integer[] objectItem2) {
				return (objectItem2[1] / objectItem2[0])
						- (objectItem1[1] / objectItem1[0]);
			}
		});

		for (int index = 0; index < objectList.length; index++) {
			if ((capacity - (double) objectList[index][0]) > 0) { // 쪼갤 필요가없다
				capacity -= (double) objectList[index][0];
				totalValue += (double) objectList[index][1];
				System.out.println("무게 : " + objectList[index][0] + ", 가치 : "
						+ objectList[index][1]);
			} else { // 넘쳐서 쪼개야된다.
				fraction = capacity / (double) objectList[index][0];
				totalValue += (double) objectList[index][1] * fraction;
				System.out.println("무게 : " + objectList[index][0] + ", 가치 : "
						+ objectList[index][1]);
				break; // 이미 꽉찼기 때문에 break하면된다.
			}
			System.out.println("총 담을 수 있는 가치 : " + totalValue);
		}
	}

	public static void main(String[] args) {
		// 동전 문제
		/*
		 * GreedyAlgorithm gObject = new GreedyAlgorithm(); ArrayList<Integer>
		 * coinList = new ArrayList<Integer>(Arrays.asList(500, 100, 50, 1));
		 * gObject.coinFunc(4720, coinList);
		 * System.out.println("###################################");
		 */
		// 2차원 배열로 작성하기
		/*
		 * Integer[][] objectList = { { 10, 10 }, { 15, 12 }, { 20, 10 }, { 25,
		 * 8 }, { 30, 5 } }; System.out.println(objectList.length);
		 * System.out.println("###################################");
		 */
		// 정렬 기준 정의하기
		// 정렬을 위해서는 정렬 기준이 있어야 한다.
		// 객체간 정렬을 위해서는 정렬 기준을 먼저 정의해줘야 한다.
		/*
		 * Integer[] iArray = new Integer[] { 1, 10, 4, 3, 2 };
		 * Arrays.sort(iArray); System.out.println(Arrays.toString(iArray));
		 * System.out.println("###################################"); Edge edge1
		 * = new Edge(12, "A"); Edge edge2 = new Edge(10, "A"); Edge edge3 = new
		 * Edge(13, "A"); Edge[] edges = new Edge[] { edge1, edge2, edge3 };
		 */

		/*
		 * Arrays.sort(edges); //Comparable for(int index =0;
		 * index<edges.length; index++){
		 * System.out.println(edges[index].distance); }
		 */
		/*
		 * Arrays.sort(edges, new Comparator<Edge>() { public int compare(Edge
		 * objectItem1, Edge objectItem2) { return objectItem2.distance -
		 * objectItem1.distance; } });
		 * 
		 * for (int index = 0; index < edges.length; index++) {
		 * System.out.println(edges[index].distance); }
		 */

		// 배낭 채우기
		GreedyAlgorithm gObject = new GreedyAlgorithm();
		Integer[][] objectList = { { 10, 10 }, { 15, 12 }, { 20, 10 },
				{ 25, 8 }, { 30, 5 } };
		gObject.knapsackFunc(objectList, 30.0);

		// 탐욕 알고리즘의 한계
		// 탐욕 알고리즘은 근사치 추정에 활용한다.
		// 반드시 최적의 해를 구할 수 있는 것은 아니기 때문
		// 최적의 해에 가까운 값을 구하는 방법 중의 하나임

	}
}

// Comparable 과 Comparator인터페이스
// Comparable와 Comparator는 둘 다 인터페이스로, 정렬 기준을 구현하기 위해 사용된다.
// Comparable 인텨페이스는 compareTo()메서드를, override해서 구현
// 일반적으로 정렬할 객체에 implements로 Comparable 인터페이스를 추가하여 구현
// Comparator 인터페이스는 compare()메서드를 override해서 구현
// 일반적으로 별도 클래스를 정의해서 구현하며, 따라서, 동일 객체에 다양한 정렬 기준을 가진 클래스 작성 가능

// Arrays.sort()와 Comparator
// 다음 예와 같이 Arrays.sort()메서드는 인자를 두 개 받아서, 두 번째 인자에 Compartor클래스를 넣어줄 수 도 있음
// Edge객체에 Comparable 인터페이스가 정의되어 있다하더라도, Comparator클래스의 정렬 기준으로 정렬됨
// ->Comparator기준으로 정렬이 된다(우선순위가 높다)

class Edge implements Comparable<Edge> {
	public Integer distance;
	public String vertex;

	public Edge(Integer distance, String vertex) {
		this.distance = distance;
		this.vertex = vertex;
	}

	public int compareTo(Edge e) {
		return this.distance - e.distance;// 내림차순, 오름차순시 distance 위치 변경
	}

}
