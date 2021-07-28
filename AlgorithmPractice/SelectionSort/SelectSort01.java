package review01;

import java.util.ArrayList;
import java.util.Collections;

public class SelectSort01 {

	public static ArrayList<Integer> Sort(ArrayList<Integer> dataList){
		int lowest;
		for(int stand =0; stand < dataList.size()-1; stand++){
			lowest = stand;
			for(int index=stand+1; index<dataList.size(); index++){
				if(dataList.get(lowest) > dataList.get(index)){
					lowest = index;
				}
			}
			Collections.swap(dataList, lowest ,stand);
		}
		return dataList;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> testData = new ArrayList<Integer>();
		
		for(int i=0; i<20; i++){
			testData.add((int)(Math.random()*100));
		}
		System.out.println(Sort(testData));
	}
	
	//시간 복잡도 
	//반복문이 두 개  O(N^2)
	 //상세히는 n*(n-1)/2 
	//거품정렬이랑 시간복잡도가 똑같다.
}
