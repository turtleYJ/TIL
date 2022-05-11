package com.study.yooil.BAEKJOON.step8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
//		// 1. 소수 찾기
//		int count = 0;
//		
//		try {
//			int N = Integer.parseInt(br.readLine());
//			
//			String[] strArr = new String[N];
//			int[] intArr = new int[N];
//			
//			strArr = br.readLine().split(" ");
//			
//			for(int i = 0; i < strArr.length; i++) {
//				intArr[i] = Integer.parseInt(strArr[i]);
//			}
//			
//			for(int i = 0; i < intArr.length; i++) {
//				if(intArr[i] == 1) {
//					continue;
//				} else if(intArr[i] == 2) {
//					count++;
//				} else {
//					count++;
//					
//					for(int j = 2; j < intArr[i]; j++) {
//						if(intArr[i] % j == 0) {
//							count--;
//							
//							break;
//						}
//					}
//				}
//			}
//			
//			System.out.println(count);
//			
//			
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		// 2. 소수
//		int M = 0;
//		int N = 0;
//		int count = 0;
//		int sum = 0;
//		int minV = 0;
//		
//		try {
//			M = Integer.parseInt(br.readLine());
//			N = Integer.parseInt(br.readLine());
//			
//			if(M <= N) {
//				// 최소값
//				int k = M;
//				while(k <= N) {
//					count = 0;
//					for(int j = 1; j <= k; j++) {
//						if(k % j == 0) {
//							
//							count++;
//						}
//					}
//
//					if(count ==2) {
//						minV = k;
//						
//						break;
//					}
//					
//					k++;
//				}
//				
//				// 합산
//				for(int i = M; i <= N; i++) {
//						count = 0;
//						for(int j = 1; j <= i; j++) {
//							if(i % j == 0) {
//								
//								count++;
//							}
//						}
//						
//						if(count == 2) {
//							sum += i;
//						}
//				}
//				
//			} else { 
//				System.out.println("M은 N보다 작거나 같아야 합니다.");
//			}
//			
//			if(sum == 0) {
//				System.out.println("-1");
//			} else {
//				System.out.println(sum);
//				System.out.println(minV);
//			}
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
//		// 3. 소인수분해
//		int N = 0;
//		int temp = 0;
//		
//		try {
//			N = Integer.parseInt(br.readLine());
//			
//			temp = N;
//			
//			Roop1:
//			for(int i = 2; i <= N; i++) {
//				
//				while(temp % i == 0) {
//					temp /= i;
//					
//					System.out.println(i);
//					
//					if(temp == 1) {
//						break Roop1;
//					}
//				}
//				
//			}
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		// 4. 소수 구하기 (에라토스테네스의 체)
//		int M = 0;
//		int N = 0;
//		
//			StringTokenizer st;
//			try {
//				st = new StringTokenizer(br.readLine(), " ");
//				
//				M = Integer.parseInt(st.nextToken());
//				N = Integer.parseInt(st.nextToken());
//				
//				boolean arr[] = new boolean[N+1]; // 최대치의 수 만큼 배열 할당
//				
//				arr[0] = true;
//				arr[1] = true;
//				
//				for(int i = 2; i <= Math.sqrt(N+1); i++) {
//					// 아래에서 i의 제곱수 부터 검사를 시작함으로 전체범위의 제곱근까지 검사함.
//					for(int j = i*i; j < N+1; j += i) {
//						arr[j] = true;
//					}
//				}
//				
//				for(int i = M; i < N + 1; i++) {
//					if(arr[i] == false) {
//						System.out.println(i);
//					}
//				}
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
//		// 5. 베트트랑 공준
//			try {
//				
//				
//				while(true) {
//					int n = 0;
//					int count = 0;
//					
//					n = Integer.parseInt(br.readLine());
//					
//					if(n == 0) break;
//					
//					boolean[] arr = new boolean[2*n+1];
//					
//					arr[0] = true;
//					arr[1] = true;
//					
//					for(int i = 2; i < Math.sqrt(2*n+1); i++) {
//						for(int j = i*i; j < 2*n+1; j += i) {
//							arr[j] = true;
//						}
//					}
//					
//					for(int i = n+1; i < 2*n+1; i++) {
//						if(arr[i] == false) {
//							count++;
//						}
//					}
//					
//					System.out.println(count);
//				}
//				
//				
//				
//			} catch (NumberFormatException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
//		// 6. 골드바흐의 추측
//		int n = 0; // 테스트의 수
//		StringBuilder sb = new StringBuilder();
//		
//		try {
//			// 테스트 횟수 입력
//			n = Integer.parseInt(br.readLine());
//			
////			int[] arr = new int[n];
//			
////			// 테스트 수 입력
////			for(int i = 0; i < arr.length; i++) {
////				arr[i] = Integer.parseInt(br.readLine());
////			}
//			
//			// 소수 입력
//			boolean[] bArr = new boolean[10000 + 1];
//			
//			bArr[0] = true;
//			bArr[1] = true;
//			
//			for(int i = 2; i < Math.sqrt(10000 + 1); i++) {
//				if(bArr[i]) continue;
//				
//				for(int j = i*i; j < 10000 + 1; j += i) {
//					bArr[j] = true;
//				}
//			}
//			//
//			
//			while(true) {
//				if(n == 0) {
//					break;
//				}
//				
//				int num = 0;
//				int A = 0;
//				int B = 0;
//				
//				num = Integer.parseInt(br.readLine());
//				
//				
//				A = B = num / 2;
//				
//				if(bArr[A] == false) {
//					sb.append(A + " " + B).append("\n");
//				} else {
//					while(true) {
//						A--;
//						B++;
//						if(bArr[A] == false && bArr[B] == false) {
//							sb.append(A + " " + B).append("\n");
//							
//							break;
//						}
//					}
//				}
//				
//				
//				
//				n--;
//			}
//			
//			System.out.println(sb);
//			
////			for(int i = 0; i < arr.length; i++) {
////				
////				
////				for(int j = 0; j < arr[i] + 1; j++) {
////					if(bArr[j] == false) {
////						System.out.println(j);
////					}
////				}
////			}
//			
//			
//			
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		// 7. 직사각형에서 탈출
//		int x = 0;
//		int y = 0;
//		int w = 0;
//		int h = 0;
//		ArrayList<Integer> arr = new ArrayList<Integer>();
//		
//		try {
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//			
//			x = Integer.parseInt(st.nextToken());
//			y = Integer.parseInt(st.nextToken());
//			w = Integer.parseInt(st.nextToken());
//			h = Integer.parseInt(st.nextToken());
//			
//			// x, y, w-x, h-x
//			arr.add(x);
//			arr.add(y);
//			arr.add(w-x);
//			arr.add(h-y);
//			
//			Collections.sort(arr);
//			
//			System.out.println(arr.get(0));
//			
//			
//			
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		// 8. 네 번째 점
//		int[] arrX = new int[1001];
//		int[] arrY = new int[1001];
//		int X = 0;
//		int Y = 0;
//		
//		for(int i = 0; i < 1001; i++) {
//			arrX[i] = 0;
//			arrY[i] = 0;
//		}
//		
//		int n = 3;
//		
//		while(true) {
//			if(n == 0) break;
//			
//			try {
//				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//				
//				int x = Integer.parseInt(st.nextToken());
//				int y = Integer.parseInt(st.nextToken());
//				
//				arrX[x]++;
//				arrY[y]++;
//				
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			n--;
//		}
//		
//		
//		for(int i = 0; i < 1001; i++) {
//			if(arrX[i] == 1) {
//				X = i;
//				
//				break;
//			}
//		}
//		
//		for(int i = 0; i < 1001; i++) {
//			if(arrY[i] == 1) {
//				Y = i;
//				
//				break;
//			}
//		}
//		
//		System.out.println(X + " " + Y);
				
