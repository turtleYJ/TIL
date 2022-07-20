import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 지도에서 0은 빈 칸, 6은 벽, 1~5는 CCTV의 번호이다.
// 경우의수, 1,3,4 번 : 4가지, 2번 : 2가지, 5번 : 1가지
// 0 북, 1 동, 2 서, 3 남

class CCTV {
	int type;
	int dir;
	int y;
	int x;
	
	public CCTV(int type, int dir, int y, int x) {
		this.type = type;
		this.dir = dir;
		this.y = y;
		this.x = x;
	}
}

public class Main {

	private static int[][] office;
	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};
	private static int N;
	private static int M;
	private static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		office = new int[N][M];
		List<CCTV> cctvLists = new ArrayList<>();
		
		for (int i = 0; i < office.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < office[0].length; j++) {
				int temp = Integer.parseInt(st.nextToken());
				
				if (temp != 0 && temp != 6) {
					office[i][j] = -1;
					cctvLists.add(new CCTV(temp, 0, i, j));
				} else {
					office[i][j] = temp;
				}
			}
		}
		
//		for (int[] is : office) {
//			for (int i : is) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
//		}
		
		res = Integer.MAX_VALUE;
		combi(cctvLists, cctvLists.size(), 0);
		
		System.out.println(res);
	}

	private static void combi(List<CCTV> cctvLists, int size, int idx) {
		
		if (size == 0) {
			countArea(cctvLists);
			
			return;
		}
					
		for (int i = idx; i < cctvLists.size(); i++) {
			CCTV cctv = cctvLists.get(i);
			
			for (int j = 0; j < 4; j++) {
				cctv.dir = j;
				
				combi(cctvLists, size - 1, i + 1);
			}
		}
	}

	private static void countArea(List<CCTV> cctvLists) {
		
		int[][] officeClone = new int[N][M];
		
		for (int i = 0; i < officeClone.length; i++) {
			for (int j = 0; j < officeClone[0].length; j++) {
				officeClone[i][j] =  office[i][j];
			}
		}
		
		for (int i = 0; i < cctvLists.size(); i++) {
			CCTV cctv = cctvLists.get(i);
			int type = cctv.type;
			
			switch (type) {
			case 1:
				monitorDir(cctv.y, cctv.x, cctv.dir, officeClone);
				
				break;
			case 2:
				monitorDir(cctv.y, cctv.x, cctv.dir, officeClone);
				monitorDir(cctv.y, cctv.x, (cctv.dir + 2) % 4, officeClone);
				
				break;
			case 3:
				monitorDir(cctv.y, cctv.x, cctv.dir, officeClone);
				monitorDir(cctv.y, cctv.x, (cctv.dir + 1) % 4, officeClone);
				
				break;
			case 4:
				monitorDir(cctv.y, cctv.x, cctv.dir, officeClone);
				monitorDir(cctv.y, cctv.x, (cctv.dir + 1) % 4, officeClone);
				monitorDir(cctv.y, cctv.x, (cctv.dir + 3) % 4, officeClone);
				
				break;
			case 5:
				monitorDir(cctv.y, cctv.x, cctv.dir, officeClone);
				monitorDir(cctv.y, cctv.x, (cctv.dir + 1) % 4, officeClone);
				monitorDir(cctv.y, cctv.x, (cctv.dir + 2) % 4, officeClone);
				monitorDir(cctv.y, cctv.x, (cctv.dir + 3) % 4, officeClone);
				
				break;
			}
		}
		
		int cnt = 0;
		for (int[] is : officeClone) {
			for (int n : is) {
				if (n != -1 && n != 6) {
					cnt++;
				}
			}
		}
		
		res = Math.min(cnt, res);
	}

	private static void monitorDir(int y, int x, int dir, int[][] officeClone) {
		int ny = y;
		int nx = x;
		
		while (true) {
			ny += dy[dir];
			nx += dx[dir];
			
			if (ny < 0 || nx < 0 || ny >= N || nx >= M || officeClone[ny][nx] == 6) break;
			
			officeClone[ny][nx] = -1;
		}
	}
}
