import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] arr;

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        arr = new int[5];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < arr.length; i++) {
        	
        	arr[i] = Integer.parseInt(st.nextToken());
        	
        	max = Math.max(max, arr[i]);
        }
        
        for(int i = 1; i < Math.pow(10, 10); i++) {
        	
        	if(divide(i)) {
        		
        		System.out.println(i);
        		
        		break;
        	}
        }
    }

	private static boolean divide(int value) {
		
		int count = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			if(value % arr[i] == 0) {
				count++;
			}
			
			if(count == 3) {
				return true;
			}
		}
		
		return false;
	}
}