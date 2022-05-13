package com.study.yooil.BAEKJOON.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
//	static boolean[] isVisit;
	static boolean[][] isVisit2;
//	static ArrayList<Integer>[] line;
//	static StringBuilder sb;
//	static int[][] apt;
//	static List<Integer> result;
//	static int[][] square;
//	static int[][] map;
	static int[][] field;
//	static int hNum; 
	static int dx[];
	static int dy[];
	static int N;
	static int M;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		// 1260
//		int N = 0; // 정점의 개수
//		int M = 0; // 간선의 개수
//		int V = 0; // 시작할 번호
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		sb = new StringBuilder();
//		
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		V = Integer.parseInt(st.nextToken());
//		
//		line = new ArrayList[N + 1];
//		isVisit = new boolean[N + 1];
//		
//		for(int i = 0; i < line.length; i++) {
//			line[i] = new ArrayList<>();
//		}
//		
//		for(int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			
//			line[a].add(b);
//			line[b].add(a);
//		}
//		
//		for(int i = 0; i < line.length; i++) {
//			Collections.sort(line[i]);
//		}
//		
//		DFS(V);
//		
//		sb.append('\n');
//		
//		isVisit = new boolean[N + 1];
//		
//		BFS(V);
//		
//		System.out.println(sb);
		
//		// 2606
//		int N = 0;
//		int M = 0;
//		sb = new StringBuilder();
//		
//		N = Integer.parseInt(br.readLine());
//		M = Integer.parseInt(br.readLine());
//		
//		line = new ArrayList[N + 1];
//		isVisit = new boolean[N + 1];
//		
//		for(int i = 0; i < line.length; i++) {
//			line[i] = new ArrayList<>();
//		}
//		
//		for(int i = 0; i < M; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			
//			line[a].add(b);
//			line[b].add(a);
//		}
//		
//		for(int i = 0; i < line.length; i++) {
//			Collections.sort(line[i]);
//		}
//		
//		System.out.println(bfs());
		
//		// 2667
//		int N = 0;
//		
//		N = Integer.parseInt(br.readLine());
//		
//		apt = new int[N][N];
//		isVisit2 = new boolean[N][N];
//		
//		int i = 0;
//		while(N-- > 0) {
//			String floor = br.readLine();
//			
//			for(int j = 0; j < floor.length(); j++) {
//				apt[i][j] = floor.charAt(j) - 48;
//			}
//			
//			i++;
//		}
//		
//		// 입력 확인 출력
////		for(int j = 0; j < apt.length; j++) {
////			for(int k = 0; k < apt[j].length; k++) {
////				System.out.print(apt[j][k]);
////			}
////			System.out.println();
////		}
//		
//		StringBuilder sb = new StringBuilder();
//		result = new ArrayList<>();
//		
//		dfs();
		
//		// 16173 점프왕 쪨리(Small)
//		int N = Integer.parseInt(br.readLine());
//		
//		square = new int[N][N];
//		isVisit2 = new boolean[N][N];
//		
//		for(int i = 0; i < N; i++) {//			
//			StringTokenizer st = new StringTokenizer(br.readLine());//	
		
//			for(int j = 0; j < N; j++) {//				
//				square[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		
////		for (int[] is : square) {
////			for (int i : is) {
////				System.out.print(i + " ");
////			}
////			
////			System.out.println();
////		}
//		
//		boolean result = bfs(0, 0 , N);
//		
//		if(result) {
//			System.out.println("HaruHaru");
//		} else {
//			System.out.println("Hing");
//		}
		
