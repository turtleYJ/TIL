import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		int[] dishes = new int[N];
		
		for (int i = 0; i < dishes.length; i++) {
			dishes[i] = Integer.parseInt(br.readLine());
		}
		
		int start = 0;
		int end = 0;
		int count = 0;
		int res = Integer.MIN_VALUE; // 최대로 먹은 종류
		Map<Integer, Integer> map = new HashMap<>();
		while (start < N) {
			int diff = end - start;
			int endC = end % N;
			if (diff == k) {
				if (map.get(c) == null) {
					count = map.size() + 1;
				} else {
					count = map.size();
				}
				res = Math.max(res, count);
				// start의 접시를 맵에서 제거하는 코드
				int dishNum = dishes[start];
				int dishCount = map.get(dishNum) - 1;
				// 접시가 하나도 없으면 아예 맵에서 키값을 제거한다.
				if (dishCount == 0) {
					map.remove(dishNum);
				} else {
					map.put(dishNum, dishCount);
				}
				start++;
			} 
			// diff가 k보다 작을 때
			else {
				int dishNum = dishes[endC];
				map.put(dishNum, map.getOrDefault(dishNum, 0) + 1);
				end++;
			}
		}
		System.out.println(res);
	}
}