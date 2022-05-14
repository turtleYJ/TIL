import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = 0;
		int sum = 0;
		
		N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		int countM = 0;
		for(int i = 0; i < N; i++) {
			int value = Integer.parseInt(br.readLine());
			
			if(value < 0) {
				countM++;
			}
			arr[i] = value;
		}
		
		Arrays.sort(arr);
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		for(int i = 0; i < arr.length; i++) {
			dq.offer(arr[i]);
		}
		
		int minusN = countM / 2;
		
		while(minusN-- > 0) {
			sum += dq.poll() * dq.poll();
		}
		
		if(countM % 2 != 0 && dq.contains(new Integer(0))) {
			sum += dq.poll() * dq.poll();
		}
		
		while(!dq.isEmpty()) {
			int x = dq.pollLast();
			
			if(x == 1) {
				sum += x;
				continue;
			}
			
			if(dq.peekLast() != null && dq.peekLast() > 1) {
				sum += x * dq.pollLast();
			} else {
				sum += x;
			}
		}
		
		
		
		System.out.println(sum);
		
	}

}