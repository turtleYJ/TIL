import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int height = 0;
		int cnt = 0;
		int cntDown = 0;
		boolean isDown = false;
		boolean pass = true;
		int res = 0;
		
		// 가로 검사
		for (int i = 0; i < map.length; i++) {
			pass = true;
			isDown = false;
			for (int j = 0; j < map.length; j++) {
				if (j == 0) {
					height = map[i][j];
					cnt = 1;
					
					continue;
				}
				
				if (isDown) {
					if (cntDown < L) {
						if (height != map[i][j]) {
							pass = false;
							
							break;
						}
						
						cntDown++;
					} else {
						if (height != map[i][j]) {
							if (map[i][j] > height) {
								pass = false;
								
								break;
							}
							if (height > map[i][j]) {
								isDown = true;
								cntDown = 1;
								
								if (height - map[i][j] >= 2) {
									pass =  false;
									
									break;
								}
								
								height = map[i][j];
							}
						} else {
							isDown = false;
							cnt = 1;
						}
					}
					
					continue;
				}
				
				if (height != map[i][j]) {
					if (height < map[i][j]) {
						if (cnt < L || map[i][j] - height >= 2) {
							pass = false;
							
							break;
						}
					}
					if (height > map[i][j]) {
						isDown = true;
						cntDown = 1;
						
						if (height - map[i][j] >= 2) {
							pass =  false;
							
							break;
						}
					}
					
					height = map[i][j];
					cnt = 1;
				} else {
					cnt++;
				}
				
				
			}
			
			if (pass && (!isDown || cntDown >= L)) {
				res++;
			}
		}
		
		// 세로 검사
		for (int j = 0; j < map.length; j++) {
			pass = true;
			isDown = false;
			for (int i = 0; i < map.length; i++) {
				if (i == 0) {
					height = map[i][j];
					cnt = 1;
					
					continue;
				}
				
				if (isDown) {
					if (cntDown < L) {
						if (height != map[i][j]) {
							pass = false;
							
							break;
						}
						
						cntDown++;
					} else {
						if (height != map[i][j]) {
							if (map[i][j] > height) {
								pass = false;
								
								break;
							}
							if (height > map[i][j]) {
								isDown = true;
								cntDown = 1;
								
								if (height - map[i][j] >= 2) {
									pass =  false;
									
									break;
								}
								
								height = map[i][j];
							}
						} else {
							isDown = false;
							cnt = 1;
						}
					}
					
					continue;
				}
				
				if (height != map[i][j]) {
					if (height < map[i][j]) {
						if (cnt < L || map[i][j] - height >= 2) {
							pass = false;
							
							break;
						}
					}
					if (height > map[i][j]) {
						isDown = true;
						cntDown = 1;
						
						if (height - map[i][j] >= 2) {
							pass =  false;
							
							break;
						}
					}
					
					height = map[i][j];
					cnt = 1;
				} else {
					cnt++;
				}
				
				
			}
			
			if (pass && (!isDown || cntDown >= L)) {
				res++;
			}
		}
		
		System.out.println(res);
	}
}