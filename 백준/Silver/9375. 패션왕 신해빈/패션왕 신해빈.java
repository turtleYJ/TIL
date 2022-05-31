import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// combination
// 근데 각 의상 종류별 null을 포함한다. 모든 종류별로 null이 나오는 단 한가지 경우만 제외하고 모두 허용된다.
// 따라서 각각의 종류별로 1개를 뽑을 경우의 수 nC1을 각각 뽑고 곱해주어 마지막에 1을 빼준다. 
public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(T-- > 0) {
        	
        	int N = Integer.parseInt(br.readLine());
        	
        	Map<String, Integer> map = new HashMap<>();
        	
        	for(int i = 0; i < N; i++) {
        		
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		
        		st.nextToken();
        		String gear = st.nextToken();
        		
        		map.put(gear, map.getOrDefault(gear, 0) + 1);
        	}
        	
        	int result = 1;
        	
        	for (String s : map.keySet()) {
				
        		result *= (map.get(s) + 1);
			}
        	
        	sb.append(result - 1).append('\n');
        }
        
        System.out.println(sb);
    }
}