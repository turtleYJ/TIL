import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class myComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		
		if(o1.length() == o2.length()) {
			
			if(countNum(o1) == countNum(o2)) {
				return o1.compareTo(o2);
			}
			
			return countNum(o1) - countNum(o2);
		}
		
		return o1.length() - o2.length();
	}

	private int countNum(String o1) {
		int sum = 0;
		
		for (int i = 0; i < o1.length(); i++) {
			if(o1.charAt(i) >= '1' && o1.charAt(i) <= '9') {
				sum += o1.charAt(i) - 48;
			}
		}

		return sum;
	}
	
	
}

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] strArr = new String[N];
		
		for (int i = 0; i < N; i++) {
			strArr[i] = br.readLine();
		}
		
		Arrays.sort(strArr, new myComparator());
		
		for (String s : strArr) {
			System.out.println(s);
		}
	}
}