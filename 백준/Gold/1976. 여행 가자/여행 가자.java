import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유니온파인드
// Union Find
// 연결 관계가 배열로 주어진 경우
public class Main {

	private static int[] parent; // 인덱스와 값이 같은 것이 루트

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        StringTokenizer st = null;
        parent = new int[N + 1];
        
        for(int i = 1; i < parent.length; i++) {
        	parent[i] = i;
        }
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i < j && arr[i][j] == 1) {
					union(i + 1, j + 1);
				}
			}
		}
        
        st = new StringTokenizer(br.readLine());
        int root = getParent(Integer.parseInt(st.nextToken()));
        while(st.hasMoreTokens()) {
        	if(root != getParent(Integer.parseInt(st.nextToken()))) {
        		System.out.println("NO");
        		return;
        	}
        }
        
        System.out.println("YES");
    }
	
	private static int getParent(int x) {
		if(parent[x] == x) return x;
		return parent[x] = getParent(parent[x]);
	}

	private static void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if(b < a) parent[a] = b;
		if(a < b) parent[b] = a;
	}
}