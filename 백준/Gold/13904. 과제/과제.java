import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] asn = new int[N][2];
		List<int[]> list = new ArrayList<>();
		StringTokenizer st = null;
		int maxDay = 0;
		
		for (int i = 0; i < asn.length; i++) {
			st = new StringTokenizer(br.readLine());
			asn[i][0] = Integer.parseInt(st.nextToken());
			asn[i][1] = Integer.parseInt(st.nextToken());
			
			list.add(asn[i]);
			
			maxDay = Math.max(maxDay, asn[i][0]);
		}
		
		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o2[1] == o1[1]) {
					return o2[0] - o1[0];
				}
				return o2[1] - o1[1];
			}
		});
		
		int maxScore = 0;
		while(maxDay > 0) {
			for (int i = 0; i < list.size(); i++) {
				int[] temp = list.get(i);
				if(temp[0] >= maxDay) {
					maxScore += temp[1];
					list.remove(i);
					break;
				}
			}
			
			maxDay--;
		}
		
		System.out.println(maxScore);
	}
}