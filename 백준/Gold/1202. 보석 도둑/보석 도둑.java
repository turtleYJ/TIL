import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 0;
		int K = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		List<Jewelry> jList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			jList.add(new Jewelry(m, v));
		}
		
		Collections.sort(jList, new Comparator<Jewelry>() {
 
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if (o1.m == o2.m) {
                    return o2.v - o1.v;
                }
                return o1.m - o2.m;
            }
 
        });
		
		int[] bag = new int[K];
		
		for(int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(bag);
		
		int i = 0;
		int j = 0;
		long sum = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e2 - e1);
		while(K-- > 0) {
			// 이 부분 다시 확인하기
			while(j < N && jList.get(j).m <= bag[i]) {
					pq.offer(jList.get(j++).v);
			}
			
			if(!pq.isEmpty()) {
				sum += pq.poll();
			}
			
			i++;
		}
		
		System.out.println(sum);
		
	}
	
	public static class Jewelry {
		int m;
		int v;
		
		Jewelry(int m, int v) {
			this.m = m;
			this.v = v;
		}
	}
}