import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


// N(입력)의 개수가 100,000까지 가능. -> 배열로 그래프화하면 메모리 제한에 걸림.
public class Main {


	private static ArrayList[] list;
	private static boolean[] isVisit;
	private static int target2;
	private static int result;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 0; // 사람의 수
		n = Integer.parseInt(br.readLine());
		
		int target1 = 0;
		target2 = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		target1 = Integer.parseInt(st.nextToken());
		target2 = Integer.parseInt(st.nextToken());
		
		int m = 0;
		
		m = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}
		
		isVisit = new boolean[n + 1];
		result = 0;
		
		dfs(target1, 0);
		
		if(result != 0) {
			System.out.println(result);
		} else {
			System.out.println(-1);
		}
	}

	private static void dfs(int target1, int numOfVill) {
		
		isVisit[target1] = true;
		
		
		for(int i = 0 ; i < list[target1].size(); i++) {
			int temp = (int) list[target1].get(i);
			
			if(temp == target2) {
				result = numOfVill + 1;
				
				return;
			}
			if(!isVisit[temp]) {
				dfs(temp, numOfVill + 1);
			}
		}
	}
}