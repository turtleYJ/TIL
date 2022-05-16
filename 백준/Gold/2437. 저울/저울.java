import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 추를 올려 측정할 수 없는 최소값을 찾는 문제
		// 컨셉자체는 직관적이지 않지만 정형화된 패턴으로 이해하고 넘어갈 것.
		// 추배열을 정렬한다.
		// 누적합 + 1의 값보다 다음 인덱스의 값이 크면 측적할 수 없는 최대값은 누적합 + 1이 된다.
		
		int N = 0;
		
		N = Integer.parseInt(br.readLine());
		int[] weight = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < weight.length; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(weight);
		
		int sum = 0;
		for(int i = 0; i < weight.length; i++) {
			if(weight[i] > sum + 1) break;
			
			sum += weight[i];
		}
		
		System.out.println(sum +1);
	}
}