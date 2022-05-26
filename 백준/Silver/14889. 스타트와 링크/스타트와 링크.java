import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백트래킹
// 새로운 함수(diff)를 사용하여 작업할 내용을 기술
// statBalance함수의 매개변수로 order을 사용해서 다음 인덱스(선수)의 번호를 알려준다.
public class Main {


	private static int N;
	private static int[][] statArr;
	private static int numPlyers;
	private static boolean[] isVisit;
	private static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = 0;
		
		N = Integer.parseInt(br.readLine());
		
		statArr = new int[N][N];
		
		StringTokenizer st = null;
		
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				
				statArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		numPlyers = N / 2;
		isVisit = new boolean[N];
		
		
		statBalance(0, 0);
		
		System.out.println(result);
	}

	private static void statBalance(int order, int count) {
		
		if(count == numPlyers) {
			
			diff();
			
			return;
		}
		
		for(int i = order; i < N; i++) {
			
			isVisit[i] = true;
			statBalance(i + 1, count + 1);
			isVisit[i] = false;
		}
		
	}

	private static void diff() {
		int teamStart = 0;
		int teamLink= 0;
		
		for(int i = 0; i < N - 1; i++) {
			
			for(int j = i + 1; j < N; j++) {
				
				if(isVisit[i] && isVisit[j]) {
					
					teamStart += statArr[i][j];
					teamStart += statArr[j][i];
				}
				
				if(!isVisit[i] && !isVisit[j]) {
					
					teamLink += statArr[i][j];
					teamLink += statArr[j][i];
				}
			}
		}
		
		result = Math.min(result, Math.abs(teamStart - teamLink));
	}
}