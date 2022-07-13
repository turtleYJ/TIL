import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<double[]> rateArr = new ArrayList<>();
        int challenger = stages.length;
        
        for (int i = 1; i <= N; i++) {
			countMap.put(i, 0);
		}
        
        for (int i = 0; i < stages.length; i++) {
        	int stage = stages[i];
        	
			if (stage > N) continue;
			
			countMap.put(stage, countMap.get(stage) + 1);
		}
        
        for (int i = 1; i < N + 1; i++) {
        	if (challenger == 0) {
        		rateArr.add(new double[] {i, 0});
        		continue;
        	}
        	
			double rate = countMap.get(i) / (double)challenger;
			challenger -= countMap.get(i);
			rateArr.add(new double[] {i, rate});
		}
        
        Collections.sort(rateArr, new Comparator<double[]>() {

			@Override
			public int compare(double[] o1, double[] o2) {
				return (o2[1] - o1[1]) < 0 ? -1 : (o2[1] - o1[1]) == 0 ? 0 : 1;
			}
		});
        
        int[] answer = new int[N];
        for (int i = 0; i < rateArr.size(); i++) {
			answer[i] = (int)rateArr.get(i)[0];
		}
        
        return answer;
    }
}