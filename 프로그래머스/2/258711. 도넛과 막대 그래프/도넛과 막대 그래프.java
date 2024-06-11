import java.util.*;

class Solution {
	public int[] solution(int[][] edges) {
		int[] answer = new int[4];
        
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        int maxNodeNum = 0;
        Set<Integer> nodeSet = new HashSet<>();
		for (int[] edge : edges) {
			map.computeIfPresent(edge[0], (k, v) -> {
				v.add(edge[1]);
				return v;
			});
			if(!map.containsKey(edge[0])){
				ArrayList<Integer> list = new ArrayList<>();
				list.add(edge[1]);
				map.put(edge[0], list);
			}
            maxNodeNum = Math.max(maxNodeNum, Math.max(edge[0], edge[1]));
            nodeSet.add(edge[0]);
            nodeSet.add(edge[1]);
		}
        
        for (int key : map.keySet()) {
            for (int val : map.get(key)) {
                nodeSet.remove(Integer.valueOf(val));
            }
        }
        
        int maxSize = 0;
        for(int node : nodeSet){
            if(maxSize >= map.get(node).size()) continue;
            
            maxSize = map.get(node).size();
            answer[0] = node;
        }
        
        boolean[] isPassed = new boolean[maxNodeNum + 1];
        for(int node : map.get(answer[0])){
            int idx = 1;
            Queue<Integer> q = new LinkedList<>();
            q.add(node);
            isPassed[node] = true;
            while(!q.isEmpty()){
                
                int curNode = q.poll();
                
                if(!map.containsKey(curNode)) {
                    idx =  2;
                    break;
                }
                if(map.get(curNode).size() == 2){
                    idx =  3;
                    break;
                }
                
                int nextNode = map.get(curNode).get(0);
                if(isPassed[nextNode]) break;

                q.add(nextNode);
                isPassed[nextNode] = true;
            }
            answer[idx]++;
        }
        
		return answer;
	}
}
