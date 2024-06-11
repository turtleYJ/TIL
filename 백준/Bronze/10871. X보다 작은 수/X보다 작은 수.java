
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int a = 0;
//		
//		a = sc.nextInt();
//		
//		for (int i = 1; i < 10; i++) {
//			System.out.printf("%d * %d = %d\n", a, i, a*i);
//		}
		
		// 2. A + B
//		Scanner sc = new Scanner(System.in);
//		int T = 0;
//		
//		T = sc.nextInt();
//		
//		int[] A = new int[T];
//		int[] B = new int[T];
//		
//		for(int i = 0; i < T; i++) {
//			A[i] = sc.nextInt();
//			B[i] = sc.nextInt();
//		}
//		
//		for(int i = 0; i < T; i++) {
//			System.out.println(A[i] + B[i]);
//		}
		
		// 3. 합
//		Scanner sc = new Scanner(System.in);
//		int n = 0;
//		int sum = 0;
//		
//		n = sc.nextInt();
//		
//		for(int i = 1; i < n+1; i++) {
//			sum += i;
//		}
//		
//		System.out.println(sum);
		
		
		// 4. 빠른 A + B
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int T = 0;
//		
//		try {
//			T = Integer.parseInt(br.readLine());
//			int[] A = new int[T];
//			int[] B = new int[T];
//			String[] arr = new String[2];
//			
//			for(int i = 0; i < T; i++) {
//				arr = br.readLine().split(" ");
//				A[i] = Integer.parseInt(arr[0]); 
//				B[i] = Integer.parseInt(arr[1]); 
//			}
//			
//			for(int i = 0; i < T; i++) {
//				bw.write(A[i] + B[i] + "\n");
//			}
//			
//			bw.flush();
//		} catch (NumberFormatException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		
		// 5. N 찍기
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		int N = 0;
//		int i = 1;
//		
//		try {
//			N = Integer.parseInt(br.readLine());
//			
//			while(i<=N && N <= 100000) {
//				bw.write(i + "\n");
//				i += 1;
//			}
//			
//			bw.flush();
//		} catch (NumberFormatException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		
		// 6. 기찍 N
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		int N = 0;
//		
//		
//		try {
//			N = Integer.parseInt(br.readLine());
//			
//			while(N > 0 && N <= 100000) {
//				bw.write(N + "\n");
//				N -= 1;
//			}
//			
//			bw.flush();
//		} catch (NumberFormatException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		
		// 7. A + B - 7
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		int T = 0;
//		
//		try {
//			T= Integer.parseInt(br.readLine());
//			
//			int[] A = new int[T];
//			int[] B = new int[T];
//			String[] arr = new String[2];
//			
//			for(int i = 0; i < T; i++) {				
//				arr =  br.readLine().split(" ");
//				A[i] = Integer.parseInt(arr[0]);
//				B[i] = Integer.parseInt(arr[1]);
//			}			
//					
//			for(int i = 0; i < T; i++) {
//				if(A[i] > 0 && A[i] < 10 && B[i] > 0 && B[i] < 10) {					
//					bw.write("Case #" + (i+1) + ": " + (A[i] + B[i]) + "\n");
//				} else {
//					bw.write("다시 입력하시오 \n");
//				}
//			}
//			
//			
//			bw.flush();
//		} catch (NumberFormatException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// 8. A + B - 8
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
//		
//		int T = 0;
//		
//		try {
//			T= Integer.parseInt(br.readLine());
//			
//			int[] A = new int[T];
//			int[] B = new int[T];
//			String[] arr = new String[2];
//			
//			for(int i = 0; i < T; i++) {				
//				arr =  br.readLine().split(" ");
//				A[i] = Integer.parseInt(arr[0]);
//				B[i] = Integer.parseInt(arr[1]);
//			}			
//					
//			for(int i = 0; i < T; i++) {
//				if(A[i] > 0 && A[i] < 10 && B[i] > 0 && B[i] < 10) {					
//					pw.printf("Case #%d: %d + %d = %d\n", i+1, A[i], B[i], A[i] + B[i]);
//				} else {
//					bw.write("다시 입력하시오 \n");
//				}
//			}
//			
//			
//			bw.flush();
//			pw.flush();
//		} catch (NumberFormatException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		// 9. 별 찍기 - 1
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
//		
//		int N = 0;
//		
//		try {
//			N = Integer.parseInt(br.readLine());
//			
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < i+1; j++) {
//					bw.write("*");
//				}
//				bw.write("\n");
//			}
//			
//			bw.flush();
//		} catch (NumberFormatException | IOException e) {
//			e.printStackTrace();
//		}
		
		// 10. 별 찍기 - 2
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
//		
//		int N = 0;
//		
//		try {
//			N = Integer.parseInt(br.readLine());
//			
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N-1-i; j++) {
//					bw.write(" ");
//				}
//				for(int k = 0; k < i+1; k++) {
//					bw.write("*");
//				}
//				bw.write("\n");
//			}
//			
//			bw.flush();
//		} catch (NumberFormatException | IOException e) {
//			e.printStackTrace();
//		}
		
		// 11. X보다 작은 수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
		
		int N = 0;
		int X = 0;
		String[] arr1 =  new String[2];
		
		try {
			arr1 = br.readLine().split(" ");
			N = Integer.parseInt(arr1[0]);
			X = Integer.parseInt(arr1[1]);
			
			String[] arr2 =  new String[N];
			
			arr2 = br.readLine().split(" ");
			
			for(int i = 0; i < N; i++) {
				if(Integer.parseInt(arr2[i]) < X) {
					bw.write(arr2[i] + " ");
				}
			}
			
			bw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}