import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main2750 {

	public static ArrayList<Integer> Sort(ArrayList<Integer> dataList){
		for(int i=0; i<dataList.size()-1; i++){
			boolean swap = false;
		
			for(int j=0; j<dataList.size()-1-i; j++){
				if(dataList.get(j)>dataList.get(j+1)){
					Collections.swap(dataList, j, j+1);
					swap = true;
				}
			}
			if(swap == false){
				break;
			}
		}
		return dataList;
	}
	
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		for(int i=0; i<N; i++){
			testList.add(Integer.parseInt(bf.readLine()));
		}
		Sort(testList);
		
		for(int i=0; i<testList.size(); i++){
			System.out.println(testList.get(i));
		}
	}

}