//		// 2667 단지번호붙이기
//		N = 0;
//		
//		N = Integer.parseInt(br.readLine());
//		
//		map = new int[N][N];
//		isVisit2 = new boolean[N][N];
//		dx = new int[] {0, 0, 1, -1};
//		dy = new int[] {1, -1, 0, 0};
//		
//		for(int i = 0; i < N; i++) {			
//			String S = br.readLine();
//			
//			for(int j = 0; j < N; j++) {				
//				map[i][j] = S.charAt(j) - 48;
//			}
//		}
//		
//		int cNum = 0; // 단지수
//		List<Integer> aptNum = new ArrayList<Integer>();
//		
//		for(int i = 0; i < N; i++) {			
//			for(int j = 0; j < N; j++) {	
//				if(map[i][j] == 1 && !isVisit2[i][j]) {
//					hNum = 0;					
//					dfs(i, j);
//					
//					aptNum.add(hNum);
//					
//					cNum++;
//				}
//			}
//		}
//		
//		Collections.sort(aptNum);
//		
//		
//		System.out.println(cNum);
//		
//		
//		for (Integer i : aptNum) {
//			System.out.println(i);
//		}
		
		// 1012 유기농 배추
		int T = 0;
		StringBuilder sb = new StringBuilder();
		
		dx = new int[] {0, 0, 1, -1};
		dy = new int[] {1, -1, 0, 0};
		
		T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			field = new int[M][N];
			isVisit2 = new boolean[M][N];
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); // 가로
				int y = Integer.parseInt(st.nextToken()); // 세로
				
				field[x][y] = 1;
			}
			
			int count = 0;
			
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(field[i][j] == 1 && !isVisit2[i][j]) {
						dfs(i, j);
						
						count++;
					}
				}
			}
			
			sb.append(count).append('\n');
			
			
		}
		
		System.out.println(sb);
		
		
		
		
		
		
		
	}
	
	
	
	// 1012
	private static void dfs(int x, int y) {
		isVisit2[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if(newX >= 0 && newX < M && newY >= 0 && newY < N) {
				if(field[newX][newY] == 1 && !isVisit2[newX][newY]) {
					dfs(newX, newY);
				}
			}
		}
		
	}


	
	
	
	
//	// 2667
//	private static void dfs(int r, int c) {
//		hNum++;
//		 // 단지 내 집의 수
//		isVisit2[r][c] = true;
//		
//		for(int i = 0; i < 4; i++) {
//			int tempR = r + dx[i];
//			int tempC = c + dy[i];
//			
//			if(tempR >= 0  && tempR < N && tempC >= 0  && tempC < N) {
//				if(map[tempR][tempC] == 1 && !isVisit2[tempR][tempC]) {
//					dfs(tempR, tempC);
//					
//				}
//			}
//		}
//	}
	
	
//	// 16173
//	private static boolean bfs(int row, int column, int len) {
//		Queue<int[]> q = new LinkedList<>();
//		q.offer(new int[] {row, column});
//		
//		boolean success = false;
//		
//		while(!q.isEmpty()) {
//			int[] temp = q.poll();
//			int r = temp[0];
//			int c = temp[1];
//			
//			isVisit2[row][column] = true;
//			int move = square[r][c];
//			
//			if(square[r][c] == -1) {
//				success = true;
//				
//				break;
//			}
//			
//			int newR = r + move;
//			int newC = c + move;
//			
//			if(newR < len && !isVisit2[newR][c]) {
//				q.offer(new int[] {newR, c});
//				
//				isVisit2[newR][c] = true;
//			}
//			if(newC < len && !isVisit2[r][newC]) {
//				q.offer(new int[] {r, newC});
//				
//				isVisit2[r][newC] = true;
//			}
//			
//			
//			
//		}
//		
//		
//		return success;
//	}
	
	
//	private static void dfs() {
//		int count = 0;
//		
//		for(int i = 0; i < apt.length; i++) {
//			for(int j = 0; j < apt[i].length; j++) {
//				if(isVisit2[i][j] == false && apt[i][j] == 1) {
//					isVisit2[i][j] = true;
//				}
//			}
//		}
//	}






//	private static int dfs() {
//		
//	}
	
	
	
	


//	private static int bfs() {
//		Queue<Integer> q = new LinkedList<>();
//		isVisit[1] = true;
//		int count = 0;
//		
//		q.offer(1);
//		
//		while(!q.isEmpty()) {
//			int x = q.poll();
//			for(int i = 0; i < line[x].size(); i++) {
//				int k = line[x].get(i);
//				
//				if(isVisit[k] == false) {
//					q.offer(k);
//					isVisit[k] = true;
//					count++;
//				}
//				
//			}
//		}
//		
//		return count;
//	}













//	// 꼬리를 물고 따라가는 방식
//	private static void DFS(int start) {
//		isVisit[start] = true;
//		
//		sb.append(start + " ");
//		
//		for(int i = 0; i < line[start].size(); i++) {
//			if(isVisit[line[start].get(i)] == false) {
//				DFS(line[start].get(i));
//			}
//		}
//	}
//
//	// 계단식으로 한칸씩 방문하는 방식
//	private static void BFS(int start) {
//		Queue<Integer> q = new LinkedList<Integer>();
//		isVisit[start] = true;
//		
//		q.offer(start);
//		
//		while(!q.isEmpty()) {
//			int x = q.poll();
//			
//			sb.append(x + " ");
//			
//			for(int i = 0; i < line[x].size(); i++) {
//				int y = line[x].get(i);
//				
//				if(isVisit[y] == false) {
//					q.offer(y);
//					isVisit[y] = true;
//				}
//			}
//		}
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
