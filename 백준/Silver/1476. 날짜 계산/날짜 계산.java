import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int E = 0;
		int S = 0;
		int M = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int e = 1;
		int s = 1;
		int m = 1;
		int year = 1;
		
		while(true) {
			if(e == E && s == S && m == M) {
				
				break;
			}
			
			e++;
			s++;
			m++;
			year++;
			
			if(e == 16) e = 1;
			if(s == 29) s = 1;
			if(m == 20) m = 1;
		}
		
		System.out.println(year);
	}
}