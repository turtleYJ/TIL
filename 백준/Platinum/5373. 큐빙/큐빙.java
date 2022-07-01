import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[][][] cube;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		for (int[][] is : cube) {
//			for (int[] is2 : is) {
//				for (int i : is2) {
//					System.out.print(i + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0)  {
			cube = new int[6][3][3];
			
			// 0 - 위, 1 - 아래, 2-앞, 3-뒤, 4-왼, 5-오른쪽
			for (int i = 0; i < cube.length; i++) {
				for (int j = 0; j < cube[i].length; j++) {
					for (int k = 0; k < cube[i][j].length; k++) {
						cube[i][j][k] = i;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			while (st.hasMoreTokens()) {
				String S = st.nextToken();
				
				char side = S.charAt(0); 
				char dir = S.charAt(1);
				
				switch (side) {
				case 'U':
					turnU(dir);
					
					break;
				case 'D':
					turnD(dir);
					
					break;
				case 'F':
					turnF(dir);
					
					break;
				case 'B':
					turnB(dir);
					
					break;
				case 'L':
					turnL(dir);
					
					break;
				case 'R':
					turnR(dir);
					
					break;

				}
			}
			
			for (int i = 0; i < cube[0].length; i++) {
				for (int j = 0; j < cube[0][i].length; j++) {
					int n = cube[0][i][j];
					
					switch (n) {
					case 0:
						sb.append('w');
						break;
					case 1:
						sb.append('y');
						break;
					case 2:
						sb.append('r');
						break;
					case 3:
						sb.append('o');
						break;
					case 4:
						sb.append('g');
						break;
					case 5:
						sb.append('b');
						break;
					}
				}
				sb.append('\n');
			}
		}
		
		System.out.println(sb);
		
		
//		for (int[][] is : cube) {
//			for (int[] is2 : is) {
//				for (int i : is2) {
//					System.out.print(i + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		
		
		
		
	}

	private static void turnR(char dir) {
		if (dir == '-') {
			// 0(위)의 정보를 저장해둠
			int temp1 = cube[0][0][2];
			int temp2 = cube[0][1][2];
			int temp3 = cube[0][2][2];
			
			// 3 -> 0 (뒤 -> 위)
			cube[0][0][2] = cube[3][0][2];
			cube[0][1][2] = cube[3][1][2];
			cube[0][2][2] = cube[3][2][2];
			
			// 1 -> 3 (아래 -> 뒤)
			cube[3][0][2] = cube[1][0][2];
			cube[3][1][2] = cube[1][1][2];
			cube[3][2][2] = cube[1][2][2];
			
			// 2 -> 1 (앞 -> 아래)
			cube[1][0][2] = cube[2][0][2];
			cube[1][1][2] = cube[2][1][2];
			cube[1][2][2] = cube[2][2][2];
			
			// 0 -> 2 (위 -> 앞)
			cube[2][0][2] = temp1;
			cube[2][1][2] = temp2;
			cube[2][2][2] = temp3;
			
//			counterClock(cube[5]);
			counterClock(5);
			
			
		} else {
			// 0(위)의 정보를 저장해둠
			int temp1 = cube[0][0][2];
			int temp2 = cube[0][1][2];
			int temp3 = cube[0][2][2];
			
			// 2 -> 0 (앞 -> 위)
			cube[0][0][2] = cube[2][0][2];
			cube[0][1][2] = cube[2][1][2];
			cube[0][2][2] = cube[2][2][2];
			
			// 1 -> 2 (아래 -> 앞)
			cube[2][0][2] = cube[1][0][2];
			cube[2][1][2] = cube[1][1][2];
			cube[2][2][2] = cube[1][2][2];
			
			// 3 -> 1 (뒤 -> 아래)
			cube[1][0][2] = cube[3][0][2];
			cube[1][1][2] = cube[3][1][2];
			cube[1][2][2] = cube[3][2][2];
			
			// 0 -> 3 (위 -> 뒤)
			cube[3][0][2] = temp1;
			cube[3][1][2] = temp2;
			cube[3][2][2] = temp3;
			
//			clock(cube[5]);
			clock(5);
		}
		
//		// 임시 출력
//		for (int[][] is : cube) {
//			for (int[] is2 : is) {
//				for (int i : is2) {
//					char ch = '\u0000';
//					switch (i) {
//					case 0:
//						ch = 'w';
//						break;
//					case 1:
//						ch = 'y';
//						break;
//					case 2:
//						ch = 'r';
//						break;
//					case 3:
//						ch = 'o';
//						break;
//					case 4:
//						ch = 'g';
//						break;
//					case 5:
//						ch = 'b';
//						break;
//					}
//					System.out.print(ch + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
//		
//		System.out.println("=======================================");
	}

	private static void turnL(char dir) {
		if (dir == '-') {
			// 0(위)의 정보를 저장해둠
			int temp1 = cube[0][0][0];
			int temp2 = cube[0][1][0];
			int temp3 = cube[0][2][0];
			
			// 2 -> 0 (앞 -> 위)
			cube[0][0][0] = cube[2][0][0];
			cube[0][1][0] = cube[2][1][0];
			cube[0][2][0] = cube[2][2][0];
			
			// 1 -> 2 (아래 -> 앞)
			cube[2][0][0] = cube[1][0][0];
			cube[2][1][0] = cube[1][1][0];
			cube[2][2][0] = cube[1][2][0];
			
			// 3 -> 1 (뒤 -> 아래)
			cube[1][0][0] = cube[3][0][0];
			cube[1][1][0] = cube[3][1][0];
			cube[1][2][0] = cube[3][2][0];
			
			// 0 -> 3 (위 -> 뒤)
			cube[3][0][0] = temp1;
			cube[3][1][0] = temp2;
			cube[3][2][0] = temp3;
			
			// 각 면 회전(4)
//			counterClock(cube[4]);
			counterClock(4);
			
		} else {
			// 0(위)의 정보를 저장해둠
			int temp1 = cube[0][0][0];
			int temp2 = cube[0][1][0];
			int temp3 = cube[0][2][0];
			
			// 3 -> 0 (뒤 -> 위)
			cube[0][0][0] = cube[3][0][0];
			cube[0][1][0] = cube[3][1][0];
			cube[0][2][0] = cube[3][2][0];
			
			// 1 -> 3 (아래 -> 뒤)
			cube[3][0][0] = cube[1][0][0];
			cube[3][1][0] = cube[1][1][0];
			cube[3][2][0] = cube[1][2][0];
			
			// 2 -> 1 (앞 -> 아래)
			cube[1][0][0] = cube[2][0][0];
			cube[1][1][0] = cube[2][1][0];
			cube[1][2][0] = cube[2][2][0];
			
			// 0 -> 2 (위 -> 앞)
			cube[2][0][0] = temp1;
			cube[2][1][0] = temp2;
			cube[2][2][0] = temp3;
			
//			clock(cube[4]);
			clock(4);
		}
		
//		// 임시 출력
//		for (int[][] is : cube) {
//			for (int[] is2 : is) {
//				for (int i : is2) {
//					char ch = '\u0000';
//					switch (i) {
//					case 0:
//						ch = 'w';
//						break;
//					case 1:
//						ch = 'y';
//						break;
//					case 2:
//						ch = 'r';
//						break;
//					case 3:
//						ch = 'o';
//						break;
//					case 4:
//						ch = 'g';
//						break;
//					case 5:
//						ch = 'b';
//						break;
//					}
//					System.out.print(ch + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
//		
//		System.out.println("=======================================");
	}

	private static void turnB(char dir) {
		if (dir == '-') {
			// 0(위)의 정보를 저장해둠
			int temp1 = cube[0][0][0];
			int temp2 = cube[0][0][1];
			int temp3 = cube[0][0][2];
			
			// 4 -> 0 (왼 -> 위)
			cube[0][0][0] = cube[4][0][0];
			cube[0][0][1] = cube[4][0][1];
			cube[0][0][2] = cube[4][0][2];
			
			// 1 -> 4 (아래 -> 왼)
			cube[4][0][0] = cube[1][2][2];
			cube[4][0][1] = cube[1][2][1];
			cube[4][0][2] = cube[1][2][0];
			
			// 5 -> 1 (오 -> 아래)
			cube[1][2][2] = cube[5][0][0];
			cube[1][2][1] = cube[5][0][1];
			cube[1][2][0] = cube[5][0][2];
			
			// 0 -> 5 (위 -> 오)
			cube[5][0][0] = temp1;
			cube[5][0][1] = temp2;
			cube[5][0][2] = temp3;
			
//			counterClock(cube[3]);
			counterClock(3);
		} else {
			// 0(위)의 정보를 저장해둠
			int temp1 = cube[0][0][0];
			int temp2 = cube[0][0][1];
			int temp3 = cube[0][0][2];
			
			// 5 -> 0 (오 -> 위)
			cube[0][0][0] = cube[5][0][0];
			cube[0][0][1] = cube[5][0][1];
			cube[0][0][2] = cube[5][0][2];
			
			// 1 -> 5 (아래 -> 오)
			cube[5][0][0] = cube[1][2][2];
			cube[5][0][1] = cube[1][2][1];
			cube[5][0][2] = cube[1][2][0];
			
			// 4 -> 1 (왼 -> 아래)
			cube[1][2][2] = cube[4][0][0];
			cube[1][2][1] = cube[4][0][1];
			cube[1][2][0] = cube[4][0][2];
			
			// 0 -> 4 (위 -> 왼)
			cube[4][0][0] = temp1;
			cube[4][0][1] = temp2;
			cube[4][0][2] = temp3;
			
//			clock(cube[3]);
			clock(3);
		}
		
//		// 임시 출력
//		for (int[][] is : cube) {
//			for (int[] is2 : is) {
//				for (int i : is2) {
//					char ch = '\u0000';
//					switch (i) {
//					case 0:
//						ch = 'w';
//						break;
//					case 1:
//						ch = 'y';
//						break;
//					case 2:
//						ch = 'r';
//						break;
//					case 3:
//						ch = 'o';
//						break;
//					case 4:
//						ch = 'g';
//						break;
//					case 5:
//						ch = 'b';
//						break;
//					}
//					System.out.print(ch + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
//		
//		System.out.println("=======================================");
	}

	private static void turnF(char dir) {
		if (dir == '-') {
			// 1(아래)의 정보를 저장해둠
			int temp1 = cube[1][0][0];
			int temp2 = cube[1][0][1];
			int temp3 = cube[1][0][2];
			
			// 4 -> 1
			cube[1][0][0] = cube[4][2][2];
			cube[1][0][1] = cube[4][2][1];
			cube[1][0][2] = cube[4][2][0];
			
			// 0 -> 4
			cube[4][2][2] = cube[0][2][2];
			cube[4][2][1] = cube[0][2][1];
			cube[4][2][0] = cube[0][2][0];
			
			// 5 -> 0
			cube[0][2][2] = cube[5][2][2];
			cube[0][2][1] = cube[5][2][1];
			cube[0][2][0] = cube[5][2][0];
			
			// 1 -> 5 (위 -> 왼)
			cube[5][2][2] = temp1;
			cube[5][2][1] = temp2;
			cube[5][2][0] = temp3;
			
//			counterClock(cube[2]);
			counterClock(2);
		} else {
			// 1(아래)의 정보를 저장해둠
			int temp1 = cube[1][0][0];
			int temp2 = cube[1][0][1];
			int temp3 = cube[1][0][2];
			
			// 5 -> 1
			cube[1][0][0] = cube[5][2][2];
			cube[1][0][1] = cube[5][2][1];
			cube[1][0][2] = cube[5][2][0];
			
			// 0 -> 5
			cube[5][2][2] = cube[0][2][2];
			cube[5][2][1] = cube[0][2][1];
			cube[5][2][0] = cube[0][2][0];
			
			// 4 -> 0
			cube[0][2][2] = cube[4][2][2];
			cube[0][2][1] = cube[4][2][1];
			cube[0][2][0] = cube[4][2][0];
			
			// 1 -> 4 (위 -> 왼)
			cube[4][2][2] = temp1;
			cube[4][2][1] = temp2;
			cube[4][2][0] = temp3;
			
//			clock(cube[2]);
			clock(2);
		}
		
//		// 임시 출력
//		for (int[][] is : cube) {
//			for (int[] is2 : is) {
//				for (int i : is2) {
//					char ch = '\u0000';
//					switch (i) {
//					case 0:
//						ch = 'w';
//						break;
//					case 1:
//						ch = 'y';
//						break;
//					case 2:
//						ch = 'r';
//						break;
//					case 3:
//						ch = 'o';
//						break;
//					case 4:
//						ch = 'g';
//						break;
//					case 5:
//						ch = 'b';
//						break;
//					}
//					System.out.print(ch + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
//		
//		System.out.println("=======================================");
	}

	private static void turnD(char dir) {
		if (dir == '-') {
			// 뒤가 기준
			int temp1 = cube[3][0][0];
			int temp2 = cube[3][0][1];
			int temp3 = cube[3][0][2];
			
			// 4 -> 3 (왼 -> 뒤)
			cube[3][0][0] = cube[4][2][0];
			cube[3][0][1] = cube[4][1][0];
			cube[3][0][2] = cube[4][0][0];
			
			// 2 -> 4 (앞 -> 왼)
			cube[4][2][0] = cube[2][2][2];
			cube[4][1][0] = cube[2][2][1];
			cube[4][0][0] = cube[2][2][0];
			
			// 5 -> 2 (오 -> 앞)
			cube[2][2][2] = cube[5][0][2];
			cube[2][2][1] = cube[5][1][2];
			cube[2][2][0] = cube[5][2][2];
			
			// 3 -> 5 (뒤 -> 왼)
			cube[5][0][2] = temp1;
			cube[5][1][2] = temp2;
			cube[5][2][2] = temp3;
			
//			counterClock(cube[1]);
			counterClock(1);
		} else {
			
			// 뒤가 기준
			int temp1 = cube[3][0][0];
			int temp2 = cube[3][0][1];
			int temp3 = cube[3][0][2];
			
			// 5 -> 3 (오 -> 뒤)
			cube[3][0][0] = cube[5][0][2];
			cube[3][0][1] = cube[5][1][2];
			cube[3][0][2] = cube[5][2][2];
			
			// 2 -> 5 (앞 -> 오)
			cube[5][0][2] = cube[2][2][2];
			cube[5][1][2] = cube[2][2][1];
			cube[5][2][2] = cube[2][2][0];
			
			// 4 -> 2 (왼 -> 앞)
			cube[2][2][2] = cube[4][2][0];
			cube[2][2][1] = cube[4][1][0];
			cube[2][2][0] = cube[4][0][0];
			
			// 3 -> 4 (뒤 -> 왼)
			cube[4][2][0] = temp1;
			cube[4][1][0] = temp2;
			cube[4][0][0] = temp3;
			
			
//			clock(cube[1]);
			clock(1);
		}
		
//		// 임시 출력
//		for (int[][] is : cube) {
//			for (int[] is2 : is) {
//				for (int i : is2) {
//					char ch = '\u0000';
//					switch (i) {
//					case 0:
//						ch = 'w';
//						break;
//					case 1:
//						ch = 'y';
//						break;
//					case 2:
//						ch = 'r';
//						break;
//					case 3:
//						ch = 'o';
//						break;
//					case 4:
//						ch = 'g';
//						break;
//					case 5:
//						ch = 'b';
//						break;
//					}
//					System.out.print(ch + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
//		
//		System.out.println("=======================================");
	}

	private static void turnU(char dir) {
		if (dir == '-') {
			
			// 앞이 기준
			int temp1 = cube[2][0][0];
			int temp2 = cube[2][0][1];
			int temp3 = cube[2][0][2];
			
			// 4 -> 2 (왼 -> 앞)
			cube[2][0][0] = cube[4][0][2];
			cube[2][0][1] = cube[4][1][2];
			cube[2][0][2] = cube[4][2][2];
			
			// 3 -> 4 (뒤 -> 왼)
			cube[4][0][2] = cube[3][2][2];
			cube[4][1][2] = cube[3][2][1];
			cube[4][2][2] = cube[3][2][0];
			
			// 5 -> 3 (오 -> 뒤)
			cube[3][2][2] = cube[5][2][0];
			cube[3][2][1] = cube[5][1][0];
			cube[3][2][0] = cube[5][0][0];
			
			// 2 -> 5 (앞 -> 오)
			cube[5][2][0] = temp1;
			cube[5][1][0] = temp2;
			cube[5][0][0] = temp3;
			
//			counterClock(cube[0]);
			counterClock(0);
		} else {
			
			// 앞이 기준
			int temp1 = cube[2][0][0];
			int temp2 = cube[2][0][1];
			int temp3 = cube[2][0][2];
			
			// 5 -> 2 (오 -> 앞)
			cube[2][0][0] = cube[5][2][0];
			cube[2][0][1] = cube[5][1][0];
			cube[2][0][2] = cube[5][0][0];
			
			// 3 -> 5 (뒤 -> 오)
			cube[5][2][0] = cube[3][2][2];
			cube[5][1][0] = cube[3][2][1];
			cube[5][0][0] = cube[3][2][0];
			
			// 4 -> 3 (왼 -> 뒤)
			cube[3][2][2] = cube[4][0][2];
			cube[3][2][1] = cube[4][1][2];
			cube[3][2][0] = cube[4][2][2];
			
			// 2 -> 4 (앞 -> 왼)
			cube[4][0][2] = temp1;
			cube[4][1][2] = temp2;
			cube[4][2][2] = temp3;
			
//			clock(0);
			clock(0);
		}
		
//		// 임시 출력
//		for (int[][] is : cube) {
//			for (int[] is2 : is) {
//				for (int i : is2) {
//					char ch = '\u0000';
//					switch (i) {
//					case 0:
//						ch = 'w';
//						break;
//					case 1:
//						ch = 'y';
//						break;
//					case 2:
//						ch = 'r';
//						break;
//					case 3:
//						ch = 'o';
//						break;
//					case 4:
//						ch = 'g';
//						break;
//					case 5:
//						ch = 'b';
//						break;
//					}
//					System.out.print(ch + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
//		
//		System.out.println("=======================================");
	}
	
	private static void counterClock(int n) {
		int[][] ex  = cube[n].clone();
		int R = ex[0].length;
		int C = ex.length;
		cube[n] = new int[R][C];
		
		for (int i = 0; i < ex.length; i++) {
			for (int j = 0; j < ex[i].length; j++) {
				cube[n][R - 1 - j][i] = ex[i][j];
			}
		}				
	}

	private static void clock(int n) {
		int[][] ex  = cube[n].clone();
		int R = ex[0].length;
		int C = ex.length;
		cube[n] = new int[R][C];
		
		for (int i = 0; i < ex.length; i++) {
			for (int j = 0; j < ex[i].length; j++) {
				cube[n][j][C - 1 - i] = ex[i][j];
			}
		}
	}

}
