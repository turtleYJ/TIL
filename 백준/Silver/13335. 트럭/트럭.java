import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Truck {
	int weight;
	int position;
	int status; // 0 시작전, 1 진행중, 2 종료 
	
	public Truck(int weight, int position, int status) {
		this.weight = weight;
		this.position = position;
		this.status = status;
	}
}
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		boolean[] isOccupied = new boolean[w + 1];
		Truck[] trucks = new Truck[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < trucks.length; i++) {
			trucks[i] = new Truck(Integer.parseInt(st.nextToken()), 0, 0);
		}
		
		int res = 0;
		boolean isFinish = false;
		while (!isFinish) {
			for (int i = 0; i < trucks.length; i++) {
				Truck truck = trucks[i];
				int next = truck.position + 1;
				
				if (truck.status == 2) continue;
				
				if (truck.status == 1) {
					
					if (next > w) {
						isOccupied[truck.position] = false;
						
						truck.position = truck.position + 1;
						truck.status = 2;
						L += truck.weight;
						
					} else {
						if (!isOccupied[next]) {
							isOccupied[next - 1] = false;
							isOccupied[next] = true;
							
							truck.position = truck.position + 1;
						}
					}
					
					
				} else if (truck.status == 0) {
					
					if (isOccupied[next] || L < truck.weight) break;
					
					isOccupied[next] = true;
					L -= truck.weight;
					
					truck.position = truck.position + 1;
					truck.status = 1;
				}
				
				if (trucks[trucks.length - 1].status == 2) {
					isFinish = true;
				}
			}
			
			res++;
		}
		
		System.out.println(res);
	}
}