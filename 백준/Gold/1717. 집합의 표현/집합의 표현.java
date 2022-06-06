import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유니온파인드
// Union Find
// 기본
public class Main {

	private static int[] parent; // 인덱스와 값이 같은 것이 루트

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
    	parent = new int[N + 1];
    	
    	for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
    	
    	for (int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int discrim = Integer.parseInt(st.nextToken());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		if(discrim == 0) {
    			union(a, b);
    		} else {
    			boolean ok = find(a, b);
    			if(ok) System.out.println("YES");
    			else System.out.println("NO");    			
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
	private static void union(int x, int y) {
		x = getParent(x);
		y = getParent(y);
		if(x < y) {
			parent[y] = x;
		}
		if(x > y) {
			parent[x] = y;
		}
	}
	
	private static boolean find(int x, int y) {
		if(getParent(x) == getParent(y)) return true;
		return false;
	}
}