import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());
        
        char[][] arr = new char[N1 + N2][2];
        
        String order = br.readLine();
        
        for(int i = 0; i < N1; i++) {
        	
        	arr[i][0] = order.charAt(N1 - i - 1);
        	arr[i][1] = '1';
        }
        
        order = br.readLine();
        
        for(int i = N1; i < N1 + N2; i++) {
        	
        	arr[i][0] = order.charAt(i - N1);
        	arr[i][1] = '2';
        }
        
        
        int T = Integer.parseInt(br.readLine());
        
        
        while(T-- > 0) {
        	
        	for(int i = 0; i < N1 + N2; i++) {
        		
        		if(i < N1 + N2 - 1 && arr[i][1] - arr[i+1][1] < 0) {
        			char[] temp = {arr[i + 1][0], arr[i + 1][1]};
        			
        			arr[i + 1][0] = arr[i][0];
        			arr[i + 1][1] = arr[i][1];
        			arr[i][0] = temp[0];
        			arr[i][1] = temp[1];
        			
        			i++;
        		}
        	}
        }
        
        for(int i = 0; i < N1 + N2; i++) {
    		System.out.print(arr[i][0]);
    	}
    }
}