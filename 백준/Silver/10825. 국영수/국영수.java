import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// Comparator구현
class Score {
	String name;
	int korean;
	int english;
	int math;
	
	Score(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	@Override
	public String toString() {
		return name + " " + korean + " " + english + " " + math;
	}
}

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Score[] person = new Score[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			person[i] = new Score(
					st.nextToken(), 
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken())
					);
		}
		
		Arrays.sort(person, new Comparator<Score>() {

			@Override
			public int compare(Score s1, Score s2) {
				
				if(s1.korean == s2.korean) {
					
					if(s1.english == s2.english) {		
						
						if(s1.math == s2.math) {							
							return s1.name.compareTo(s2.name);
						}
						
						return s2.math - s1.math;
					}
					
					return s1.english - s2.english;
				}
				
				return s2.korean - s1.korean;
			}
			
			
		});
		
		for (Score score : person) {
			System.out.println(score.name);
		}
	}
}
