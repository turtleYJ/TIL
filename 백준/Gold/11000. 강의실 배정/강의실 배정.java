import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 이 문제 다시 풀어볼 것. 직관적이지 않음.
// 시작시간 기준으로 배열을 정렬하고
// 첫번째 배열의 끝나는 시간,classes[0][1]을 기준으로 알고리즘을 시작한다.
// classes[0][1]을 pq에 넣어주고 이 값보다 크거나 같은 시작시간이 나오기 전 까지는 모든 강의의 시작값들을 qp에 넣어준다.(다른 강의실)
// 만약 pq에 가장 peek()값 보다 크거나 값은 값이 나오면 pq.poll()을 해주고 새로운 강의 종료 시간을 offer해준다.
// 결굴 pq에는 강의실의 수 만큼 데이터가 남아있게된다.
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = 0;
		
		N = Integer.parseInt(br.readLine());
		
		int[][] classes = new int[N][2];
		
		StringTokenizer st = null; 
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); 
			classes[i][0] = Integer.parseInt(st.nextToken());
			classes[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(classes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		pq.offer(classes[0][1]);
		
		
		for(int i = 1; i < N; i++) {
			if(classes[i][0] >= pq.peek()) {
				pq.poll();
				pq.offer(classes[i][1]);
			} else {
				pq.offer(classes[i][1]);
			}
		}
		
		System.out.println(pq.size());
	}
}