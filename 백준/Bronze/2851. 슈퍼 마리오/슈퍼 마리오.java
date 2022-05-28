import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //
//        Math.min(0, Math.abs(100 - sum)) 
        
        int sum = 0;
        int[] arr = new int[10];
        
        for(int i = 0; i < arr.length; i++) {
        	
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = 0; i < arr.length; i++) {
        	
        	sum += arr[i];
        	
        	if(sum >= 100) {
        		
        		if(sum - 100 > Math.abs(sum - arr[i] -100)) {
        			
        			sum = sum - arr[i];
        		}
        		
        		break;
        	}
        }
        
        System.out.println(sum);
    }
}