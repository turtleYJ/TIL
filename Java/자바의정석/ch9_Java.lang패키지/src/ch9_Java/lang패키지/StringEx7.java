package ch9_Java.lang패키지;

public class StringEx7 {
	public static void main(String[] args) {
		String fullName = "Hello.java";
		
		// '.'의 위치 찾기
		int index = fullName.indexOf(".");
		// '.' 전 까지의 문자열 추출
		String fileName = fullName.substring(0, index);
		
		// '.' 후의 문자열 추출
		String ext = fullName.substring(index+1);
		
		System.out.println(index);
		System.out.println(fileName);
		System.out.println(ext);
	}
}
