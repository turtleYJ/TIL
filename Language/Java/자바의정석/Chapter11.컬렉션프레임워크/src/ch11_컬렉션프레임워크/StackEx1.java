package ch11_컬렉션프레임워크;

import java.util.Stack;

// 브라우저에서 앞으로 가기 뒤로 가기 버튼을 stack으로 구현한 예제
public class StackEx1 {
	public static Stack back = new Stack();
	public static Stack forward = new Stack();
	
	public static void main(String[] args) {
		goURL("1.네이버");
		goURL("2.구글");
		goURL("3.다음");
		goURL("4.네이트");
		
		System.out.println(back);
		System.out.println(forward);
		
		System.out.println("= 뒤로 가기 버튼 한 번 누른 후 =");
		goBack();
		System.out.println(back);
		System.out.println(forward);
		
		System.out.println("= 뒤로 가기 버튼 두 번 누른 후 =");
		goBack();
		System.out.println(back);
		System.out.println(forward);
		
		System.out.println("= 뒤로 가기 버튼 세 번 누른 후 =");
		goBack();
		System.out.println(back);
		System.out.println(forward);
		
		System.out.println("= 뒤로 가기 버튼 네 번 누른 후 =");
		goBack();
		System.out.println(back);
		System.out.println(forward);
		
		System.out.println("= 앞으로 가기 버튼 한 번 누른 후 =");
		goForward();
		System.out.println(back);
		System.out.println(forward);
		
		System.out.println("= 앞으로 가기 버튼 두 번 누른 후 =");
		goForward();
		System.out.println(back);
		System.out.println(forward);
		
		System.out.println("= 앞으로 가기 버튼 세 번 누른 후 =");
		goForward();
		System.out.println(back);
		System.out.println(forward);
		
		System.out.println("= 앞으로 가기 버튼 네 번 누른 후 =");
		goForward();
		System.out.println(back);
		System.out.println(forward);
		
	}
	
	// 백에 쌓이고 포워드를 모두 제거
	public static void goURL(String url) {
		back.push(url);
		if (!forward.empty()) {
			forward.clear();
		}
	}
	
	// 앞으로 가기 : 앞에 있는 것을 꺼내와서 백에 쌓임
	public static void goForward() {
		if (!forward.empty()) {
			back.push(forward.pop());
		}
	}
	
	// 뒤로 가기 : 백에 스택이 있을 경우에 작동, 백을 꺼내와서 포워드에 넣어준다.
	public static void goBack() {
		if (!back.empty()) {
			forward.push(back.pop());
		}
	}
}
