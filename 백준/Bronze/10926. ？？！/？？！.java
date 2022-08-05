import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 1. Hello World
//		System.out.println("Hello World!");
//		
		// 2. We love kriii
//		System.out.println("강한친구 대한육군");
//		System.out.println("강한친구 대한육군");
//		
//		// 3. 구현(고양이)
//		System.out.println("\\    /\\");
//		System.out.println(" )  ( \')");
//		System.out.println("(  /  )");
//		System.out.println(" \\(__)|");
//		
//		// 7. A×B
//		Scanner sc = new Scanner(System.in);
//		int A, B;		
//		A = sc.nextInt();
//		B = sc.nextInt();		
//		System.out.println(A * B);	
//		
//		// 8. A/B
//		Scanner sc = new Scanner(System.in);
//		double A, B;		
//		A = sc.nextInt();
//		B = sc.nextInt();		
//		System.out.println(A / B);	
		
//		// 9. 사칙연산		
//		Scanner sc = new Scanner(System.in);
//		int A, B;		
//		A = sc.nextInt();
//		B = sc.nextInt();		
//		System.out.println(A + B);			
//		System.out.println(A - B);		
//		System.out.println(A * B);		
//		System.out.println(A / B);
//		System.out.println(A % B);
		
		// 10. ??!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String S = br.readLine();
			
			System.out.println(S + "??!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		
//		// 11. 1998년생인 내가 태국에서는 2541년생?!
//		Scanner sc = new Scanner(System.in);
//		int A;		
//		A = sc.nextInt();
//		
//		System.out.println(A-543);
		
//		//  12. 나머지
//		Scanner sc = new Scanner(System.in);
//		int A, B, C;		
//		A = sc.nextInt();
//		B = sc.nextInt();		
//		C = sc.nextInt();
//		
//		System.out.println((A + B) % C);
//		System.out.println(((A % C) + (B % C)) % C);
//		System.out.println((A * B) % C);
//		System.out.println(((A % C) * (B % C)) % C);
//		
//		// 13. 곱셈
//		Scanner sc = new Scanner(System.in);
//		int A, B;	
//		A = sc.nextInt();
//		B = sc.nextInt();
//		
//		System.out.println(A * (B % 10));
//		System.out.println(A * ((B % 100) / 10));
//		System.out.println(A * (B / 100));
//		System.out.println(A * B);
	}

}