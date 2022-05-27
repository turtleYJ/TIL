import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] height = new int[9];
		
		int sum = 0;
		
		for(int i = 0; i < height.length; i++) {
			
			height[i] = Integer.parseInt(br.readLine());
			
			sum += height[i];
		}
		
		Arrays.sort(height);
		
		int spyA = 0;
		int spyB = 0;
		
		for(int i = 0; i < height.length - 1; i++) {
			
			for(int j = i + 1; j < height.length; j++) {
				
				if(sum - height[i] - height[j] == 100) {
					spyA = i;
					spyB = j;
				}
			}
		}
		
		for(int i = 0; i < height.length; i++) {
			
			if(i != spyA && i != spyB) {
				
				System.out.println(height[i]);
			}
		}
	}
}