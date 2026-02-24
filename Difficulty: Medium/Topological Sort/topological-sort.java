class Solution {
    
    void dfstraversal(int node,ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st) {
         visited[node] = true;
        for(int i = 0; i < adj.get(node).size(); i++) {
            int neighbour = adj.get(node).get(i);
            if(!visited[neighbour]) {
                dfstraversal(neighbour, adj, visited, st);
            }
        }
        
        st.push(node);
    }
    
    
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
       for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfstraversal(i, adj, visited, st);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
    }
}