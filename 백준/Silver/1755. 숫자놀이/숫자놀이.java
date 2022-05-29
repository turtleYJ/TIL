import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 동일한 문자열의 개수 파악
public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        List<String> numList = new ArrayList<>();        
        
        for(int i = M; i <= N; i++) {
        	
        	String S = "";
        	
        	String num = Integer.toString(i);
        	
        	for(int j = 0; j < num.length(); j++) {
        		
        		if(num.charAt(j) == '1') {
        			S += "one";
        		}
        		if(num.charAt(j) == '2') {
        			S += "two";
        		}
        		if(num.charAt(j) == '3') {
        			S += "three";
        		}
        		if(num.charAt(j) == '4') {
        			S += "four";
        		}
        		if(num.charAt(j) == '5') {
        			S += "five";
        		}
        		if(num.charAt(j) == '6') {
        			S += "six";
        		}
        		if(num.charAt(j) == '7') {
        			S += "seven";
        		}
        		if(num.charAt(j) == '8') {
        			S += "eight";
        		}
        		if(num.charAt(j) == '9') {
        			S += "nine";
        		}
        		if(num.charAt(j) == '0') {
        			S += "zero";
        		}
        	}
        	
        	S += " " + i;
        	
        	numList.add(S);
        }
        
        Collections.sort(numList);
        
        int count = 0;
        
        for(int i = 0; i < numList.size(); i++) {
        	
        	st = new StringTokenizer(numList.get(i));
        	
        	st.nextToken();
        	System.out.print(st.nextToken() + " ");
        	
        	count++;
        	if(count == 10) {
        		
        		System.out.println();
        		count = 0;
        	}
        }
    }
}