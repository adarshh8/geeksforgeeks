class Solution {
  public:
    vector<int> dijkstra(int V, vector<vector<int>> &edges, int src) {
        
        vector<vector<pair<int,int>>> adj(V);
        for(int i = 0; i < edges.size(); i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj[u].push_back({v, w});
            adj[v].push_back({u, w});
        }

        vector<int> dist(V, INT_MAX);
        dist[src] = 0;

        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
        pq.push({0, src});

        while(!pq.empty()){
            int node = pq.top().second;
            int d = pq.top().first;
            pq.pop();

            if(d > dist[node]) continue;

            for(int j = 0; j < adj[node].size(); j++){
                int neighbour = adj[node][j].first;
                int weight = adj[node][j].second;

                if(dist[node] + weight < dist[neighbour]){
                    dist[neighbour] = dist[node] + weight;
                    pq.push({dist[neighbour], neighbour});
                }
            }
        }

        return dist;
    }
};