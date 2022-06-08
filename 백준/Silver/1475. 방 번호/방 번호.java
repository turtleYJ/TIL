import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		Map<Integer, Integer> numCount = new HashMap<>();
		
		for (int i = 0; i < S.length(); i++) {
			int num = S.charAt(i) - 48;
			if(num == 6 || num == 9) {
				numCount.put(6, numCount.getOrDefault(6, 0) + 1);
			} else {
				numCount.put(num, numCount.getOrDefault(num, 0) + 1);
			}
		}
		
		int six = numCount.getOrDefault(6, 0);
		if(six % 2 == 0) {
			numCount.put(6, six / 2);
		} else {
			numCount.put(6, six / 2 + 1);
		}
		
		int count = 0;
		for (Integer i : numCount.keySet()) {
			count = Math.max(numCount.get(i), count);
		}
		
		System.out.println(count);
	}
}