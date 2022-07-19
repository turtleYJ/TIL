import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
public class Main {
	static class Dice {
		int top;
		int back;
		int right;
		int left;
		int front;
		int bottom;
		
		public void turn(int dir) {
			switch (dir) {
			case 1: 
				int temp = bottom;
				bottom = right;
				right = top;
				top = left;
				left = temp;
				break;
			case 2: 
				temp = bottom;
				bottom = left;
				left = top;
				top = right;
				right = temp;
				break;
			case 3: 
				temp = bottom;
				bottom = back;
				back = top;
				top = front;
				front = temp;
				break;
			case 4: 
				temp = bottom;
				bottom = front;
				front = top;
				top = back;
				back = temp;
				break;

			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken()); // 세로(행) 위치
		int y = Integer.parseInt(st.nextToken()); // 가로(열) 위
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		Dice dice = new Dice();
		while (K-- > 0) {
			int comm = Integer.parseInt(st.nextToken());
			int nx = x;
			int ny = y;
			
			switch (comm) {
			case 1: 
				ny++;
				
				break;
			case 2: 
				ny--;
				
				break;
			case 3: 
				nx--;
				
				break;
			case 4: 
				nx++;
				
				break;
			}
			
			if(nx >= 0 && ny >= 00 && nx < N && ny < M) {
				dice.turn(comm);
				int num = map[nx][ny];
				x = nx;
				y = ny;
				
				if (num == 0) {
					map[nx][ny] = dice.bottom;
				} else {
					dice.bottom = map[nx][ny];
					map[nx][ny] = 0;
				}
				
				System.out.println(dice.top);
			}
		}
	}
}