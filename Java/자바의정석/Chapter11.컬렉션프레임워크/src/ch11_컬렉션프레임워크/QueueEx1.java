package ch11_컬렉션프레임워크;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

// unix history기능 구현
public class QueueEx1 {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;
	
	public static void main(String[] args) {
		System.out.println("help를 입력하면 도움말을 볼 수 습니다.");
		
		while (true) {
			Scanner s = new Scanner(System.in);
			String input = s.nextLine().trim();
			
			// 엔터 입력하는 경우(input에 빈 문자열 들어오는 경우), q입력하는 경우, help입력하는 경우, history입력하는 경우
			if ("".equals(input)) continue;
			
			if (input.equalsIgnoreCase("q")) {
				System.exit(0);
			} else if (input.equalsIgnoreCase("help")) {
				System.out.println(" help - 도움말을 보여줍니다.");
				System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
				System.out.println(" history - 최근에 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다.");
			} else if (input.equalsIgnoreCase("history")) {
				LinkedList tmp = (LinkedList) q;
				ListIterator it = tmp.listIterator();
				
				while (it.hasNext()) {
					System.out.println(it.next());
				}
			} else {
				save(input);
			}
		}
	}

	private static void save(String input) {
		q.offer(input);
		
		if (q.size() > MAX_SIZE) {
			q.poll();
		}
	}
}
