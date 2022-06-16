import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		Stack<Character> s = new Stack<>();
		Map<Integer, Integer> level = new HashMap<>();
		
		try {
			roof:
				for (int i = 0; i < S.length(); i++) {
					char ch = S.charAt(i);
					
					switch (ch) {
					case '(':
					case '[':
						s.push(ch);
						break;
						
					case ')':
						if(s.peek() != '(') {
							level.put(0, 0);
							break roof;
						}
						
						// 스택에 몇개의 여는 괄호가 있는지 확인한다.
						int lv = s.size() - 1;
						Integer des = level.get(lv + 1);
						// 이 괄호 안에 다른 값이 없었으면
						if (des == null) {
							level.put(lv, level.getOrDefault(lv, 0) + 2);
						}
						// 괄호 안에 값이 있었으면
						else {
							level.put(lv, level.getOrDefault(lv, 0) + des * 2);
							level.remove(lv + 1);
						}
						
						s.pop();
						
						break;
					case ']':
						if(s.peek() != '[') {
							level.put(0, 0);
							break roof;
						}
						// 스택에 몇개의 여는 괄호가 있는지 확인한다.
						lv = s.size() - 1;
						des = level.get(lv + 1);
						// 이 괄호 안에 다른 값이 없었으면
						if (des == null) {
							level.put(lv, level.getOrDefault(lv, 0) + 3);
						}
						// 괄호 안에 값이 있었으면
						else {
							level.put(lv, level.getOrDefault(lv, 0) + des * 3);
							level.remove(lv + 1);
						}
						
						s.pop();
						
						break;
					}

				}
		} catch (Exception e) {
			level.put(0, 0);
		}
		
		System.out.println(level.getOrDefault(0, 0));
	}
}