package com.study.yooil.BAEKJOON.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int size;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 18258
		int N = 0;
		
		N = Integer.parseInt(br.readLine());
		LinkedList<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		arr = new int[N];
		
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			switch (st.nextToken()) {
			case "push":
				q.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				Integer it = q.poll();
				if (it == null) {
					sb.append(-1).append('\n');
				} else {
					sb.append(it).append('\n');
				}
				break;
			case "size":
				sb.append(q.size()).append('\n');
				break;
			case "empty":
				Integer It = q.size();
				if(It == 0) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			case "front":
				Integer IT = q.peek();
				if (IT == null) {
					sb.append(-1).append('\n');
				} else {
					sb.append(IT).append('\n');
				}
				break;
			case "back":
				Integer ite = q.peekLast();
				if(ite == null) {
					sb.append(-1).append('\n');
				} else {
					sb.append(ite).append('\n');
				}
				break;
			}
		}
		
		System.out.println(sb);
		
		
	}
	
}
