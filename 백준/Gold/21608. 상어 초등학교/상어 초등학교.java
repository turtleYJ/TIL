import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Student {
	int id;
	int y;
	int x;
	int cntF = -1;
	int cntBlk = -1;
	List<Integer> bfList = new ArrayList<Integer>();
	
	public Student(int id, List<Integer> bfList) {
		this.id = id;
		this.bfList = bfList;
	}
}

public class Main {
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Student[][] cls = new Student[N][N];
		
		for (int k = 0; k < Math.pow(N, 2); k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			
			int id = Integer.parseInt(st.nextToken());
			List<Integer> bfList = new  ArrayList<Integer>();
			for (int j = 0; j < 4; j++) {
				bfList.add(Integer.parseInt(st.nextToken()));
			}
			
			Student std = new Student(id, bfList);
			
			for (int i = 0; i < cls.length; i++) {
				for (int j = 0; j < cls[0].length; j++) {
					if (cls[i][j] != null) continue;
					
					int cntBlk = 0;
					int cntF = 0;
					
					for (int q = 0; q < 4; q++) {
						int nr = i + dr[q];
						int nc = j + dc[q];
						
						if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
							if (cls[nr][nc] == null) {
								cntBlk++;
							} else {
								if (std.bfList.contains(cls[nr][nc].id)) {
									cntF++;
								}
							}
						}
					}
					
					if (cntF > std.cntF) {
						std.cntF = cntF;
						std.cntBlk = cntBlk;
						std.y = i;
						std.x = j;
					} else if (cntF == std.cntF) {
						if (cntBlk > std.cntBlk) {
							std.cntBlk = cntBlk;
							std.y = i;
							std.x = j;
						}
					}
				}
			}
			
			cls[std.y][std.x] = std;
		}
		
//		for (Student[] is : cls) {
//			for (Student st : is) {
//				System.out.print(st.id + " ");
//			}
//			System.out.println();
//		}
		
		// 만족도 계산
		int res = 0;
		for (int i = 0; i < cls.length; i++) {
			for (int j = 0; j < cls[0].length; j++) {
				int stfScore = 0;
				int cntF = 0;
				
				for (int q = 0; q < 4; q++) {
					int nr = i + dr[q];
					int nc = j + dc[q];
					
					if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
						if (cls[i][j].bfList.contains(cls[nr][nc].id)) {
							cntF++;
						} 
					}
				}
				
				if (cntF == 1) {
					stfScore = 1;
				}
				if (cntF == 2) {
					stfScore = 10;
				}
				if (cntF == 3) {
					stfScore = 100;
				}
				if (cntF == 4) {
					stfScore = 1000;
				}
				
				res += stfScore;
			}
		}
		
		System.out.println(res);
	}
}
