import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이전 순열
// 오름차순
// 1. 뒤에서부터 탐색하며 arr[i]보다 더 큰은 arr[i - 1]의 값을 찾는다.
// 2. i - 1보다 더 큰 인덱스중 arr[i - 1]보다 더 작은 값중 가장 큰 값과 swap한다.
// 3. i부터 arr.length - 1까지 순열들을 뒤집어 준다.(i부터 내림차순으로 정렬하기 위함)
public class Main {

	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean pass = true;
		for(int i = N - 1; i >= 1 ; i--) {
			if(arr[i] < arr[i - 1]) {
				int temp = arr[i - 1];
				
				// temp보다 작으면서 가장 큰 값의 인덱스를 찾는다.
				int idx = findNum(i ,temp);
				swap(i - 1, idx);
				reversePermutation(i);
				pass = false;
				break;
			}
		}
		
		if(pass) {
			System.out.println(-1);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i : arr) {
			sb.append(i + " ");
		}
		
		System.out.println(sb);
	}

	private static void reversePermutation(int i) {
		int start = i;
		int end = arr.length - 1;
		for (int j = 0; j < Math.ceil((double)(end - start) / 2); j++) {
			swap(start + j, end - j);
		}
	}

	private static void swap(int i, int idx) {
		int temp = arr[i];
		arr[i] = arr[idx];
		arr[idx] = temp;		
	}

	private static int findNum(int start, int temp) {
		for (int i = arr.length - 1; i >= start; i--) {
			if(arr[i] < temp) {
				return i;
			}
		}
		
		// 나올 일이 없음.
		return -1;
	}
}