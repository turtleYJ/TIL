import java.util.Scanner;

public class Coin1 {

	public static void main(String[] args) {
		// 4가지의 동전(500원, 100원, 50원, 10원)을 사용하여 주어진 금액을 거슬러준다.
		// 단 최소 동전의 갯수가 나오도록 알고리즘을 구성한다.
		
		int result = 0;
		int Remainder = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("금액을 입력하시오 : ");
		Remainder = sc.nextInt();
		
		result += Remainder / 500;
		Remainder %= 500;
		
		result += Remainder / 100;
		Remainder %= 100;
		
		result += Remainder / 50;
		Remainder %= 50;
		
		result += Remainder / 10;
		Remainder %= 10;
		
		System.out.println("최소 동전의 갯수 : " + result);
		
		
		

	}

}
