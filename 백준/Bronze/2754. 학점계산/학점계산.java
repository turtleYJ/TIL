import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Double> scoreMap = new HashMap<>();
		scoreMap.put("A+", 4.3);
		scoreMap.put("A0", 4.0);
		scoreMap.put("A-", 3.7);
		scoreMap.put("B+", 3.3);
		scoreMap.put("B0", 3.0);
		scoreMap.put("B-", 2.7);
		scoreMap.put("C+", 2.3);
		scoreMap.put("C0", 2.0);
		scoreMap.put("C-", 1.7);
		scoreMap.put("D+", 1.3);
		scoreMap.put("D0", 1.0);
		scoreMap.put("D-", 0.7);
		scoreMap.put("F", 0.0);
		
		String S = br.readLine();
		double res = scoreMap.get(S);
		
		System.out.println(res);
	}
}