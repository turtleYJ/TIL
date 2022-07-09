import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			String S = br.readLine();
			
			if(isPalindrome(S)) {
				System.out.println(0);
				
			} else if(isPseudoPalindrome(S)) {
				System.out.println(1);
				
			} else {
				System.out.println(2);
			}
		}
		
	}
	
	private static boolean isPseudoPalindrome(String s) {
//		int[] df = {0, 1, 0};
//		int[] db = {0, 0, 1};
		boolean flag = true;
		
		
		int typeNum = 0;
		for (int j = 0; j < s.length() / 2; j++) {
			
//			if (s.charAt(j + df[typeNum]) != s.charAt(s.length() - 1 - db[typeNum] - j)) {
			if (s.charAt(j) != s.charAt(s.length() - 1 - j)) {
				// 양쪽 인덱스의 문자를 제거하고 펠린드롬을 돌려본다.
				String s1 = s.substring(j + 1, s.length() - j);
				if (isPalindrome(s1)) {
					return true;
				}
				
				String s2 = s.substring(j, s.length() - 1 - j);
				if (isPalindrome(s2)) {
					return true;
				}
				
				return false;
				
//				if (flag) {
//					while (s.charAt(j + df[typeNum]) != s.charAt(s.length() - 1 - db[typeNum] - j)) {
//						typeNum++;
//						
//						if (typeNum == 3) {
//							return false;
//						}
//					}
//					flag = false;
//				} else {
//					return false;
//				}
				
			}
		}
		return false;
	}

	private static boolean isPalindrome(String s) {
    	
    	for (int j = 0; j < s.length() / 2; j++) {
			if(s.charAt(j) != s.charAt(s.length() - 1 - j)) {
				return false;
			}
		}
		return true;
	}
}