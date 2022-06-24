import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static boolean[] checkNum;
	private static char[] signs;
	private static int N;
	private static String min;
	private static String max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		signs = new char[N];
		checkNum = new boolean[10];

		for (int i = 0; i < signs.length; i++) {
			signs[i] = st.nextToken().charAt(0);
		}
		
		List<Integer> numList = new ArrayList<>();
//		List<Integer> minList = new ArrayList<>();
//		List<Integer> maxList = new ArrayList<>();
		
		min = Long.toString(Long.MAX_VALUE);
		max = Long.toString(Long.MIN_VALUE);
		findMin(numList, 0);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void findMin(List<Integer> numList, int depth) {
		if(depth == N + 1) {
			String S = "";
			for (int i = 0; i < numList.size(); i++) {
				S += Long.toString(numList.get(i));
			}
			
			long num = Long.valueOf(S);
			
			if(num < Long.valueOf(min)) {
				min = S;
			}
			if(num > Long.valueOf(max)) {
				max = S;
			}
			
			return;
		}
		
		
		for (int i = 0; i < checkNum.length; i++) {
			if (checkNum[i]) continue;
			
			// 부등호에 부합하는지를 판별
			if(depth == 0 || isPassed(i, depth, numList)) {
				checkNum[i] = true;
				numList.add(i);
				findMin(numList, depth + 1);
				checkNum[i] = false;
				numList.remove(Integer.valueOf(i));
			}
		}
	}

	private static boolean isPassed(int idx, int depth, List<Integer> minList) {
		boolean res = false;
		int bf = minList.get(minList.size() - 1);
		int cur = idx;
		char sign = signs[depth - 1];
		
		if(sign == '>' && bf > cur) res = true;
		if(sign == '<' && bf < cur) res = true;
		
		return res;
	}
}