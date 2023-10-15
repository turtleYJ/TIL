package ch13_쓰레드;

// 메인 메서드가 콜스택에 포함되지 않았다.
// 새로운 스레드가 생성되었으며 한 쓰레드에서 예외가 발생되어 종료되어도 다른 쓰레드에 영향을 주지 않는다.
public class ThreadEx2 {
	public static void main(String[] args) {
		ThreadEx2_1 t1 = new ThreadEx2_1();
		t1.start();
	}

}

class ThreadEx2_1 extends Thread {
	public void run() {
		throwException();
	}
	
	public void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
