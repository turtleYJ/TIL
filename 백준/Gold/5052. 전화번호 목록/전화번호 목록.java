import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 겹쳐지는 선분 길이의 총 합
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = br.readLine();
			}
			
			Arrays.sort(arr, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			
			
			});
			
			boolean ok = true;
			
			for (int i = 0; i < arr.length - 1; i++) {
				int beforeLength = arr[i].length();
				
				if(arr[i + 1].length() > beforeLength && arr[i].equals(arr[i + 1].substring(0, beforeLength))) {
					ok = false;
					break;
				}
			}
			
			if(ok) {
				sb.append("YES").append('\n');
			} else {
				sb.append("NO").append('\n');
			}
		}
		System.out.println(sb);
	}
}