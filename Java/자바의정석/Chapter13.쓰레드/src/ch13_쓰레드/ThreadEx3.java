package ch13_쓰레드;

// main 메서드가 포함되어 있다. 쓰레드가 새로 생성되지 않았음을 의미.
public class ThreadEx3 {
	public static void main(String[] args) {
		ThreadEx3_1 t1 = new ThreadEx3_1();
		t1.run();
	}
}

class ThreadEx3_1 extends Thread {
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
