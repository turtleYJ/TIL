import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
			pq.add(scoville[i]);
		}
        
        int answer = 0;
        int newScv = 0;
        while (true) {
        	int scv1 = pq.poll();
        	
        	if (scv1 < K) {
        		
        		if (pq.isEmpty()) {
        			answer = -1;
        			break;
        		}
        		
        		answer++;
        		newScv = scv1 + pq.poll() * 2;
        		pq.add(newScv);
        	} else {
        		break;
        	}
        }
        
        return answer;
    }
}