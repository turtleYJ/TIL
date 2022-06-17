import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int[][] gear;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gear = new int[4][8];
		
		for (int i = 0; i < gear.length; i++) {
			String S = br.readLine();
			for (int j = 0; j < gear[i].length; j++) {
				gear[i][j] = S.charAt(j) - 48;
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		while(K-- > 0) {
			int[][] gearClone = gear;
			st =  new StringTokenizer(br.readLine());
			
			int currGear = Integer.parseInt(st.nextToken()) - 1;
			int direction = Integer.parseInt(st.nextToken());
			List<int[]> list = new ArrayList<>();
			list.add(new int[] {currGear, direction});
			
			boolean right = true;
			boolean left = true;
			for (int i = 1; i < 4; i++) {
				int nr = currGear + i;
				int nl = currGear - i;
				direction = -direction;
				
				if (nr < 4 && right) {
					if (gear[nr - 1][2] == gear[nr][6]) {
						right = false;
					} else {
//						rotate(nr, direction, gearClone);
						list.add(new int[] {nr, direction});
					}
				}
				if (nl >= 0 && left) {
					if (gear[nl + 1][6] == gear[nl][2]) {
						left = false;
					} else {
//						rotate(nl, direction, gearClone);
						list.add(new int[] {nl, direction});
					}
				}
//				if (i == 1) rotate(nl + 1, -direction, gearClone);
			}
			
			for (int i = 0; i < list.size(); i++) {
				rotate(list.get(i));
			}
		}
		
		int res = 0;
		if(gear[0][0] == 1) res += 1;
		if(gear[1][0] == 1) res += 2;
		if(gear[2][0] == 1) res += 4;
		if(gear[3][0] == 1) res += 8;
		
		System.out.println(res);
	}
	
	private static void rotate(int[] target) {
		int gearNum = target[0];
		int direction = target[1];
		
		
		// 시계방향
		if(direction == 1) {
			int temp = gear[gearNum][gear[gearNum].length - 1];
			for (int i = gear[gearNum].length - 1; i >= 1; i--) {
				gear[gearNum][i] = gear[gearNum][i - 1];
			}
			gear[gearNum][0] = temp;
		}
		// 반시계 방향
		if(direction == -1) {
			int temp = gear[gearNum][0];
			for (int i = 0; i < gear[gearNum].length - 1; i++) {
				gear[gearNum][i] = gear[gearNum][i + 1];
			}
			gear[gearNum][gear[gearNum].length - 1] = temp;
		}
	}

//	private static void rotate(int gearNum, int direction, int[][] gearClone) {
//		
//		// 시계방향
//		if(direction == 1) {
//			int temp = gearClone[gearNum][gearClone[gearNum].length - 1];
//			for (int i = gearClone[gearNum].length - 1; i >= 1; i--) {
//				gearClone[gearNum][i] = gearClone[gearNum][i - 1];
//			}
//			gearClone[gearNum][0] = temp;
//		}
//		// 반시계 방향
//		if(direction == -1) {
//			int temp = gearClone[gearNum][0];
//			for (int i = 0; i < gearClone[gearNum].length - 1; i++) {
//				gearClone[gearNum][i] = gearClone[gearNum][i + 1];
//			}
//			gearClone[gearNum][gearClone[gearNum].length - 1] = temp;
//		}
//	}
}