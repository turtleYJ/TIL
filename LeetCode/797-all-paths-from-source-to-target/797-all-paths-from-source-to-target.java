class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
		ArrayList<Integer> localList = new ArrayList<>();
		boolean[] isVisit = new boolean[graph.length];
		
		isVisit[0] = true;
		localList.add(0);
		goLastNode(graph, 0, localList, result, isVisit);
        
        return result;
    }
    
    private static void goLastNode(int[][] graph, int node, ArrayList<Integer> localList, List<List<Integer>> result, boolean[] isVisit) {
		if(node == graph.length - 1) {
			result.add((List<Integer>)localList.clone());
			
			return;
		}
		
		int[] paths = graph[node];
		
		for (int i = 0; i < paths.length; i++) {
			int nextNode = paths[i];
			if(!isVisit[nextNode]) {
				localList.add(nextNode);
				isVisit[nextNode] = true;
				goLastNode(graph, nextNode, localList, result, isVisit);
				localList.remove(Integer.valueOf(nextNode));
				isVisit[nextNode] = false;
			}
		}
	}
}