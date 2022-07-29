import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Virus {
	int type;
	int y;
	int x;
	
	public Virus(int type, int y, int x) {
		this.type = type;
		this.y = y;
		this.x = x;
	}
}

public class Main {

	private static int[] dy = {1, 0, -1, 0};
	private static int[] dx = {0, 1, 0, -1};
	private static int N;
	private static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] tubes = new int[N][N];
		List<Virus> virusList = new ArrayList<>();
		
		for (int i = 0; i < tubes.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < tubes[0].length; j++) {
				tubes[i][j] = Integer.parseInt(st.nextToken());
				
				if (tubes[i][j] != 0) {
					virusList.add(new Virus(tubes[i][j], i, j));
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		res = 0;
		PriorityQueue<Virus> pq = new PriorityQueue<>(new Comparator<Virus>() {
			@Override
			public int compare(Virus o1, Virus o2) {
				return o1.type - o2.type;
			}
		});
		
		for (Virus virus : virusList) {
			pq.add(virus);
		}
		spread(pq, tubes, S, Y, X);
		
		System.out.println(res);
	}

	private static void spread(PriorityQueue<Virus> q, int[][] tubes, int s, int y, int x) {
		if (s == 0) {
			res = tubes[y - 1][x - 1];
			
			return;
		}
		
		
		PriorityQueue<Virus> npq = new PriorityQueue<>(new Comparator<Virus>() {
			@Override
			public int compare(Virus o1, Virus o2) {
				return o1.type - o2.type;
			}
		});
		
		while (!q.isEmpty()) {
			Virus virus = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = virus.y + dy[i];
				int nx = virus.x + dx[i];
				
				if (ny >= 0 && nx >= 0 &&  ny < N && nx < N) {
					if (tubes[ny][nx] == 0) {
						tubes[ny][nx] = virus.type;
						
						npq.add(new Virus(virus.type, ny, nx));
					}
				}
			}
		}
		
		spread(npq, tubes, s - 1, y, x);
	}
}