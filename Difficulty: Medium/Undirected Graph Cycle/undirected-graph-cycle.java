import java.util.*;

class Solution {

    private boolean getAns(int x, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int V) {

        Queue<Integer> q = new LinkedList<>();
        int[] parent = new int[V];

        q.add(x);
        parent[x] = -1;
        vis[x] = true;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int i : adj.get(node)) {

                if (vis[i] && parent[node] != i) return true;

                if (vis[i]) continue;

                q.add(i);
                vis[i] = true;
                parent[i] = node;
            }
        }
        return false;
    }

    public boolean isCycle(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (getAns(i, vis, adj, V)) return true;
            }
        }

        return false;
    }
}