//		// 9. 직각삼각형
//		int x = 0;
//		int y = 0;
//		int z = 0;
//		StringBuilder sb = new StringBuilder();
//		
//		
//		while(true) {
//			try {
//				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//				
//				x = Integer.parseInt(st.nextToken());
//				y = Integer.parseInt(st.nextToken());
//				z = Integer.parseInt(st.nextToken());
//				
//				if(x == 0 && y == 0 && z == 0) break;
//				
//				if(z*z == x*x + y*y) {
//					sb.append("right\n");
//				} else if(x*x == z*z + y*y) {
//					sb.append("right\n");
//				} else if(y*y == z*z + x*x) {
//					sb.append("right\n");
//				} else {
//					sb.append("wrong\n");
//				}
//				
//				
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//		}
//		
//		System.out.println(sb);
		
//		// 10. 택시 기하학
//		int n = 0;
//		
//		try {
//			n = Integer.parseInt(br.readLine());
//			
//			System.out.println((double)n*n*Math.PI);
//			System.out.println((double)n*n*2);
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		// 11. 터렛
//		int n = 0;
//		int x1 = 0;
//		int x2 = 0;
//		int y1 = 0;
//		int y2 = 0;
//		int r1 = 0;
//		int r2 = 0;
//		double dist = 0;
//		
//		StringBuilder sb = new StringBuilder();
//		
//		try {
//			n = Integer.parseInt(br.readLine());
//			
//			while(true) {
//				if(n == 0) break;
//				
//				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//				
//				x1 = Integer.parseInt(st.nextToken());
//				y1 = Integer.parseInt(st.nextToken());
//				r1 = Integer.parseInt(st.nextToken());
//				x2 = Integer.parseInt(st.nextToken());
//				y2 = Integer.parseInt(st.nextToken());
//				r2 = Integer.parseInt(st.nextToken());
//				
//				dist = Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
//				
//				Math.sqrt(Math.pow(r2 - r1, 2)); 
//				
//				if(x1 == x2 && y1 == y2 && r1 == r2) {
//					sb.append(-1).append("\n");
//				} else if(dist < Math.sqrt(Math.pow(r2 - r1, 2))) {
//					sb.append(0).append("\n");
//				} else if(dist == Math.sqrt(Math.pow(r2 - r1, 2))) {
//					sb.append(1).append("\n");
//				} else if(dist < r1 + r2) {
//					sb.append(2).append("\n");
//				} else if(dist == r1 + r2) {
//					sb.append(1).append("\n");
//				} else {
//					sb.append(0).append("\n");
//				}
//				
//				
//					
//				
//				n--;
//			}
//			
//			System.out.println(sb);
//			
//			
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
