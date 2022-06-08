public class Grid {
    long gridTraveler(int m, int n, Map<String, Long> memo) {
		// 메모에 인자들이 있는지 확인
		// 좌상단에서 우하단으로 가는 그리드 방식의 경우의 수 찾기는 (1,2)와 (2,1)이 같은 경우의 수를 가진다.
		String key1 = m + "" + n;
		String key2 = n + "" + m;
		
		if(memo.containsKey(key1)) return memo.get(key1);
		if(m == 1 && n == 1) return 1;
		if(m == 0 || n == 0) return 0;
		
		long value = gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo);
		memo.put(key1, value);
		memo.put(key2, value);
		return memo.get(key1);
	}
}
