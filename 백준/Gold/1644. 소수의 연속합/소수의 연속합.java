import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 에라토스테네스의 체
// (기본)
public class Main {

	private static boolean[] arr;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new boolean[N + 1];
		List<Integer> primeList = new ArrayList<>();
		
		sieve(N);
		
		for (int i = 2; i < arr.length; i++) {
			if (!arr[i]) {
				primeList.add(i);
			}
		}
		
		int res = count(N, primeList);
		
		System.out.println(res);
	}

	private static void sieve(int n) {
		arr[0] = true;
		arr[1] = true;
		
		for (int i = 2; i < n + 1; i++) {
			if (!arr[i]) {
				for (int j = i + i; j < n + 1; j+=i) {
					arr[j] = true;
				}
			}
		}
	}


	private static int count(int num, List<Integer> primeList) {
		int size = primeList.size();
		int start = 0;
		int end = 0;
		int sum = 0;
		int count = 0;
		while (start < size) {
			if (sum >= num || end == size) {
				if(sum == num) count++;
				sum -= primeList.get(start);
				start++;
			} else {
				sum += primeList.get(end);
				end++;
			}
		}
		
		return count;
	}
}
