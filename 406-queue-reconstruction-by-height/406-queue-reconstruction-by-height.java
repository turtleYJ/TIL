import java.util.*;

class Solution {
     public int[][] reconstructQueue(int[][] people) {
    	
    	Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
			}
		
    	});
    	
    	List<int[]> res = new ArrayList<>();
    	for (int[] arr : people) {
    		res.add(arr[1], arr);
		}
    	
		return res.toArray(new int[people.length][]);
    }
}