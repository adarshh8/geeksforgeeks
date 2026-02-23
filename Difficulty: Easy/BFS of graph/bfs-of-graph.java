class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        
        int v = adj.size();
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[v];
        
        q.offer(0);
        visited[0] = true;
        
        while(!q.isEmpty()){
            int node = q.poll();
            result.add(node);
            
            for(int i = 0; i < adj.get(node).size(); i++){
                int neighbor = adj.get(node).get(i);
                
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
        
        return result;
    }
}