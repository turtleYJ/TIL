import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


// 스트링 배열을 이용하여 자료를 쌓고
// comparator를 이용하여 정렬을 한다.
public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = 0; 
        
        N = Integer.parseInt(br.readLine());
        
        String[][] arr = new String[N][4];
        
        for(int i = 0; i < N; i++) {
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	arr[i][0] =  st.nextToken();
        	arr[i][1] =  st.nextToken();
        	arr[i][2] =  st.nextToken();
        	arr[i][3] =  st.nextToken();
        }
        
        Arrays.sort(arr, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				
				if(Integer.parseInt(o2[3]) == Integer.parseInt(o1[3])) {
					
					if(Integer.parseInt(o2[2]) == Integer.parseInt(o1[2])) {
						
						return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
					}
					
					return Integer.parseInt(o2[2]) - Integer.parseInt(o1[2]);
				}
				
				return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
			}
        	
        });
        
        System.out.println(arr[0][0]);
        System.out.println(arr[N - 1][0]);
    }
}