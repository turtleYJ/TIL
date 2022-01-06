import java.util.ArrayList;
import java.util.Collections;

public class problem1 {
/*
 * 	활동 선택 문제
 * 	- 한 강의실에서 여러 개의 수업을 하려고 할 때 한번에 가장 많은 수업을 할 수 있는 경우의 수.
 * 
 * 
 */
	public static void main(String[] args) {
		ArrayList<Action> list = new ArrayList<>();
		
		list.add(new Action("A", 7, 8));
		list.add(new Action("B", 5, 7));
		list.add(new Action("C", 3, 6));
		list.add(new Action("D", 1, 2));
		list.add(new Action("E", 6, 9));
		list.add(new Action("F", 10, 11));
		Collections.sort(list);
		
		System.out.println(list);
		
		ArrayList<Action> ans = greedy(list);
		for(Action act : ans) {
			System.out.print(act.name + ", ");
		}
	}
	
	private static ArrayList<Action> greedy(ArrayList<Action> list) {
		int time = 0;
		ArrayList<Action> ans = new ArrayList<>();
		
		for(Action act : list) {
			if(time <= act.startTime) {
				time = act.endTime;
				ans.add(act);
			}
		}
		
		return ans;
		
		
		
	}

}
