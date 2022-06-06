import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

// 유니온파인드
// Union Find
// 서로소
public class Main {

	private static int[] parent; // 인덱스와 값이 같은 것이 루트
	private static int[] count; // 루트에 그 트리의 노드 수가 몇 개인지를 기입한다. 

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
        	int N = Integer.parseInt(br.readLine());
        	HashMap<String, Integer> map = new HashMap<>();
        	parent = new int[N * 2];
        	count = new int[N * 2];
        	
        	for(int i = 0; i < parent.length; i++) {
        		parent[i] = i;
        	}
        	
        	Arrays.fill(count, 1); // 각 노드는 최소 1개의 네트워크를 갖고있다.
        	
        	int k = 0;
        	
        	for(int i = 0; i < N; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		
        		String p1 = st.nextToken();
        		String p2 = st.nextToken();
        		
        		if(!map.containsKey(p1)) {
        			map.put(p1, k++);
        		}
        		if(!map.containsKey(p2)) {
        			map.put(p2, k++);
        		}
        		System.out.println(union(map.get(p1), map.get(p2)));
        	}
        }
    }
	
	// 부모 노드를 찾는 함수
	// 결국 루트 노드를 찾아오는 과정
	private static int getParent(int x) {
		if(parent[x] == x) return x;
		return parent[x] = getParent(parent[x]);
	}
	
	// 두 부모 노드를 합치는 함수
	private static int union(int x, int y) {
		x = getParent(x);
		y = getParent(y);
		if(x < y) {
			parent[y] = x;
			return count[x] += count[y];
		}
		if(x > y) {
			parent[x] = y;
			return count[y] += count[x];
		}
		
		return count[x];
	}
}