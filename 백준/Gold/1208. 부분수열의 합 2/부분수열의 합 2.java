import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//부분수열의 합
//인풋 갯수가 40개 임으로
//백트래킹 알고리즘으로 풀게되면 2^40으로 시간 제한을 초과하게 된다.
//이를 이분탐색, 즉 반으로 나누어 각각의 부분수열의 합 리스트를 만들고
//이 두 리스트들을 투 포인터 알고리즘을 통해 S값과 일치하는 합을 찾는다.
public class Main {

	private static long res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int n1 = N / 2;
		int n2 = N - n1;
		int S = Integer.parseInt(st.nextToken());
		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n1; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n2; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.print("arr1 : ");
//		for (int i : arr1) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		System.out.print("arr2 : ");
//		for (int i : arr2) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
		
		List<Long> sumList1 = new ArrayList<>();
		List<Long> sumList2 = new ArrayList<>();
		
		makeSum(0, n1, 0, arr1, sumList1);
		makeSum(0, n2, 0, arr2, sumList2);
		
		Collections.sort(sumList1);
		Collections.sort(sumList2);
		
//		System.out.println(sumList1);
//		System.out.println(sumList2);
		
		// 두 리스트를 이용해서 투 포인터 알고리즘을 통해 합이 S인 것을 찾아낸다.
		res = 0;
//		twoPoint(S, sumList1, sumList2);
		res = getCnt(S, sumList1, sumList2);
		
		if(S == 0) res--;
		
		System.out.println(res);
		
		
	}

//	private static void twoPoint(int s, List<Long> sumList1, List<Long> sumList2) {
//		int i = 0;
//		int n = sumList1.size();
//		int j = sumList2.size() - 1;
//		
//		while (i < n && j >= 0) {
//			long sum = sumList1.get(i) + sumList2.get(j);
//			if (sum == s) res++;
//			if(i == n - 1) {
//				j--;
//				continue;
//			}
//			if(j == 0) {
//				i++;
//				continue;
//			}
//			if (sum >= s) {
//				j--;
//			} else {
//				i++;
//			}
//			
//		}
//	}
	
	public static long getCnt(int S, List<Long> right, List<Long> left) {

		int pl = 0;
		int pr = right.size() - 1;
		long cnt = 0;

		while (pl < left.size() && pr >= 0) {

			long sum = left.get(pl) + right.get(pr);

			if (sum == S) {
				long a = left.get(pl);
				long cnt1 = 0;
				while (pl < left.size() && left.get(pl) == a) {
					pl++;
					cnt1++;
				}

				long b = right.get(pr);
				long cnt2 = 0;
				while (pr >= 0 && right.get(pr) == b) {
					pr--;
					cnt2++;
				}

				cnt += cnt1 * cnt2;
			}

			else if (sum < S)
				pl++;
			else
				pr--;
		}

		return cnt;
	}

	private static void makeSum(int idx, int end, long sum, int[] arr, List<Long> sumList) {
		
		if(idx == end) {
			sumList.add(sum);
			return;
		}
		
		makeSum(idx + 1, end, sum + arr[idx], arr, sumList);
		makeSum(idx + 1, end, sum, arr, sumList);
	}
}
