import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		LocalDate date = LocalDate.of(2007, x, y);
        DayOfWeek dow = date.getDayOfWeek();
        
        String answer = dow.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();
        
        System.out.println(answer);
	}

}