import java.util.ArrayList;


public class SequentialSearch {

//	순차 탐색(Sequential Search) 
//	탐색은 여러 데이터 중에서 원하는 데이터를 찾아내는 것을 의미
//	데이터가 담겨있는 배열을 앞에서부터 하나씩 비교해서 원하는 데이터를 찾는 방법
	
//	순차 탐색 알고리즘 구현
	public int searchFunc(ArrayList <Integer> dataList, Integer searchItem){
		for(int index =0; index<dataList.size();index++){
			if(dataList.get(index) == searchItem){
				return index;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		ArrayList<Integer> testData = new ArrayList<Integer>();
		
		for(int i=0; i<20; i++){
			testData.add((int)(Math.random()*20));
		}
		System.out.println(testData);
		
		SequentialSearch sSearch = new SequentialSearch();
		System.out.println(sSearch.searchFunc(testData, 10));

	}

}
