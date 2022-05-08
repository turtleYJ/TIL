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
	static boolean[] isVisit;
	static boolean[][] isVisit2;
	static ArrayList<Integer>[] line;
	static StringBuilder sb;
	static int[][] apt;
	static List<Integer> result;

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
		
		// 2667
		int N = 0;
		
		N = Integer.parseInt(br.readLine());
		
		apt = new int[N][N];
		isVisit2 = new boolean[N][N];
		
		int i = 0;
		while(N-- > 0) {
			String floor = br.readLine();
			
			for(int j = 0; j < floor.length(); j++) {
				apt[i][j] = floor.charAt(j) - 48;
			}
			
			i++;
		}
		
		// 입력 확인 출력
//		for(int j = 0; j < apt.length; j++) {
//			for(int k = 0; k < apt[j].length; k++) {
//				System.out.print(apt[j][k]);
//			}
//			System.out.println();
//		}
		
		StringBuilder sb = new StringBuilder();
		result = new ArrayList<>();
		
		dfs();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
private static void dfs() {
	int count = 0;
	
	for(int i = 0; i < apt.length; i++) {
		for(int j = 0; j < apt[i].length; j++) {
			if(isVisit2[i][j] == false && apt[i][j] == 1) {
				isVisit2[i][j] = true;
				
			}
		}
	}
		
	}






//	private static int dfs() {
//		
//	}
	
	
	
	


	private static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		isVisit[1] = true;
		int count = 0;
		
		q.offer(1);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i = 0; i < line[x].size(); i++) {
				int k = line[x].get(i);
				
				if(isVisit[k] == false) {
					q.offer(k);
					isVisit[k] = true;
					count++;
				}
				
			}
		}
		
		return count;
	}













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
