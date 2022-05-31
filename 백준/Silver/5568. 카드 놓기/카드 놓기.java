import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {

	private static int[] arr;
	private static HashSet<String> set;
	private static int N;
	private static boolean[] isVisit;

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        set = new HashSet<>();
        arr = new int[N];
        isVisit = new boolean[N];
        
        for(int i = 0; i < N; i++) {
        	
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        combi("", k, -1);
        
        System.out.println(set.size());
    }

	private static void combi(String value, int k, int idx) {
		
		if(k == 0) {
			set.add(value);
			
			return;
		}
		
		
		for(int i = 0; i < N; i++) {
			
			if(i != idx && !isVisit[i]) {
				isVisit[i] = true;
				String S = value + arr[i];
				
				combi(S, k - 1, i);
				
				isVisit[i] = false;				
			}
		}
	}
}