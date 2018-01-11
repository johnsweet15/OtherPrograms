import java.util.ArrayList;

public class idontknow {
	public static ArrayList arrayMethod(ArrayList<Integer> list){
		
		ArrayList<Integer> newList = new ArrayList<Integer>();
		
		for(int i = list.size() - 1; i >= 0; i--){
			newList.add(list.get(i));
		}
		return newList;	
	}
	
	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		ArrayList<Integer> newList = new ArrayList<Integer>();
		newList = arrayMethod(list);
		System.out.println(newList);
	}
}
