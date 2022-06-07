import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 경우를 나누어 생각한다.
// 1. 멀티탭이 비어있는 경우 -> 멀티탭의 갯수만큼 꽂아준다.
// 2. 멀티탭에 모두 꽂혀있는 경우.
// 2-1 현재 인덱스의 플러그가 이미 꽂혀있는 경우 -> continue
// 2-2 현재 인덱스의 플러그가 꽂혀있지 않은 경우 -> 그 인덱스부터 K보다 작은 수까지를 확인해본다
// 확인 후 현제 멀티탭에 꽂혀있는 것 중 이후에 안 나오는 것이 있다면 그것을 우선적으로 제거한다.
// 만약 멀티탭에 꽂힌 플러그가 모두 나온다면 가장 우선순위가 뒤에 있는 플러그를 뽑고 현재 인덱스를 집어넣는다.
public class Main {

	private static int[] plug;
	private static List<Integer> socket;
	private static int K;
	private static int result;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 0;
		K = 0;
		result = 0; // 플러그를 빼는 최소 횟수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		plug = new int[K]; //  플러그의 순번
		socket = new ArrayList<>(); // 멀티탭에 꽂혀있는 플러그의 리스트
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < plug.length; i++) {
			plug[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		while(idx <  K && socket.size() < N) {
			if(!socket.contains(plug[idx])) {
				socket.add(plug[idx]);
			}
			idx++;
		}
		
		recycle(idx);
		
		System.out.println(result);
		
	}

	private static void recycle(int idx) {
		
		for (int i = idx; i < K; i++) {
			Integer target = plug[i];
			
			if(socket.contains(target)) continue;
			
			List<Integer> overlap = new ArrayList<>();
			Map<Integer, Boolean> map = new HashMap<>();
			
			for (int j = i + 1; j < K; j++) {
				if(socket.contains(plug[j]) && !overlap.contains(plug[j])) {
					overlap.add(plug[j]);
					map.put(plug[j], true);
				}
				
			}
			
			if(overlap.size() >= socket.size()) {
				socket.remove(overlap.get(overlap.size() - 1));
				socket.add(target);
			} else {
				for (int j = 0; j < socket.size(); j++) {
					if(map.get(socket.get(j)) == null) {
						socket.remove(j);
						socket.add(target);
					}
				}
			}
			
			result++;
		}
	}
}