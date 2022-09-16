import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		int temp = m;
		int result = m;
		
		for(int i=0; i<n; i++) {
			int in = scan.nextInt();	
			int out = scan.nextInt();	
			temp = temp + in - out;
			
			result = (temp < 0) ? 0 : Math.max(temp, result);
			if(result == 0)	break;
		}
        
		System.out.println(result);
		scan.close();
	}
}