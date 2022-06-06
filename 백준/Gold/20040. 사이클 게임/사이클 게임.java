import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유니온파인드
// Union Find
// 사이클 형성 시기
public class Main {

	private static int[] parent; // 인덱스와 값이 같은 것이 루트

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
    	parent = new int[n];
    	
    	for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
    	
    	for (int i = 0; i < m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		if(!find(a, b)) {
    			union(a, b);
    		} else {
    			System.out.println(i + 1);
    			return;
    		}
		}
    	
    	System.out.println("0");
    	
    	
        
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