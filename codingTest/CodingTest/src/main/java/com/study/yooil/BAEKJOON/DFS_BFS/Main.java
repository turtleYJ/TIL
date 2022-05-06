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
	static ArrayList<Integer>[] line;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1260
		int N = 0; // 정점의 개수
		int M = 0; // 간선의 개수
		int V = 0; // 시작할 번호
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		line = new ArrayList[N + 1];
		isVisit = new boolean[N + 1];
		
		for(int i = 0; i < line.length; i++) {
			line[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			line[a].add(b);
			line[b].add(a);
		}
		
		for(int i = 0; i < line.length; i++) {
			Collections.sort(line[i]);
		}
		
		DFS(V);
		
		sb.append('\n');
		
		isVisit = new boolean[N + 1];
		
		BFS(V);
		
		System.out.println(sb);
	}
	
	
	
	
	
	
	
	
	
	
	


	// 꼬리를 물고 따라가는 방식
	private static void DFS(int start) {
		isVisit[start] = true;
		
		sb.append(start + " ");
		
		for(int i = 0; i < line[start].size(); i++) {
			if(isVisit[line[start].get(i)] == false) {
				DFS(line[start].get(i));
			}
		}
	}

	// 계단식으로 한칸씩 방문하는 방식
	private static void BFS(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		isVisit[start] = true;
		
		q.offer(start);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			sb.append(x + " ");
			
			for(int i = 0; i < line[x].size(); i++) {
				int y = line[x].get(i);
				
				if(isVisit[y] == false) {
					q.offer(y);
					isVisit[y] = true;
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
