import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	private static List<Test> testList = new ArrayList<>();
	private static int N;
	
	
	private static class Test {
		int value;
		int strike;
		int ball;
		
		Test(int value, int strike, int ball) {
			this.value = value;
			this.strike = strike;
			this.ball = ball;
		}
		
		@Override
		public String toString() {
			
			return "value : " + value + ", strike : " + strike + ", ball : " + ball;
		}
	}
	

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력
        N = 0;
        N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	int value = Integer.parseInt(st.nextToken());
        	int strike = Integer.parseInt(st.nextToken());
        	int ball = Integer.parseInt(st.nextToken());
        	
        	Test t = new Test(value, strike, ball);
        	testList.add(t);
        }
        
        int resultCount = 0;
        
        // 구현
        for(int i = 123; i <= 987; i++) {
        	
        	if(testOverlap((i))) {
        		
        		int tempCount = 0; // 매칭되는 테스트의 개수
        		
        		for(int j = 0; j < N; j++) {
        			
        			Test test = testList.get(j);
        			
        			String testVal = Integer.toString(test.value);
        			String currentVal = Integer.toString(i);
        			
        			int strikeCount = 0;
        			
        			for(int k = 0; k < 3; k++) {
        				
        				if(testVal.charAt(k) == currentVal.charAt(k)) {
        					
        					strikeCount++;
        				}
        			}
        			
        			int ballCount = 0;
        			
        			for(int k = 0; k < 3; k++) {
        				
        				for(int q = 0; q < 3; q++) {
        					
        					if(k != q && testVal.charAt(k) == currentVal.charAt(q)) {
        						
        						ballCount++;
        					}
        				}
        			}
        			
        			if(test.strike == strikeCount && test.ball == ballCount) {
        				
        				tempCount++;
        			}
        			
        			
        		}
        		
        		// 모든 테스트에 대하여 같은 strike와 ball을 가지고 있다면 결과갯수를 증가시킨다.
        		if(tempCount == N) {
        			
        			resultCount++;
        		}
        		
        		
        	}
        }
        
        System.out.println(resultCount);
    }

	private static boolean testOverlap(int value) {
		
		String valueS = Integer.toString(value);
		
		// 하나라도 0이 뜨면 false
		for(int i = 0; i < 3; i++) {
			
			if(valueS.charAt(i) == '0') {
				
				return false;
			}
		}
		
		// 각 자리수에 있는 숫자가 겹치면 false
		for(int i = 0; i < 2; i++) {
			
			for(int j = i + 1; j < 3; j++) {
				
				if(valueS.charAt(i) == valueS.charAt(j)) {
					
					return false;
				}
			}
		}
		
		return true;
	}
}