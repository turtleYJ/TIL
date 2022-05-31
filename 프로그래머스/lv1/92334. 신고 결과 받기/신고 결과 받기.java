import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
               
        HashMap<String, Integer> count = new HashMap<>();
		HashMap<String, Set<String>> record = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i ++) {
        	
        	record.put(id_list[i], new HashSet<String>());
        }
        
        for(int i = 0; i < report.length; i++) {
        	StringTokenizer st = new StringTokenizer(report[i]);
        	
        	String accuser = st.nextToken();
        	String defendant = st.nextToken();
        	
        	
        	if(!record.get(accuser).contains(defendant)) {
        		
        		record.get(accuser).add(defendant);
        		
        		count.put(defendant, count.getOrDefault(defendant, 0) + 1);
        	} 
        }
        
        HashMap<String, Integer> cloneCount = (HashMap<String, Integer>)count.clone();
        
        for (String s : count.keySet()) {
			if(count.get(s) < k) {
				
				cloneCount.remove(s);
			}
		}
        
        Set<String> stopId  = cloneCount.keySet();
        int[] answer = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++) {
        	
        	record.get(id_list[i]).retainAll(stopId);
        	
        	answer[i] = record.get(id_list[i]).size();
        }
        
        return answer;
    }
}