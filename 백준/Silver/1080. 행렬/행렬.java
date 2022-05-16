import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N  = 0;
		int M  = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boolean[][] matA = new boolean[N][M];
		boolean[][] matB = new boolean[N][M];
		
		String S = "";
		
		for(int i = 0; i < N; i ++) {
			S = br.readLine();
			for(int j = 0; j < M; j++) {
				if(S.charAt(j) == '0') {
					matA[i][j] = false;
				} else {
					matA[i][j] = true;
				}
			}
		}
		
		for(int i = 0; i < N; i ++) {
			S = br.readLine();
			for(int j = 0; j < M; j++) {
				if(S.charAt(j) == '0') {
					matB[i][j] = false;
				} else {
					matB[i][j] = true;
				}
			}
		}
		
		int count = 0;
		
		for(int i = 0; i < N - 2; i ++) {
			for(int j = 0; j < M - 2; j++) {
				if(matA[i][j] != matB[i][j]) {
					matA[i][j] = !matA[i][j];
					matA[i][j + 1] = !matA[i][j + 1];
					matA[i][j + 2] = !matA[i][j + 2];
					matA[i + 1][j] = !matA[i + 1][j];
					matA[i + 1][j + 1] = !matA[i + 1][j + 1];
					matA[i + 1][j + 2] = !matA[i + 1][j + 2];
					matA[i + 2][j] = !matA[i + 2][j];
					matA[i + 2][j + 1] = !matA[i + 2][j + 1];
					matA[i + 2][j + 2] = !matA[i + 2][j + 2];
					
					count++;
				}
			}
		}
		
		boolean equals = true;
		
		roof:
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < M; j++) {
				if(matA[i][j] != matB[i][j]) {
					equals = false;
					
					break roof;
				}
			}
		}
		
		if(equals) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}
		
	}
	
}