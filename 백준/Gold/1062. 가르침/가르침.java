import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조합을 이용해 풀이.
public class Main {
	
	private static int nk;
	private static boolean[] alphabet;
	private static int res;
	private static String[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 배울 수 있는 단어의 수
		nk = K - 5; // 기본 5개의 단어 외에 배울 수 있는 단어의 수
		arr = new String[N]; // 단어들을 배열에 입력
		res = 0;
		
		// 기본 단어 5개 보다 적게 배운다면 아무단어도 읽을 수 없다.
		if (K < 5) {
			System.out.println(res);
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine();
		}
		
		alphabet = new boolean[26];
		
		alphabet['a' - 'a'] = true;
		alphabet['c' - 'a'] = true;
		alphabet['i' - 'a'] = true;
		alphabet['n' - 'a'] = true;
		alphabet['t' - 'a'] = true;
		
		// idx가 b의 인덱스인 1부터 시작.
		combi(1, 0);
		
		System.out.println(res);
		
		
	}

	private static void combi(int idx, int count) {
		if(count == nk) {
			int wordNum = countWord();
			res = Math.max(res, wordNum);
			
			return;
		}
		
		for (int i = idx; i < alphabet.length; i++) {
			if(!alphabet[i]) {
				alphabet[i] = true;
				combi(i + 1, count + 1);
				alphabet[i] = false;
			}
		}
	}

	private static int countWord() {
		
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			String S = arr[i];
			boolean flag = true;
			
			for (int j = 0; j < S.length(); j++) {
				int n = S.charAt(j) - 97;
				
				if(!alphabet[n]) {
					flag = false;
					
					break;
				}
			}
			if(flag) {
				count++;
			}
		}
		
		return count;
	}
}