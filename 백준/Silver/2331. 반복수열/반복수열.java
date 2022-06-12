import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		List<Integer> permutation = new ArrayList<>();
		
		permutation.add(A);
		String num = Integer.toString(A);
		while(true) {
			int newNum = 0;
			
			for (int i = 0; i < num.length(); i++) {
				newNum += Math.pow((num.charAt(i) - 48), P);
			}
			
			num = Integer.toString(newNum);

			if(!permutation.contains(newNum)) {
				permutation.add(newNum);
			} else {
				break;
			}
		}
		
		int count = 0;
		for (int i = 0; i < permutation.size(); i++) {
			// 중요!! 둘다 Integer이므로 두 인스턴스의 주소값이 같은지를 확인하게 된다.
//			if(permutation.get(i) == Integer.valueOf(num)) break;
			if(permutation.get(i).equals(Integer.valueOf(num))) break;
			count++;
		}
		
		System.out.println(count);
	}
}