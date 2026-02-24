import java.util.*;

class Solution {

    public void dfsTraversal(int node, ArrayList<ArrayList<Integer>> adj, 
                             boolean[] visited, ArrayList<Integer> ans) {

        visited[node] = true;
        ans.add(node);

        for (int i = 0; i < adj.get(node).size(); i++) {
            int nextNode = adj.get(node).get(i);

            if (!visited[nextNode]) {
                dfsTraversal(nextNode, adj, visited, ans);
            }
        }
    }

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {

        int v = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfsTraversal(i, adj, visited, ans);
            }
        }

        return ans;
    }
}