import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int L;
	private static int C;
	private static char[] arr;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new char[C];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		sb = new StringBuilder();
		
		printPass("", 0, 0);
		
		System.out.println(sb);
	}

	private static void printPass(String password, int idx, int depth) {
		if(depth == L) {
			if(match(password)) {
				sb.append(password).append('\n');
			}
			
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			if(password.contains("" + arr[i])) continue;
			String nextS = password + arr[i];
			printPass(nextS, i + 1, depth + 1);
		}
	}

	private static boolean match(String password) {
		int vowNum = 0; // 모음 수
		int conNum = 0; // 자음수 
		
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				vowNum++;
			} else {
				conNum++;
			}
		}
		
		if(vowNum >= 1 && conNum >= 2) return true;
		
		return false;
	}
}