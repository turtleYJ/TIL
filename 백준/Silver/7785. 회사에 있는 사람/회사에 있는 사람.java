import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Comparator<String> comparator = (s1, s2) ->  s2.compareTo(s1);
		Map<String, Boolean> map = new TreeMap<>(comparator);
		
		while(N-- > 0) {
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			String el = st.nextToken();
			
			if(el.equals("enter")) {
				
				map.put(name, true);
			} else {
				map.remove(name);
			}
			
		}
		
		for (String key : map.keySet()) {
			System.out.println(key);
		}
	}
}