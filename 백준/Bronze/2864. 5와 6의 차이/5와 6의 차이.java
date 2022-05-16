import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = "";
		String B = "";
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = st.nextToken();
		B = st.nextToken();
		
		String maxA = "";
		String minA = "";
		String maxB = "";
		String minB = "";
				
		for(int i = 0; i < A.length(); i++) {
			if(A.charAt(i) == '5') {
				maxA += "6";
			} else {
				maxA += A.charAt(i);
			}
			
			if(A.charAt(i) == '6') {
				minA += "5";
			} else {
				minA += A.charAt(i);
			}
			
		}
		
		for(int i = 0; i < B.length(); i++) {
			if(B.charAt(i) == '5') {
				maxB += "6";
			} else {
				maxB += B.charAt(i);
			}
			
			if(B.charAt(i) == '6') {
				minB += "5";
			} else {
				minB += B.charAt(i);
			}
			
		}
		
		int max = 0;
		int min = 0;
		
		max = Integer.parseInt(maxA) + Integer.parseInt(maxB);
		min = Integer.parseInt(minA) + Integer.parseInt(minB);
		
		System.out.println(min + " " + max);
		
		
	}
	
}