import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Belt[] belt = new Belt[N * 2];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < belt.length; i++) {
			belt[i] = new Belt(false, Integer.parseInt(st.nextToken()));
		}
		
		int res = 0;
		while (true) {
			int cnt = 0;
			res++;
			
			// 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
			rotate(belt);
			
			// 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
			move(belt);
			
			// 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			if (belt[0].durability > 0) {
				belt[0].durability--;
				belt[0].isRobot = true;
			}
			
			// 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
			for (Belt bt : belt) {
				if (bt.durability == 0) cnt++;
			}
			
			if (cnt >= K) {
				break;
			}
		}
		
		System.out.println(res);
		
	}

	private static void move(Belt[] belt) {
		belt[N - 1].isRobot = false;
		
		for (int i = N - 2; i >= 0; i--) {
			if (belt[i].isRobot && belt[i + 1].durability > 0  && !belt[i + 1].isRobot) {
				belt[i + 1].durability--;
				belt[i + 1].isRobot = true;
				belt[i].isRobot = false;
			}
		}
	}

	private static void rotate(Belt[] belt) {
		Belt temp = null;
		
		for (int i = belt.length - 1; i >= 0; i--) {
			if (i == belt.length - 1) {
				temp = belt[i];
			}
			if (i == 0) {
				belt[i] = temp;
				continue;
			}
			if (i == N) {
				belt[i - 1].isRobot = false;
			}
			
			belt[i] = belt[i - 1];
		}
	}
}

class Belt {
	boolean isRobot;
	int durability;
	
	public Belt(boolean isRobot, int durability) {
		this.isRobot = isRobot;
		this.durability = durability;
	}

	@Override
	public String toString() {
		return "Belt [isRobot=" + isRobot + ", durability=" + durability + "]";
	}
}