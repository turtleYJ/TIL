import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// combination
// 근데 각 의상 종류별 null을 포함한다. 모든 종류별로 null이 나오는 단 한가지 경우만 제외하고 모두 허용된다.
// 따라서 각각의 종류별로 1개를 뽑을 경우의 수 nC1을 각각 뽑고 곱해주어 마지막에 1을 빼준다. 
public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
        	
        	s1.add(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < M; i++) {
        	
        	s2.add(Integer.parseInt(st.nextToken()));
        }
        
        int temp = s1.size() + s2.size();
        
        s1.retainAll(s2);
        
        int result = temp - 2 * s1.size();
        
        System.out.println(result);
    }
}