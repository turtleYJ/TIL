import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		int rod = 64;
		int sum = 64;
		int count = 1;
		
		while (sum != X) {
			rod = rod >> 1;
			
			if (sum - rod >= X) {
				sum = sum - rod;
			} else {
				count++;
			}
		}
		System.out.println(count);
	}
}