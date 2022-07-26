import java.util.*;

class Solution {
    public String[] solution(String[] record) {
       
		Map<String, String> idMap = new HashMap<>();
		List<String> answerList = new ArrayList<>();
		
		for (int i = 0; i < record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i]);
			
			String type = st.nextToken();
			String id = st.nextToken();
			if (type.equals("Enter")) {
				String nName = st.nextToken();
				idMap.put(id, nName);
//				answerList.add(idMap.get(id) + "님이 들어왔습니다.");
			}
//			if (type.equals("Leave")) {
//				answerList.add(idMap.get(id) + "님이 나갔습니다.");
//			}
			if (type.equals("Change")) {
				String nName = st.nextToken();
				idMap.put(id, nName);
			}
		}
		
		for (int i = 0; i < record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i]);
			
			String type = st.nextToken();
			String id = st.nextToken();
			if (type.equals("Enter")) {
				answerList.add(idMap.get(id) + "님이 들어왔습니다.");
			}
			if (type.equals("Leave")) {
				answerList.add(idMap.get(id) + "님이 나갔습니다.");
			}
		}
		
		String[] answer = answerList.toArray(new String[answerList.size()]);
        return answer;
    }
}